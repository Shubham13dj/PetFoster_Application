import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios'; // Import axios for API calls
import '../styles/PetDetailsPage.css'; // Import custom CSS for styling
import { useNavigate, useParams } from 'react-router-dom';
import toast from 'react-hot-toast';
import { UserContext } from '../App';

const PetDetailsPage = () => {
  const navigate = useNavigate();
  const { userAuth, userAuth: { jsonToken } } = useContext(UserContext);
  const petId = useParams().id;
  const [pet, setPet] = useState(null);
  const [adoptionHistory, setAdoptionHistory] = useState([]);
  const [medicalHistory, setMedicalHistory] = useState([]);
  const [fosterRequest, setFosterRequest] = useState();
  const [showModal, setShowModal] = useState(false);
  const [termsAccepted, setTermsAccepted] = useState(false);

  // Fetch pet details, adoption history, and medical history
  useEffect(() => {
    axios.get(`http://localhost:9000/pets/${petId}`)
      .then((response) => {
        setPet(response.data);
      })
      .catch((error) => {
        console.error('Error fetching pet details:', error);
      });

    axios.get(`http://localhost:9000/adoption-history/${petId}`, {
      headers: {
        'Authorization': `Bearer ${jsonToken}`
      }
    })
      .then((response) => {
        setAdoptionHistory(response.data);
      })
      .catch((error) => {
        console.error('Error fetching adoption history:', error);
      });

    axios.get(`http://localhost:9000/pet-history/${petId}`, {
      headers: {
        'Authorization': `Bearer ${jsonToken}`
      }
    })
      .then((response) => {
        setMedicalHistory(response.data);
      })
      .catch((error) => {
        console.error('Error fetching medical history:', error);
      });

    axios.get(`http://localhost:9000/foster-request/pet/${petId}`,{
      headers: {
        'Authorization': `Bearer ${jsonToken}`
      }
    })
      .then((response) => {
        setFosterRequest(response.data);
          console.log(fosterRequest)
      })
      .catch((error) => {
        console.error('Error fetching foster request details:', error);
      });

  }, [petId, jsonToken]);

  const handleAdopt = () => {
    if (jsonToken) {
      console.log("Proceed with fostering process");
    } else {
      navigate("/login");
    }
  };

  const handleFoster = () => {
    if (jsonToken) {
      setShowModal(true);
    } else {
      navigate("/login");
    }
  };

  const confirmFoster = () => {
    if (termsAccepted) {
      axios.put(`http://localhost:9000/foster-request/${userAuth.id}/${petId}`, {}, {
        headers: {
          'Authorization': `Bearer ${jsonToken}`
        }
      })
        .then((response) => {
          toast.success("Foster request successful");
          navigate("/dashboard");
        })
        .catch((error) => {
          toast.error('Error processing foster request:', error);
        });
      setShowModal(false);
    } else {
      toast.error("You must accept the terms and conditions");
    }
  };

  if (!pet) return toast.loading();

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

      {jsonToken ? (
        <div className="pet-history">
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
        </div>
      ) : (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
          <h2>Please log in to see further details</h2>
        </div>
      )}

      <div className='pet-foster-request'>
        <h3>Foster request</h3>
        {fosterRequest ? (
          <table>
            <thead>
              <tr>
                <th>Id</th>
                <th>Owner id</th>
                <th>Start Date</th>
                <th>End Date</th>
              </tr>
            </thead>
            <tbody>
                <tr>
                  <td>{fosterRequest.id}</td>
                  <td>{fosterRequest.pet.userId}</td>
                  <td>{new Date(fosterRequest.startDate).toLocaleDateString()}</td>
                  <td>{new Date(fosterRequest.endDate).toLocaleDateString()}</td>
                </tr>
              
            </tbody>
          </table>
        ) : (
          <p>No foster request available.</p>
        )}
      </div>

      <div className="pet-details-actions">
        <button className="btn adopt-btn" onClick={handleAdopt}>Adopt</button>
        <button className="btn foster-btn" onClick={handleFoster}>Foster Now</button>
      </div>

      {showModal && (
        <div className="modal">
          <div className="modal-content">
            <h2>Terms and Conditions</h2>
            <p>Please read and accept the terms and conditions to foster the pet.</p>
            <textarea rows="10" cols="30" readOnly>
              Here are the terms and conditions...
            </textarea>
            <br />
            <input type="checkbox" id="acceptTerms" onChange={(e) => setTermsAccepted(e.target.checked)} />
            <label htmlFor="acceptTerms">I accept the terms and conditions</label>
            <br />
            <button onClick={confirmFoster}>Confirm</button>
            <button onClick={() => setShowModal(false)}>Cancel</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default PetDetailsPage;
