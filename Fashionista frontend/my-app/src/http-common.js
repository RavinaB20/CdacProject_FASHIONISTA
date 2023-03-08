import axios from 'axios';

export default axios.create({
  baseURL: 'http://localhost:8080/users/',
  headers: {
    'Content-Type': 'application/json',
  },
});
