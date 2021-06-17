import { combineReducers } from "redux";
import * as actionTypes from "../actionTypes";

const anonimous = {
  id: -1,
  name: "NoOne",
  email: "noOne@noOne.com"
}

const getCurrentUser = () => {
  let user = {
    is_authorized: false,
    is_admin: false,
    is_moderator: false,
    data: anonimous
  };
  if (localStorage.getItem("user") !== null) {
    user.data = JSON.parse(localStorage.getItem("user"));
    user.is_authorized = true;
    user.is_admin = user.data.admin;
  }
  return user;
}

const user = getCurrentUser();

const details = (state = user.data, action) => {
  switch(action.type){
    case actionTypes.LOGIN:
      return action.data;
    case actionTypes.LOGOUT:
      return anonimous;
    default:
      return state;
  }
}

const is_authorized = (state = user.is_authorized, action) => {
  switch(action.type){
    case actionTypes.LOGIN:
      return true;
    case actionTypes.LOGOUT:
      return false;
    default:
      return state;
  }
}

const is_admin = (state = user.is_admin, action) => {
  switch(action.type){
    case actionTypes.LOGIN:
      return action.data.admin;
    case actionTypes.LOGOUT:
      return false;
    default:
      return state;
  }
}

export default combineReducers({
  details,
  is_authorized,
  is_admin
});