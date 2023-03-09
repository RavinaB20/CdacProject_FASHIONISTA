
import httpClient from "../http-common"

const getAll = () => {
    return httpClient.subCategoryInstance.get('');
  };
  
  const create = (data) => {
    return httpClient.subCategoryInstance.post('', data);
  };
  
  const get = (id) => {
    return httpClient.subCategoryInstance.get(`${id}`);
  };
  
  const update = (data) => {
    return httpClient.subCategoryInstance.put('', data);
  };
  
  const remove = (id) => {
    return httpClient.subCategoryInstance.delete(`/${id}`);
  };
  
  export default { getAll, create, get, update, remove };