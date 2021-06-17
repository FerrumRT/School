import { Button, Form, Modal } from "react-bootstrap";
import { useState } from "react";
import { addGroup } from "../redux/actions/groupAction";
import { useDispatch, useSelector } from "react-redux";

export default function AddGroup() {
  const reducer = useSelector(state=>state);
  const dispatch = useDispatch();
  const [show, setShow] = useState(false);
  const [name, setName] = useState("");

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const handleSubmit = (event) => {
    event.preventDefault();
    addGroup({
      name, "teacher": reducer.user.details.id
    })(dispatch, reducer);
    setName("");
  }

  return(
    <>
      <Button variant="light" className="w-100" onClick={handleShow}>
        Add Group
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>New Group</Modal.Title>
        </Modal.Header>
        <Form onSubmit={handleSubmit}>
          <Modal.Body>
            <Form.Control placeholder="Name" value={name} onChange={event=>{setName(event.target.value)}} />
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