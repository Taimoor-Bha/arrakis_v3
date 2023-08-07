import React, { useState } from 'react';
import './Login.css'; // Import a separate CSS file for styling (create this file in the same directory)

const Login = ({ onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    // Perform authentication here and call onLogin if successful
    onLogin();
  };

  return (
    <div className="login-container">
      <h2>FIC Bond Tracker</h2>
      <form className="login-form">
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="login-input"
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="login-input"
        />
        <button onClick={handleLogin} className="login-button">
          Login
        </button>
      </form>
    </div>
  );
};

export default Login;
