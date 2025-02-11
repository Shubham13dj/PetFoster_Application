import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Import axios for API calls
import '../styles/PetDetailsPage.css'; // Import custom CSS for styling

const PetDetailsPage = ({ petId }) => {
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
    axios.get(`http://localhost:9000/pets/${petId}/adoptions`)
      .then((response) => {
        setAdoptionHistory(response.data); // Set adoption history
      })
      .catch((error) => {
        console.error('Error fetching adoption history:', error);
      });

    // Fetch medical history
    axios.get(`http://localhost:9000/pets/${petId}/medical-history`)
      .then((response) => {
        setMedicalHistory(response.data); // Set medical history
      })
      .catch((error) => {
        console.error('Error fetching medical history:', error);
      });
  }, [petId]);

  const handleAdopt = () => {
    console.log('Adopt this pet:', petId);
    // Handle adoption logic, e.g., making an API call to update the pet's adoption status
  };

  const handleFoster = () => {
    console.log('Foster this pet:', petId);
    // Handle fostering logic, e.g., making an API call to update the pet's foster status
  };

  if (!pet) return <div>Loading...</div>; // Show loading while fetching data

  return (
    <div className="pet-details-container">
      <div className="pet-details-header">
        <img 
          src={pet.image || 'http://localhost:9000/images/default-image.jpg'} 
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
        <h3>Medical History</h3>
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
          <p>No medical history available.</p>
        )}
      </div>

      <div className="pet-details-actions">
        <button className="btn adopt-btn" onClick={handleAdopt}>Adopt</button>
        <button className="btn foster-btn" onClick={handleFoster}>Foster</button>
      </div>
    </div>
  );
};

export default PetDetailsPage;
