import React from 'react';

const AllUsers = ({ data }) => {
  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          {/* Add more table headers here */}
        </tr>
      </thead>
      <tbody>
        {data.map((item) => (
          <tr key={item.id}>
            <td>{item.id}</td>
            <td>{item.name}</td>
            {/* Add more table cells here based on your data structure */}
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default AllUsers;
