import { combineReducers } from "redux";
import * as actionTypes from "../actionTypes";

const details = (state = {}, action) => {
  switch(action.type){
    case actionTypes.ONE_GROUP:
      return action.data;
    default:
      return state;
  }
}

const list = (state = [], action) => {
  switch(action.type){
    case actionTypes.GROUP_LIST:
      return action.data;
    default:
      return state;
  }
}

export default combineReducers({
  details,
  list
});