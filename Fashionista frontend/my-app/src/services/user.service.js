
import httpClient from '../http-common';

const getAll = () => {
  return httpClient.userInstance.get('');
};

const create = (data) => {
  return httpClient.userInstance.post('', data);
};

const get = (id) => {
  return httpClient.userInstance.get(`${id}`);
};

const update = (data) => {
  return httpClient.userInstance.put('', data);
};

const remove = (id) => {
  return httpClient.userInstance.delete(`/${id}`);
};

export default { getAll, create, get, update, remove };