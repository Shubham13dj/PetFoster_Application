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
        console.log("----------------------------------");
        console.log(response.data);
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
          console.log(response.data)
      })
      .catch((error) => {
        console.error('Error fetching foster request details:', error);
      });

  }, [petId, jsonToken]);

  const handleAdopt = () => {
    if (jsonToken) {
      navigate(`/adopt-pet/${pet.id}`)
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
                  <td>{fosterRequest.pet.id}</td>
                  <td>{new Date(fosterRequest.startDate).toLocaleDateString()}</td>
                  <td>{new Date(fosterRequest.endDate).toLocaleDateString()}</td>
                </tr>
              
            </tbody>
          </table>
        ) : (
          <p>No foster request available.</p>
        )}
      </div>
      {
     
          userAuth.role === "USER" ? 
          <div className="pet-details-actions">
          <button className="btn adopt-btn" onClick={handleAdopt}>Adopt</button>
          </div>
          :
        <div className="pet-details-actions">
           <button className="btn adopt-btn" onClick={handleAdopt}>Adopt</button>
        <button className="btn foster-btn" onClick={handleFoster}>Foster Now</button>
      </div>

      }
      {showModal && (
        <div className="modal">
          <div className="modal-content">
            
             <div>
            
            <h1>Terms and Conditions for Foster Parents</h1>
    
    <h2>1. Eligibility Criteria</h2>
    <p><b>Age Requirement:</b> The foster parent must be at least 18 years old.</p>
    <p><b>Living Conditions:</b> The foster parent must have a stable living situation and adequate space for a pet.</p>
    <p><b>Background Check:</b> A background check will be conducted to ensure that the foster parent has no history of animal abuse, neglect, or criminal activity.</p>
    <p><b>Health Requirements:</b> Foster parents must be physically and emotionally capable of caring for a pet.</p>
    
    <h2>2. Duration of Foster Care</h2>
    <p><b>Fostering Period:</b> The foster parent agrees to provide temporary care for a pet for a period of {Math.ceil(Math.abs(new Date(fosterRequest.endDate) - new Date(fosterRequest.startDate)) / (1000 * 60 * 60 * 24))} weeks/months, unless otherwise agreed.</p>
    <p><b>Termination of Foster Care:</b> Either party can terminate the fostering agreement with 5 day’s notice, provided the pet is returned to the organization or an agreed-upon foster care provider.</p>
    
    <h2>3. Care and Welfare of the Pet</h2>
    <p><b>Daily Care:</b> The foster parent agrees to provide the pet with adequate food, water, shelter, exercise, and any necessary medical treatment.</p>
    <p><b>Veterinary Care:</b> The foster parent will notify the organization immediately if the pet requires veterinary attention. The organization will cover veterinary costs, except for situations where the foster parent is at fault.</p>
    <p><b>Behavioral Issues:</b> The foster parent will notify the organization if the pet displays any behavioral issues that require attention or training.</p>
    <p><b>No Sale or Transfer:</b> The foster parent agrees not to sell, transfer, or re-home the pet without the express written consent of the organization.</p>
    
    <h2>4. Foster Parent Responsibilities</h2>
    <p><b>Training:</b> The foster parent agrees to participate in any training sessions or programs provided by the organization to ensure the well-being of the pet.</p>
    <p><b>Daily Updates:</b> The foster parent will provide regular updates to the organization, including photos, videos, and detailed reports on the pet’s behavior and health.</p>
    <p><b>Communication:</b> The foster parent agrees to maintain open communication with the organization and respond promptly to any inquiries regarding the pet.</p>
    
    <h2>5. Ownership and Legalities</h2>
    <p><b>Legal Ownership:</b> The foster parent acknowledges that they do not have legal ownership of the pet and that the organization retains full ownership.</p>
    <p><b>Return of Pet:</b> Upon the end of the fostering agreement, the foster parent agrees to return the pet to the organization or as directed by the organization.</p>
    <p><b>Liability:</b> The foster parent acknowledges that the organization is not liable for any injuries, damages, or losses caused by the pet during the fostering period.</p>
    
    <h2>6. Adoption Process</h2>
    <p><b>Adoption Option:</b> If the foster parent is interested in adopting the pet, they will need to go through the standard adoption process, including an adoption application and payment of any applicable fees.</p>
    <p><b>First Right of Refusal:</b> The foster parent may be given the first right to adopt the pet once it becomes available for adoption, depending on the organization’s policies.</p>
    
    <h2>7. Financial Obligations</h2>
    <p><b>Costs Covered by Organization:</b> The organization will cover the costs of the pet’s food, veterinary care, and other necessary supplies.</p>
    <p><b>Foster Parent Expenses:</b> The foster parent may be required to cover minor costs such as transportation for the pet, any grooming expenses, or items not covered by the organization.</p>
    
    <h2>8. Emergency Situations</h2>
    <p><b>Emergency Contact:</b> The foster parent must have an emergency contact who can take over pet care if necessary.</p>
    <p><b>In Case of Illness or Injury:</b> If the pet becomes seriously ill or injured, the foster parent will immediately notify the organization, which will provide instructions for handling the situation.</p>
    
    <h2>9. Non-Disclosure Agreement</h2>
    <p><b>Confidentiality:</b> The foster parent agrees to keep confidential any personal information about the pet, the organization, and other foster parents involved in the program.</p>
    
    <h2>10. Termination of Agreement</h2>
    <p><b>Breach of Terms:</b> If the foster parent fails to comply with these terms and conditions, the organization has the right to remove the pet from their care at any time without prior notice.</p>
    <p><b>Failure to Return Pet:</b> If the foster parent fails to return the pet as agreed, legal action may be pursued to regain possession of the pet.</p>
    
    <h2>11. Indemnification and Waiver of Liability</h2>
    <p><b>Release of Liability:</b> The foster parent agrees to indemnify and hold harmless the organization, its employees, agents, and volunteers from any claims, damages, or injuries arising from the fostering arrangement.</p>
    <p><b>Waiver of Claims:</b> The foster parent agrees to waive any claims for compensation or damages related to the fostering arrangement, except in cases of gross negligence or intentional misconduct by the organization.</p>
             </div>
           
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
