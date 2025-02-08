import React, { useContext, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { UserContext } from '../App';
import { toast } from 'react-hot-toast';
import axios from 'axios';

function UserDashboard() {
  const { userAuth, setUserAuth } = useContext(UserContext);  // User info context
  const [pets, setPets] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    if (!userAuth) {
      // If no user is logged in, redirect to login page
      toast.error("You need to log in to view your pets.");
      navigate('/login');
    } else {
      // Fetch user details from the server
      axios.get(`http://localhost:9000/users/${userAuth.id}`)
        .then(response => {
          // You can store user details in state if needed, or use it directly
          console.log('User Details:', response.data);
        })
        .catch(error => {
          toast.error("Failed to fetch user details.");
        });

      // Fetch pets related to the logged-in user
      axios.get(`http://localhost:9000/users/${userAuth.id}/pets`)
        .then(response => {
          setPets(response.data);
        })
        .catch(error => {
          toast.error("Failed to fetch pets. Please try again.");
        });
    }
  }, [userAuth, navigate]);

  const handleLogout = () => {
    setUserAuth(null); // Clear user session
    toast.success("You have logged out successfully.");
    navigate('/login'); // Redirect to login page
  };

  return (
    <div className="container mt-5">
      <div className="user-details mt-4">
        <h3>User Details</h3>
        <p><strong>Email:</strong> {userAuth?.email}</p>
        <p><strong>Phone Number:</strong> {userAuth?.phoneNumber}</p>
        <p><strong>Gender:</strong> {userAuth?.gender}</p>
      </div>

      <div className="pets-section mt-4">
        <h2>Your Pets</h2>

        {pets.length === 0 ? (
          <div>
            <p>You have no pets. Add one below!</p>
            <button className="btn btn-primary" onClick={() => navigate('/add-pet')}>
              Add a Pet
            </button>
          </div>
        ) : (
          <div className="row">
            {pets.map((pet) => (
              <div key={pet.id} className="col-md-4">
                <div className="card">
                  <img src={pet.imageUrl} alt={pet.name} className="card-img-top" />
                  <div className="card-body">
                    <h5 className="card-title">{pet.name}</h5>
                    <p className="card-text">{pet.species}</p>
                    <button 
                      className="btn btn-warning" 
                      onClick={() => navigate(`/edit-pet/${pet.id}`)}
                    >
                      Edit Pet
                    </button>
                    <button 
                      className="btn btn-danger ms-2" 
                      onClick={() => handleDeletePet(pet.id)}
                    >
                      Delete Pet
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );

  // Handle deleting a pet
  const handleDeletePet = (petId) => {
    axios.delete(`http://localhost:9000/pets/${petId}`)
      .then(() => {
        setPets(pets.filter((pet) => pet.id !== petId));
        toast.success("Pet deleted successfully!");
      })
      .catch(() => {
        toast.error("Failed to delete pet. Please try again.");
      });
  };
}

export default UserDashboard;
