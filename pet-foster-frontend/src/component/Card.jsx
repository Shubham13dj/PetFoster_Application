import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios'; // Import axios
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css';
import 'swiper/css/pagination';
import { Pagination } from 'swiper/modules';
import './Card.css'; // Import the CSS file
import { UserContext } from '../App';
import { Navigate, useNavigate } from 'react-router-dom';

// Card component
const Card = () => {
  let navigate = useNavigate();
  const { userAuth:{ jsonToken }} = useContext(UserContext);
  const [pets, setPets] = useState([]);
  const [petImages, setPetImages] = useState({}); // Store pet images by ID

  // Fetch pet data from the API using axios
  useEffect(() => {
    axios.get('http://localhost:9000/pets',{
      headers:{
        "Authorization": `Bearer ${jsonToken}`
      }
    })
      .then((response) => {
        console.log('Fetched Data:', response.data); // Log the data
        setPets(response.data); // Set the fetched data in the state
      })
      .catch((error) => {
        console.error('Error fetching pets:', error); // Log any errors that happen during fetch
      });
  }, []); // Empty dependency array means this runs once when the component mounts

  // Fetch the pet images for each pet and store them in state using axios
  useEffect(() => {
    pets.forEach((pet) => {
      axios.get(`http://localhost:9000/pets/img/${pet.id}`, { responseType: 'blob' })
        .then((response) => {
          const imageUrl = URL.createObjectURL(response.data); // Create a URL for the image blob
          setPetImages((prevImages) => ({
            ...prevImages,
            [pet.id]: imageUrl, // Save image URL by pet ID
          }));
        })
        .catch((error) => {
          console.error(`Error fetching image for pet ${pet.id}:`, error);
        });
    });
  }, [pets]); // Only re-run when pets state changes
  function handleViewDetails (pet) {
    navigate(`/pet-details/${pet.id}`);
  }
  function handleFosterNow(pet) {
   
    navigate("/foster_request", { state: { pet } });
  }

  function handleAdoptToday(){

  }
  const filteredPets = pets.filter((pet) => pet.fostered === false); // Filter only unfostered pets

  // Render the Swiper with cards
  return (
    <div className="card-container">
      {/* Swiper for displaying cards */}
      <Swiper
        slidesPerView={4}
        spaceBetween={10} // Reduced space between slides
        pagination={{
          clickable: true,
        }}
        modules={[Pagination]}
        className="mySwiper"
      >
        {/* Map through the filtered pets data and create a Card for each one */}
        {filteredPets.map((pet) => (
          <SwiperSlide key={pet.id}>
            <div className="card">
              {/* Image section */}
              <img 
                src={petImages[pet.id] || 'http://localhost:9000/images/default-image.jpg'} // Fallback to default image if not loaded
                alt={pet.name} 
                className="card-img-top" 
                style={{ width: '100%', height: 'auto' }} // Optional inline styling
              />

              {/* Card body */}
              <div className="card-body">
                <h5 className="card-title">{pet.name}</h5>
                <p className="card-text">{pet.description}</p>
                <p className="card-text"><strong>Age:</strong> {pet.age} years</p>
                <p className="card-text"><strong>Location:</strong> {pet.location}</p>
                <p className="card-text">
                  {pet.adopted ? "Adopted" : "Available for Adoption"} | 
                  {pet.fostered ? " Fostered" : " Not Fostered"}
                </p>
                {
                  pet.fostered
                  ?
                  ""
                  :
                  <>
                  <button onClick={()=>handleViewDetails(pet)}>
                    View details
                  </button>
                  <button onClick={()=>handleFosterNow(pet)}>
                    Foster Now
                  </button>
                  <button onClick={handleAdoptToday}>
                    Adopt Today
                  </button>
                  </>
                }
              </div>
            </div>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default Card;
