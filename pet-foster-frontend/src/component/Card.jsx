import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css';
import 'swiper/css/pagination';
import { Pagination } from 'swiper/modules';
import '../styles/Card.css'
import { UserContext } from '../App';
import { useNavigate } from 'react-router-dom';

// Card component
  const Card = ({role}) => {
  let navigate = useNavigate();
  const { userAuth: { jsonToken } } = useContext(UserContext);
 // const pets = ""
  const [pets, setPets] = useState([]);
     
   // Fetch pet data from the API using axios
   useEffect(() => {
     axios.get('http://localhost:9000/pets')
       .then((response) => {
         console.log('Fetched Data:', response.data);
         setPets(response.data);
       })
       .catch((error) => {
         console.error('Error fetching pets:', error);
       });
   }, []);
   console.log(process.env.REACT_APP_SERVER_DOMAIN);
   

  const handleViewDetails = (pet) => {
    navigate(`/pet-details/${pet.id}`);
  }

  const handleFosterNow = (pet) => {
    navigate("/foster_request", { state: { pet } });
  }

  const handleAdoptToday = () => {
    // Add your handle logic here
  }

  let filteredPets = "";
  if(role !== "FOSTER_PARENT")
  {
  filteredPets = pets;
}
  filteredPets = pets.filter(pet=> pet.availableToFoster === true || pet.availableToAdopt === true);



 // pets = pets.filter((pet) => !pet.fostered || !pet.adopted);
  return (
    <div className="card-container">
 <Swiper
  slidesPerView={1} // Default for small screens
  spaceBetween={10}
  pagination={{ clickable: true }}
  modules={[Pagination]}
  className="mySwiper"
  breakpoints={{
    640: {
      slidesPerView: 2, // 2 slides for tablets
    },
    1024: {
      slidesPerView: 4, // 4 slides for desktops
    },
  }}
>
  {filteredPets.map((pet) => (
    <SwiperSlide key={pet.id}>
      <div className="card">
      <img
  src={`data:${pet.imageType};base64,${pet.imageData}`}
  alt={pet.name}
  className="card-img-top"
  style={{ width: '100%', height: '200px', objectFit: 'cover' }}
/>
        <div className="card-body">
          <h5 className="card-title">{pet.name}</h5>
          <p className="card-text">{pet.description}</p>
          <p className="card-text"><strong>Age:</strong> {pet.age} years</p>
          <p className="card-text"><strong>Location:</strong> {pet.location}</p>
          <p className="card-text">
            {pet.adopted ? "Adopted" : "Available for Adoption"} | 
            {pet.fostered ? " Fostered" : " Not Fostered"}
          </p>
          {!pet.fostered && (
            <button onClick={() => handleViewDetails(pet)}>
              View details
            </button>
          )}
        </div>
      </div>
    </SwiperSlide>
  ))}
</Swiper>
    </div>
  );
};

export default Card;
