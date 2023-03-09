import httpClient from "../http-common"

const getAll = () => {
    return httpClient.categoryInstance.get('');
  };
  
  const create = (data) => {
    return httpClient.categoryInstance.post('', data);
  };
  
  const get = (id) => {
    return httpClient.categoryInstance.get(`${id}`);
  };
  
  const update = (data) => {
    return httpClient.categoryInstance.put('', data);
  };
  
  const remove = (id) => {
    return httpClient.categoryInstance.delete(`/${id}`);
  };
  
  export default { getAll, create, get, update, remove };