import { combineReducers } from "redux";
import * as actionTypes from "../actionTypes";

const details = (state = {}, action) => {
  switch(action.type){
    case actionTypes.LOGIN:
      return action.data;
    case actionTypes.LOGOUT:
      return {};
    default:
      return state;
  }
}

const is_loginned = (state = false, action) => {
  switch(action.type){
    case actionTypes.LOGIN:
      return true;
    case actionTypes.LOGOUT:
      return false;
    default:
      return state;
  }
}
const is_admin = (state = true, action) => {
  switch(action.type){
    case actionTypes.LOGIN:
      return action.data.isAdmin;
    case actionTypes.LOGOUT:
      return false;
    default:
      return state;
  }
}

export default combineReducers({
  details,
  is_loginned,
  is_admin
});