import { useDispatch, useSelector } from "react-redux";
import { useState } from "react";
import { Button, Form, Modal } from "react-bootstrap";
import { addStudent } from "../redux/actions/studentAction";

export default function AddStudent(params) {
  const reducer = useSelector(state=>state);
  const dispatch = useDispatch();
  const [show, setShow] = useState(false);
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [birthdate, setBirthdate] = useState("");

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const handleSubmit = (event) => {
    event.preventDefault();
    addStudent({
      name,
      surname,
      birthdate,
      "group": params.group
    })(dispatch, reducer);
  }

  return(
    <>
      <Button variant="outline-dark" size="sm" className="mb-1" onClick={handleShow}>
        Add Student
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>New Student</Modal.Title>
        </Modal.Header>
        <Form onSubmit={handleSubmit}>
          <Modal.Body>
            <Form.Group>
              <Form.Label>Name</Form.Label>
              <Form.Control placeholder="Name" value={name} onChange={event=>{setName(event.target.value)}} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Surname</Form.Label>
              <Form.Control placeholder="Surname" value={surname} onChange={event=>{setSurname(event.target.value)}} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Birthdate</Form.Label>
              <Form.Control type="date" value={birthdate} onChange={event=>{setBirthdate(event.target.value)}} />
            </Form.Group>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
            <Button variant="light" type="submit" onClick={handleClose}>
              Add
            </Button>
          </Modal.Footer>
        </Form>
      </Modal>
    </>
  )
}