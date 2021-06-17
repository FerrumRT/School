import { Button, Card, Col, Container, Form, Row } from "react-bootstrap";
import { useState, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router";
import { login } from "../redux/actions/userAction";

export default function Login() {

  const reducer = useSelector(state=>state);
  const dispatch = useDispatch();
  const history = useHistory();
  
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleChange = (event) => {
    switch (event.target.name){
      case "email": setEmail(event.target.value);break;
      case "password": setPassword(event.target.value);
    }
  }

  useEffect(()=>{
    if(reducer.user.is_authorized) history.push("/");
  }, [reducer.user.is_authorized]);

  const handleSubmit = event => {
    event.preventDefault();
    login(email, password)(dispatch, reducer);
    setPassword("")
  }

  return (
    <>
    <Container fluid>
      <Row className="justify-content-center mt-3">
        <Col sm="4">
          <Card className="p-5">
            <Row className="justify-content-center">
              <h3>Login</h3>
              <Form className="col-12" onSubmit={handleSubmit}>
                <Row className="justify-content-center">
                  <Form.Control disabled={reducer.loading} name="email" value={email} onChange={handleChange} placeholder="Email" className="col-10 mb-3"/>
                  <Form.Control disabled={reducer.loading} type="password" name="password" value={password} onChange={handleChange} placeholder="Password" className="col-10 mb-3"/>
                </Row>
                <Row className="justify-content-center">
                  <Button disabled={reducer.loading} variant="outline-dark" type="submit">LOGIN</Button>
                </Row>
              </Form>
            </Row>
          </Card>
        </Col>
      </Row>
    </Container>
    </>
  )
}