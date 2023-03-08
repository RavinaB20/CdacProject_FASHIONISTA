//import axios from 'axios';
import { useState } from 'react';
import { Link, useHistory, useParams } from 'react-router-dom';
import { useEffect } from 'react/cjs/react.development';
import userService from '../../services/user.service';

const AddUser = () => {

  const [firstName, setFirstname] = useState('');
  const [lastName, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [dob, setDob] = useState('');
  const [mobileNo, setMobileNo] = useState('');

  const history = useHistory();
  const { id } = useParams();

  const saveUser = (e) => {
    e.preventDefault();

    const user = {
      firstName,
      lastName,
      email,
      password,
      dob,
      mobileNo,
      id,
    };
    if (id) {
      //update
      userService
        .update(user)
        .then((response) => {
          console.log('User data updated successfully', response.data);
          history.push('/');
        })
        .catch((error) => {
          alert(error.response.status);
          console.log('Error code ' + error);
          console.log('Something went wrong', error.response.data);
        });
    } else {
      //create
      userService
        .create(user)
        .then((response) => {
          console.log('User added successfully', response.data);
          history.push('/');
        })
        .catch((error) => {
          console.log("New User data : "+user.firstName);
          console.log('something went wroing' + error.response);
        });
    }
  };

  useEffect(() => {
    if (id) {
      userService
        .get(id)
        .then((user) => {
          setFirstname(user.data.firstName);
          setLastname(user.data.lastName);
          setEmail(user.data.email);
          setPassword(user.data.password);
          setDob(user.data.dob);
          setMobileNo(user.data.mobileNo);
        })
        .catch((error) => {
          console.log('Something went wrong', error);
        });
    }
  }, []);
  return (
    <div className='container'>
      <h3>Add User</h3>
      <hr />
      <form>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='firstName'
            value={firstName}
            onChange={(e) => setFirstname(e.target.value)}
            placeholder='Enter first name'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='lastName'
            value={lastName}
            onChange={(e) => setLastname(e.target.value)}
            placeholder='Enter last name'
          />
        </div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='email'
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder='Enter email'
          />
        </div>
        <div className='form-group'>
          <input
            type='password'
            className='form-control col-4'
            id='password'
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder='Enter Password'
          />
        </div>
        <div className='form-group'>
          <input
            type='date'
            className='form-control col-4'
            id='dob'
            value={dob}
            onChange={(e) => setDob(e.target.value)}
            placeholder='Enter Birth date'
          />
        </div>
        <div className='form-group'>
          <input
            type='number'
            className='form-control col-4'
            id='mobileNo'
            value={mobileNo}
            onChange={(e) => setMobileNo(e.target.value)}
            placeholder='Enter Mobile Number'
          />
        </div>
        <div>
          <button onClick={(e) => saveUser(e)} className='btn btn-primary'>
            Save Or Update
          </button>
        </div>
      </form>
      <hr />
      <Link to='/'>Back to List</Link>
    </div>
  );
};

export default AddUser;
