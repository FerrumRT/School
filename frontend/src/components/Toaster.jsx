import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";

export default function Toaster() {
  const dispatch = useDispatch();
  const reducers = useSelector(state=>state);

  useEffect(()=>{
    if (reducers.message.success) alert(`Success: ${reducers.message.success}`)
    if (reducers.message.error) alert(`Error: ${reducers.message.error}`)
  }, [reducers.message.success, reducers.message.error])

  return(<>
  </>)
}