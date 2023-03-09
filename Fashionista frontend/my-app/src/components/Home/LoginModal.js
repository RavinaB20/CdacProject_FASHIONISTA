import React, { useState } from 'react';
import "./LoginModal.css";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

const LoginModal = (props) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLogin = (event) => {
    event.preventDefault();
    console.log("aaaaaaaaaaaaaaaaaaaaaaaaa")
    
    // Perform login logic here using the username and password states
    // ...
    // Close the modal
    props.onClose();
  };

  return (
    <div className="modal">
      <div className="modal-content">
        <span className="close" onClick={props.onClose}>&times;</span>
        <h2 className="modal-title">Login</h2>


        <Form>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter email" />
        <Form.Text className="text-muted">
          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
      </div>
    </div>
  );
}

export default LoginModal;
