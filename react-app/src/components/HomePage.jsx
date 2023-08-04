import React, { useState, useEffect } from 'react';
import AllUsers from './AllUsers';

const HomePage = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {}
        fetchUsers()
        .then(res => {
            setUsers(res.data);
        })
        .catch(err => {
            setUsers([]);
            console.log(err);
        })

    return (
        <div>
            <h2>HomePage</h2>
            <AllUsers data={users} />
        </div>
    );
};

export default HomePage;
