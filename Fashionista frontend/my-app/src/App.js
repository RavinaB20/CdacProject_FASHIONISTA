import { BrowserRouter, Switch, Route } from 'react-router-dom';
import NotFound from './components/NotFound';
import 'bootstrap/dist/css/bootstrap.min.css';
import UserList from './components/User/UsersList';
import AddUser from './components/User/AddUser';
import CustomNavbar from './components/CustomNavbar';
import Banner from './components/Banner';
import MainPage from './components/MainPage';
function App() {
  return (

    <BrowserRouter>
      <div>
        <div>
          <Switch>
            <Route exact path="/" component={MainPage}/>

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
