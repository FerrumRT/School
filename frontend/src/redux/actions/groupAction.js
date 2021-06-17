import Cookies from "js-cookies";
import * as actionTypes from "../actionTypes";
import axios from '../axios';
import { setSuccessMess } from "./supActions";

async function getGroupsAsync(search) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  if(search === undefined) search = "";
  let groups = await axios.get(`http://localhost:8080/rest/groups/all?search=${search}`);
  console.log(groups);
  return groups.data;
}

async function getTeacherGroupsAsync(id, search) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  if(search === undefined) search = "";
  let groups = await axios.get(`http://localhost:8080/rest/groups/teacher/${id}?search=${search}`);
  console.log(groups);
  return groups.data;
}

async function addGroupAsync(group) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  console.log(group.photo);
  let data = {
    "name":group.name,
    "teacher":group.teacher
  };
  await axios({
    url: `http://localhost:8080/rest/groups/add`,
    method: "post",
    data: data
  });
}

async function deleteGroupAsync(id) {
  if(Cookies.getItem("java_auth")!== null) 
  axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
  axios.defaults.headers.common["Access-Control-Allow-Origin"] = "*";
  let status = await axios({
    url:`http://localhost:8080/rest/groups/delete/${id}`,
    method:"DELETE"
  });
}

export const getGroups = (search) => async(dispatch, reducers) => {
  let groups = await getGroupsAsync(search);
  await dispatch({"type" : actionTypes.GROUP_LIST, "data" : groups});
}

export const getTeachersGroups = (id, search) => async(dispatch, reducers) => {
  let groups = await getTeacherGroupsAsync(id, search);
  await dispatch({"type" : actionTypes.GROUP_LIST, "data" : groups});
}

export const deleteGroup = (id) => async(dispatch, reducers) => {
  await deleteGroupAsync(id);
  setSuccessMess("Delete complete")(dispatch, reducers);
}

export const addGroup = (group) => async(dispatch, reducers) => {
  await addGroupAsync(group);
  setSuccessMess("Add complete")(dispatch, reducers);
}