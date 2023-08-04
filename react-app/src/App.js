import React from 'react';
import Login from './components/Login';
import HomePage from './components/HomePage'; 
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';


const App = () => {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/api" element={<HomePage />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
