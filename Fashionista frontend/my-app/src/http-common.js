import axios from 'axios';

const userInstance = axios.create({
  baseURL: 'http://localhost:8080/users/',
  headers: {
    'Content-Type': 'application/json',
  },
});

const categoryInstance = axios.create({
  baseURL: 'http://localhost:8080/category',
  headers:{
    'Content-Type': 'application/json',
  }
})

const subCategoryInstance = axios.create({
  baseURL: 'http://localhost:8080/subCategory',
  headers:{
    'Content-Type': 'application/json',
  }
})

const productInstance = axios.create({
  baseURL: 'http://localhost:8080/products',
  headers:{
    'Content-Type': 'application/json',
  }
})


export default {userInstance, categoryInstance, subCategoryInstance, productInstance};