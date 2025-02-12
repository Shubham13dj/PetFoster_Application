import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios'; // Import axios for API calls
import '../styles/PetDetailsPage.css'; // Import custom CSS for styling
import { Navigate, useNavigate, useParams } from 'react-router-dom';
import toast from 'react-hot-toast';
import { UserContext } from '../App';

const PetDetailsPage = () => {

  const navigate = useNavigate();

  const { userAuth, userAuth:{ jsonToken }} = useContext(UserContext);
  const petId = useParams().id;
  const [pet, setPet] = useState(null);
  const [adoptionHistory, setAdoptionHistory] = useState([]);
  const [medicalHistory, setMedicalHistory] = useState([]);

  // Fetch pet details, adoption history, and medical history
  useEffect(() => {
    // Fetch pet details
    axios.get(`http://localhost:9000/pets/${petId}`)
      .then((response) => {
        setPet(response.data); // Set pet details
      })
      .catch((error) => {
        console.error('Error fetching pet details:', error);
      });
    
  
   
      
    // Fetch adoption history
    axios.get(`http://localhost:9000/adoption-history/${petId}`, {
      headers:{
        'Authorization': `Bearer ${jsonToken}`
      }
    })
      .then((response) => {
        setAdoptionHistory(response.data); // Set adoption history
      })
      .catch((error) => {
        console.error('Error fetching adoption history:', error);
      });
    

      /*
        Url need to change
      */


    // Fetch medical history
    axios.get(`http://localhost:9000/pet-history/${petId}`,{
      headers:{
        'Authorization': `Bearer ${jsonToken}`
      }
    })
      .then((response) => {
        setMedicalHistory(response.data); // Set medical history
      })
      .catch((error) => {
        console.error('Error fetching medical history:', error);
      });
   

  }, [petId]);

  const handleAdopt = () => {
    if (jsonToken) {
      // Add logic for fostering if the user is logged in
      console.log("Proceed with fostering process");
    } else {
      navigate("/login");
    }
  };

  const handleFoster = () => {
    if (jsonToken) {
      const confirmFoster = window.confirm(`Are you sure you want to foster ${pet.name}?`);
      if (confirmFoster) {

        axios.put(`http://localhost:9000/foster-request/${userAuth.id}/${petId}`, {
          headers:{
            'Authorization': `Bearer ${jsonToken}`
          }
        })
          .then((response) => {
            toast.success("Foster request successful")
            navigate("/dashboard") // Set adoption history
          })
          .catch((error) => {
            toast.error('Error fetching adoption history:', error);
          });    
      }
    } else {
      navigate("/login");
    }
  };
  

  if (!pet) return toast.loading(); // Show loading while fetching data

  return (
    <div className="pet-details-container">
      <div className="pet-details-header">
        <img 
          src={`data:${pet.imageType};base64,${pet.imageData}` || 'http://localhost:9000/images/default-image.jpg'} 
          alt={pet.name} 
          className="pet-details-img"
        />
        <div className="pet-details-info">
          <h2>{pet.name}</h2>
          <p><strong>Breed:</strong> {pet.breed}</p>
          <p><strong>Age:</strong> {pet.age} years</p>
          <p><strong>Location:</strong> {pet.location}</p>
          <p><strong>Description:</strong> {pet.description}</p>
        </div>
      </div>

  {/* Conditional Rendering for Logged-in Users */}
  {jsonToken ? (
        <>
          <div className="pet-details-history">
            <h3>Adoption History</h3>
            {adoptionHistory.length > 0 ? (
              <ul>
                {adoptionHistory.map((adopt, index) => (
                  <li key={index}>
                    <p><strong>Adoption Date:</strong> {adopt.date}</p>
                    <p><strong>Adopter:</strong> {adopt.adopterName}</p>
                    <p><strong>Notes:</strong> {adopt.notes}</p>
                  </li>
                ))}
              </ul>
            ) : (
              <p>No adoption history available.</p>
            )}
          </div>

          <div className="pet-details-history">
            <h3>Medical Records</h3>
            {medicalHistory.length > 0 ? (
              <ul>
                {medicalHistory.map((medical, index) => (
                  <li key={index}>
                    <p><strong>Date:</strong> {medical.date}</p>
                    <p><strong>Condition:</strong> {medical.condition}</p>
                    <p><strong>Treatment:</strong> {medical.treatment}</p>
                  </li>
                ))}
              </ul>
            ) : (
              <p>No medical records available.</p>
            )}
          </div>
        </>
      ) : (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
          <h2>Please log in to see further details</h2>
        </div>  
      )}  
       <div className="pet-details-actions">
            <button className="btn adopt-btn" onClick={handleAdopt}>Adopt</button>
            <button className="btn foster-btn" onClick={handleFoster}>Foster Now</button>
          </div>
        </div>
  );
};

export default PetDetailsPage;
