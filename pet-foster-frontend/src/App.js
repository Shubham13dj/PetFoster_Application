import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';  // Changed Switch to Routes
import Register from './component/Register';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'; // Background and global styles
import Layout from './component/Layout';
import Authprovider from './context/Authprovider';
import Navbar from './component/NavBar';
import { Outlet } from 'react-router-dom';
import Footer from './component/Footer';

const App = () => {
  return (
    <div>
      <Navbar />  {/* Render the Navbar */}
      
      <div className="content">
        {/* Render the child components here */}
        <Outlet />  {/* This is where child routes will render */}
      </div>
    </div>
  );
};

export default App;
