import React, { useState } from 'react';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Here, you can implement the logic for authenticating the user.
    // For simplicity, we'll just log the credentials to the console.
    console.log('Username:', username);
    console.log('Password:', password);

    // Simulate successful login. In a real app, this would be based on server-side authentication.
    setLoggedIn(true);
  };

  if (loggedIn) {
    // Redirect to the corect page after successful login
    window.location.href = '/api/users/';
  }

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
