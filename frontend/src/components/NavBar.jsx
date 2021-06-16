import { Container, Nav, Navbar } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { Link, useLocation } from "react-router-dom";

export default function NavBar() {

  const reducer = useSelector(state=>state);
  const dispatch = useDispatch();
  const location = useLocation();

  return (
    <>
    <Navbar bg="light" expand="lg">
      <Container>
        <Link to="/" class="navbar-brand">Navbar</Link>
        <Navbar.Toggle aria-controls="basic-navbar-nav"/>
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto">
            {reducer.user.is_loginned?<>
              <li className="nav-item">
                <Link to="/login"
                className={`nav-link ${location.pathname==="/profile"?"active":""}`} 
                style={location.pathname==="/profile"?{"textDecoration":"underline"}:{}}>{reducer.user.details.name}</Link>
              </li>
              <Nav.Link>Logout</Nav.Link>
            </>:<>
              <li className="nav-item">
                <Link to="/login"
                className={`nav-link ${location.pathname==="/login"?"active":""}`} 
                style={location.pathname==="/login"?{"textDecoration":"underline"}:{}}>Login</Link>
              </li>
            </>}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </>
  )
}