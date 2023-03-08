import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const UserList = () => {
  const [users, setUsers] = useState([]);
  // const [tempEmp, setTempemp] = useState([]);

  const init = () => {

  return (
    <div className='container'>
      <h3>List of Users</h3>
      <hr />
      <div>
        <Link to='/add' className='btn btn-primary mb-2'>
          Add User
        </Link>
        <table className='table table-bordered table-striped'>
          <thead className='thead-dark'>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>DOB</th>
              <th>Mobile No</th>
              <th colSpan={3}>Actions</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => (
              <tr key={user.id}>
                <td>{user.firstName}</td>
                <td>{user.lastName}</td>
                <td>{user.email}</td>
                <td>{user.dob}</td>
                <td>{user.mobileNo}</td>
                <td>
                  <Link
                    className='btn btn-info'
                    to={`/users/edit/${user.id}`}
                  >
                    Update
                  </Link>
                </td>

                {/* <td>
                  <Link
                    className='btn btn-info'
                    to={`/uploadImage/${employee.id}`}
                  >
                    Image Upload
                  </Link>
                </td> */}
                <td>
                  <button
                    className='btn btn-danger ml-2'
                    onClick={() => {
                      handleDelete(user.id);
                    }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UserList;
