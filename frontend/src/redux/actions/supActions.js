import * as action_types from "../actionTypes";

export const removeErrMess = () => async(dispatch, reducers) => {
  await dispatch({"type" : action_types.ERROR_MESSAGE, "data" : ""})
}

export const removeSuccessMess = () => async(dispatch, reducers) => {
  await dispatch({"type" : action_types.SUCCESS_MESSAGE, "data" : ""})
}

export const setSuccessMess = (mess) => async(dispatch, reducers) => {
  await dispatch({"type" : action_types.SUCCESS_MESSAGE, "data" : mess})
  setTimeout(()=>{removeSuccessMess()(dispatch, reducers)}, 3000)
}

export const setErrMess = (mess) => async(dispatch, reducers) => {
  await dispatch({"type" : action_types.ERROR_MESSAGE, "data" : mess})
  setTimeout(()=>{removeErrMess()(dispatch, reducers)}, 3000)
}