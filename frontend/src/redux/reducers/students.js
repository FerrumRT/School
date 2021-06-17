import { combineReducers } from "redux";
import * as actionTypes from "../actionTypes";

const details = (state = {}, action) => {
  switch(action.type){
    case actionTypes.ONE_STUDENT:
      return action.data;
    default:
      return state;
  }
}

const list = (state = [], action) => {
  switch(action.type){
    case actionTypes.STUDENT_LIST:
      return action.data;
    default:
      return state;
  }
}

export default combineReducers({
  details,
  list
});