import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import "../styles/PetAdoptionForm.css"
import { Navigate, useNavigate, useParams } from 'react-router-dom';
import { UserContext } from '../App';


 
const PetAdoptionPage = () => {

  const Id = useParams();
  console.log(Id);
  const petId = Id.id;

  const navigate = useNavigate();
   
  const { userAuth, userAuth: { jsonToken } } = useContext(UserContext);

  const [pet, setPet] = useState(null);  // Store pet details
  const [adoptedPetId, setAdoptedPetId] = useState(null);
  const [agreedToTerms, setAgreedToTerms] = useState(false); // Check if terms are agreed

  // Fetch pet details on component mount
  useEffect(() => {
    axios.get(`http://localhost:9000/pets/${petId}`) // Assuming your API endpoint is '/api/pets'
      .then(response => setPet(response.data))
      .catch(error => console.error('Error fetching pet details:', error));
  }, [petId]);

  // Handle pet adoption
  const handleAdopt = () => {
    if (!pet) return;  // Prevent further execution if pet data is not available

    let formData = new FormData();

    // Use the adopter's information from userAuth
    const adoptionRequest = {
        adopter: userAuth.id,  // Use adopter ID from user context
        requestDate: new Date().toISOString(),
        status: "PENDING",  // Set status as "PENDING"
        pet: pet.id,  // Attach the pet ID to the request
      };

      console.log(adoptionRequest);
    // Update pet status to adopted in your backend API
    axios.post(`http://localhost:9000/adoption-request`, adoptionRequest, {
      headers: {
        "Authorization": `Bearer ${jsonToken}`,
        "content-type": "application/json",
      },
    })
      .then(response => {
        alert('Pet successfully adopted!');
        setAdoptedPetId(pet.id);
        navigate("/");
      })
      .catch(error => {
        console.error('Error adopting pet:', error);
        alert('There was an error processing the adoption.');
      });
  };

  // Enable/Disable Submit button based on checkbox agreement
  const isSubmitDisabled = !agreedToTerms;

  return (
    <div className="pet-adoption-page">
      <h1>Pet Adoption Agreement Form</h1>

      <div className="pet-details-container">
        {/* Check if pet data is available before rendering pet info */}
        {pet ? (
          <>
            <div className="pet-image-container">
              {/* Display pet image */}
              <img src={`data:${pet.imageType};base64,${pet.imageData}`} alt={pet.name} className="pet-image" />
              <h2>{pet.name}</h2>
            </div>

            <div className="adoption-form">
              <form>
                {/* Adopter's Information (auto-filled from userAuth) */}
                <label>
                  Name of Adopter:
                  <input
                    type="text"
                    value={userAuth.name}  // Use name from userAuth
                    readOnly
                  />
                </label>
                <label>
                  Email:
                  <input
                    type="email"
                    value={userAuth.email}  // Use email from userAuth
                    readOnly
                  />
                </label>
                <label>
                  Contact Number:
                  <input
                    type="text"
                    value={userAuth.phoneNumber}  // Use contact number from userAuth
                    readOnly
                  />
                </label>

                {/* Terms and Conditions */}
                <div className="terms-conditions">
                  <h3>Adoption Terms and Conditions</h3>
                  <p>
                    By adopting a pet, you agree to the following terms:
                    <ul>
                      <li>You will provide a loving, caring, and safe environment for the pet.</li>
                      <li>You agree to keep the pet up to date with necessary vaccinations and medical care.</li>
                      <li>You will not transfer ownership of the pet to any third party without prior approval.</li>
                      <li>If for any reason you are unable to care for the pet, you will contact us immediately to return the pet.</li>
                      <li>The pet will not be used for breeding purposes.</li>
                      <li>You acknowledge that adoption is a long-term commitment and should not be taken lightly.</li>
                    </ul>
                  </p>
                </div>

                {/* Agreement Checkbox */}
                <div className="terms-checkbox">
                  <label>
                    <input
                      type="checkbox"
                      checked={agreedToTerms}
                      onChange={() => setAgreedToTerms(!agreedToTerms)}
                    />
                    I agree to the Pet Adoption Terms and Conditions.
                  </label>
                </div>

                {/* Submit Button */}
                <button
                  type="button"
                  onClick={handleAdopt}
                  disabled={isSubmitDisabled}  // Disable if terms not agreed
                >
                  {adoptedPetId === pet.id ? 'Adopted' : 'Submit Adoption Request'}
                </button>
              </form>
            </div>
          </>
        ) : (
          <p>Loading pet details...</p>  
        )}
      </div>
    </div>
  );
}

export default PetAdoptionPage;
