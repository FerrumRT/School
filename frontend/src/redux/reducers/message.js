import { combineReducers } from "redux";
import * as actionTypes from "../actionTypes";

const error = (state = "", action) => {
  switch(action.type){
    case actionTypes.ERROR_MESSAGE:
      return action.data;
    default: return state;
  }
}

const success = (state = "", action) => {
  switch(action.type){
    case actionTypes.SUCCESS_MESSAGE:
      return action.data;
    default: return state;
  }
}

export default combineReducers({
  error,
  success
});