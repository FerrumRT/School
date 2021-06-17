import { combineReducers } from "redux";
import * as actionTypes from "../actionTypes";
import user from "./user"
import message from "./message"
import groups from "./groups"
import students from "./students"

const loading = (state = false, action) => {
  switch(action.type){
    case actionTypes.LOADING:
      return !state;
    default:
      return state;
  }
}

export default combineReducers({
  user,
  loading,
  message,
  groups,
  students
});