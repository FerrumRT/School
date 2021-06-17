import * as action_types from "../actionTypes";
import axios from '../axios';
import Cookies from "js-cookies";
import { setSuccessMess, setErrMess } from "./supActions";

async function auth(email, password){
  axios.interceptors.response.use(response => {
    return response;
  }, error => {
    return null;
  });
  let user = await axios.post(`http://localhost:8080/auth`, {email, password});
  console.log(user);
  if(user == null) return null;
  return user.data;
}

async function get(){
  if(Cookies.getItem("java_auth")!== null) {
    axios.defaults.headers.common["Authorization"] = `Bearer ${Cookies.getItem("java_auth")}`;
    let user = await axios.get(`http://localhost:8080/getUser`)
    .catch(function(error) {
      console.log("something hapends");
      console.log(error);
      return null;
    });
    if (user === null) return null;
    return user.data;
  }
  return null;
}

export const getCurrentUser = () => async(dispatch, reducers) => {
  let user = await get();
  if (user != null){
    localStorage.setItem("user", JSON.stringify(user));
    await dispatch({"type" : action_types.LOGIN, "data" : user})
  } else {
    console.log("User is null");
    Cookies.removeItem("java_auth");
    localStorage.removeItem("user");
  }
}

export const login = (email, password) => async(dispatch, reducers) => {
  await dispatch({"type" : action_types.LOADING})
  let user = await auth(email, password);
  await dispatch({"type" : action_types.LOADING})
  if (user !== null){
    if (user.jwtToken !== undefined) {
      Cookies.setItem("java_auth", user.jwtToken, 7*3600*24);
      localStorage.setItem("user", JSON.stringify(user.teacher));
      await dispatch({"type" : action_types.LOGIN, "data" : user.teacher});
      setSuccessMess("Success login")(dispatch, reducers);
    }
    else setErrMess("Wrong email or password")(dispatch, reducers);
  }
  else setErrMess("Something wrong")(dispatch, reducers);
}

export const logout = () => async(dispatch, reducers) => {
  Cookies.removeItem("java_auth");
  setSuccessMess("Success logout")(dispatch, reducers);
  await dispatch({ "type" : action_types.LOGOUT });
}