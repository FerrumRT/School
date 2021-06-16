import './App.css';
import NavBar from './components/NavBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Login from "./components/Login";

function App() {
  return (
    <>
      <Router>
        <NavBar/>
        <Switch>
          <Route path="/login">
            <Login/>
          </Route>
        </Switch>
      </Router>
    </>
  );
}

export default App;
