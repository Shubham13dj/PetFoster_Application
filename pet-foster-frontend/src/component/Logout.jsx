import React, { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { UserContext } from '../App';
import { toast } from 'react-hot-toast';
import { removeFromSession } from '../common/session'; // Helper to remove session

function Logout() {
  const { setUserAuth } = useContext(UserContext); // Assuming you are using context to manage auth state
  const navigate = useNavigate();

  const handleLogout = () => {
    // Clear user session and token (you can also clear localStorage or sessionStorage)
    removeFromSession('user');  // Assuming you are using sessionStorage to store user data
    setUserAuth({ jsonToken: null });  // Reset the user's auth state in context

    toast.success("You have logged out successfully!");
    
    // Redirect to the login page (or homepage)
    navigate('/');  // Or navigate('/'); if you want to go to the homepage
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="card shadow-lg p-4" style={{ width: '400px' }}>
        <div className="card-body text-center">
          <h2 className="text-primary">Are you sure you want to logout?</h2>
          <button onClick={handleLogout} className="btn btn-danger w-100">
            Logout
          </button>
        </div>
      </div>
    </div>
  );
}

export default Logout;
