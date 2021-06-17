import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import { useEffect } from "react";
import { deleteGroup, getGroups, getTeachersGroups } from "../redux/actions/groupAction";
import { Button, Container, Table } from "react-bootstrap";
import AddGroup from "./AddGroup";
import AddStudent from "./AddStudent";
import { deleteStudent } from "../redux/actions/studentAction";

export default function Main() {

  const reducer = useSelector(state=>state);
  const dispatch = useDispatch();
  const history = useHistory();

  useEffect(()=>{
    if (reducer.user.is_authorized) {
      if (reducer.user.is_admin)
        getGroups("")(dispatch, reducer);
      else
        getTeachersGroups(reducer.user.details.id, "")(dispatch, reducer);
    }
  }, [reducer.message])

  useEffect(()=>{
    if(!reducer.user.is_authorized) history.push("/login");
  }, [reducer.user.is_authorized]);

  return (
    <>
    <Container>
      <div className="my-3 text-right">
        <AddGroup/>
      </div>
      {reducer.user.is_authorized && reducer.groups.list.map(group=><>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th colSpan="3" width="50%"><h5>Group name: {group.name}</h5></th>
              <th width="35%"><h5>Teacher: {group.teacher.name + " "+ group.teacher.surname}</h5></th>
              <th width="15%">
                <AddStudent group={group.id}/>
                <Button variant="outline-danger" size="sm" onClick={()=>{deleteGroup(group.id)(dispatch, reducer)}}>Delete Group</Button>
              </th>
            </tr>
          </thead>
          {group.students.length===0?<tr>
            <th colSpan="5">No student</th>
          </tr>:<>
          <thead>
            <tr>
              <th>#</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Birthdate</th>
              <th>Details</th>
            </tr>
          </thead>
          <tbody>
            {group.students.map(student=><>
              <tr>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.surname}</td>
                <td>{student.bdate}</td>
                <td>
                  <Button variant="outline-danger" size="sm" onClick={()=>{deleteStudent(student.id)(dispatch, reducer)}}>Delete Student</Button>
                </td>
              </tr>
            </>)}
          </tbody>
            </>}
            
        </Table>
      </>)}
    </Container>
    </>
  )
}