import './App.css';
import NavBar from './components/NavBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Login from "./components/Login";
import Main from './components/Main';
import Toaster from './components/Toaster';

function App() {
  return (
    <>
      <Router>
        <NavBar/>
        <Toaster/>
        <Switch>
          <Route path="/login">
            <Login/>
          </Route>
          <Route path="/">
            <Main/>
          </Route>
        </Switch>
      </Router>
    </>
  );
}

export default App;
