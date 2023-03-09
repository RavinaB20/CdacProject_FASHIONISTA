import { BrowserRouter, Switch, Route } from "react-router-dom";
import NotFound from "./components/NotFound";
import "bootstrap/dist/css/bootstrap.min.css";
import UserList from "./components/User/UsersList";
import AddUser from "./components/User/AddUser";
import MainPage from "./components/MainPage";
import Whoarewe  from "./components/Footer/Whoarewe";
import Faq from "./components/Footer/Faq";
import ContactUs from "./components/Footer/ContactUs";


function App() {
  return (
    <BrowserRouter>
      <div>
        <div>
          <Switch>
            <Route exact path="/" component={MainPage} />
            <Route exact path="/Whoarewe" component={Whoarewe} />
            <Route exact path="/Faq" component={Faq} />
            <Route exact path="/ContactUs" component={ContactUs} />

            <Route exact path="/a" component={UserList} />
            <Route path="/add" component={AddUser} />
            <Route path="/users/edit/:id" component={AddUser} />
            <Route path="*" component={NotFound} />
          </Switch>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
