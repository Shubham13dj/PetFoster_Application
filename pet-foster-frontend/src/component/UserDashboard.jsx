import React, { useContext, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { UserContext } from '../App';
import { toast } from 'react-hot-toast';
import axios from 'axios';
import Card from './Card';
// import '../styles/UserDashboard.css'

function UserDashboard() {
  const { userAuth, userAuth: { jsonToken }, setUserAuth } = useContext(UserContext);

  const [pets, setPets] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    if (!userAuth) {
      // If no user is logged in, redirect to login page
      toast.error("You need to log in to view your pets.");
      navigate('/login');
    } else {
      // Fetch user details from the server
      // axios.get(process.env.REACT_APP_SERVER_DOMAIN + userAuth.id, {
      axios.get(`http://localhost:9000/users/${userAuth.id}`, {
        headers: {
          "Authorization": `Bearer ${jsonToken}`
        }
      })
        .then(response => {
          //console.log('User Details:', response.data);
        })
        .catch(error => {
          toast.error("Failed to fetch user details.");
        });

      // Fetch pets related to the logged-in user
      axios.get(`http://localhost:9000/pets/user/${userAuth.id}`, {
        headers: {
          "Authorization": `Bearer ${jsonToken}`
        }
      })
        .then(response => {
          setPets(Array.isArray(response.data) ? response.data: []);
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

  const handleDeletePet = (petId) => {
    axios.delete(`http://localhost:9000/pets/${petId}`, {
      headers: { "Authorization": `Bearer ${jsonToken}` }
    })
      .then(() => {
        setPets(pets.filter((pet) => pet.id !== petId));
        toast.success("Pet deleted successfully!");
      })
      .catch(() => {
        toast.error("Failed to delete pet. Please try again.");
      });
  };
  //const filteredPets = pets.filter((pet)=> pet.availableToFoster === true);
  return (
    <div className="container mt-5">
  
      <div className="user-details mt-4">
        <h3 style={{ color: 'blue' }}>User Name: {userAuth?.name}</h3>
        <p>Role: {userAuth?.role}</p>
        <p><strong>Email:</strong> {userAuth?.email}</p>
        <p><strong>Phone Number:</strong> {userAuth?.phoneNumber}</p>
        <p><strong>Gender:</strong> {userAuth?.gender}</p>
        
      {
        userAuth.role !== "FOSTER_PARENT" ?
      <button className="btn btn-primary" onClick={() => navigate('/add-pet')}>
                  Add a Pet
      </button>

      :
      <>
      </>
      }
      </div>

      {/* Display pets or cards based on role */}
      {userAuth?.role === 'FOSTER_PARENT' ? (
        <div className="pets-section mt-4">
          <h2>Available Pets for Fostering</h2>
          <Card role={userAuth.role} /> {/* Pass pets to Card component */}
        </div>
      ) : (
        <>
          <div className="pets-section mt-4">
            <h2>Your Pets</h2>
            {pets.length === 0 ? (
              <div>
                <p>You have no pets. Add one below!</p>
                
              </div>
            ) : (


              <div className="row">
                {pets.map((pet) => (
                  <div key={pet.id} className="col-md-4">
                    <div className="card">
                      {/* <img src={pet.imageUrl} alt={pet.name} className="card-img-top" /> */}
                      <img
                        src={`data:${pet.imageType};base64,${pet.imageData}`}
                        alt={pet.name}
                        className="card-img-top"
                        style={{ width: '100%', height: 'auto' }}
                      />
                      <div className="card-body">
                        <h5 className="card-title">{pet.name}</h5>
                        <p className="card-text">{pet.species}</p>
                        <div className='edit-delete-btn'>

                        <button
                          className="btn btn-warning"
                          onClick={() => navigate(`/edit-pet/${pet.id}`)} // Corrected path
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
                        <button
                          className='btn btn-secondary'
                          onClick={() => navigate(`/foster_request/${pet.id}`)}
                        >
                          Request to foster
                        </button>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            )}
          </div>
        
        </>
      )}


    </div>
  );
}

export default UserDashboard;
