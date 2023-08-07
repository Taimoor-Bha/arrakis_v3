import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import React, { useState } from 'react';
import Login from './components/Login';
import AllBooks from './components/AllBooks';

const App = () => {
  const [loggedIn, setLoggedIn] = useState(false);

  const handleLogin = () => {
    // Set loggedIn to true after successful authentication
    setLoggedIn(true);
  };

  return (
    <div>
      {loggedIn ? <AllBooks /> : <Login onLogin={handleLogin} />}
    </div>
  );
};

export default App;