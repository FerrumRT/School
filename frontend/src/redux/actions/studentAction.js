import Cookies from "js-cookies";
import * as actionTypes from "../actionTypes";
import axios from '../axios';
import { setSuccessMess } from "./supActions";

async function getAllStudentsAsync(search) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  if(search === undefined) search = "";
  let students = await axios.get(`http://localhost:8080/rest/students/all?search=${search}`);
  console.log(students.data);
  return students.data;
}

async function getStudentsAsync(group_id, search) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  if(search === undefined) search = "";
  let students = await axios.get(`http://localhost:8080/rest/students/all/${group_id}?search=${search}`);
  console.log(students.data);
  return students.data;
}

async function getStudentAsync(id) {
  axios.defaults.headers.common["Authorization"] = ``;
  let students = await axios.get(`http://localhost:8080/rest/students/${id}`);
  console.log(students.data);
  return students.data;
}

async function addStudentAsync(student) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  console.log(student.photo);
  let data = {
    "name":student.name,
    "surname":student.surname,
    "bdate":student.birthdate,
    "sgroup":student.group
  };
  await axios({
    url: `http://localhost:8080/rest/students/add`,
    method: "post",
    data: data
  });
}

async function deleteStudentAsync(id) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  axios.defaults.headers.common["Access-Control-Allow-Origin"] = "*";
  let status = await axios({
    url:`http://localhost:8080/rest/students/delete/${id}`,
    method:"DELETE"
  });
}

export const getAllStudents = (search) => async(dispatch, reducers) => {
  let students = await getAllStudentsAsync(search);
  await dispatch({"type" : actionTypes.STUDENT_LIST, "data" : students});
}

export const getStudents = (group_id, search) => async(dispatch, reducers) => {
  let students = await getStudentsAsync(group_id, search);
  await dispatch({"type" : actionTypes.STUDENT_LIST, "data" : students});
}

export const getStudent = (id) => async(dispatch, reducers) => {
  let student = await getStudentAsync(id);
  await dispatch({"type" : actionTypes.ONE_STUDENT, "data" : student});
}

export const deleteStudent = (id) => async(dispatch, reducers) => {
  await deleteStudentAsync(id);
  setSuccessMess("Delete complete")(dispatch, reducers);
}

export const addStudent = (student) => async(dispatch, reducers) => {
  await addStudentAsync(student);
  setSuccessMess("Add complete")(dispatch, reducers);
}