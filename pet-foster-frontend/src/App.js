import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';  // Changed Switch to Routes
import Register from './component/Register';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'; // Background and global styles
import Layout from './component/Layout';
import Authprovider from './context/Authprovider';
const App = () => {
  return (
    <Authprovider>


    <Router>
      <div>
        <h1 className="text-center mt-5">Welcome to PetFoster</h1>
        <Routes> 
	      <Route path="/" element={<Layout />}>
          {/* Register route */}
          <Route path="/register" element={<Register />} /> 
          {/* Add other routes here if needed */}
         
	        </Route>
        </Routes>
        
      </div>
    </Router>
    </Authprovider>
  );
};

export default App;
