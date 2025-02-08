import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';  // Changed Switch to Routes
import Register from './component/Register';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'; // Background and global styles

const App = () => {
  return (
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
        <Register/>
      </div>
    </Router>
  );
};

export default App;
