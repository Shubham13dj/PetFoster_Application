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
  let filteredPets = pets;
  if(role === "FOSTER_PARENT")
  {
    
    filteredPets = pets.filter(pet=> pet.availableToFoster === true || pet.availableToAdopt === true);
  }

 // pets = pets.filter((pet) => !pet.fostered || !pet.adopted);
  return (
    <div className="card-container">
      <Swiper
        slidesPerView={4}
        spaceBetween={10}
        pagination={{ clickable: true }}
        modules={[Pagination]}
        className="mySwiper"
      >
        {filteredPets.map((pet) => (
          <SwiperSlide key={pet.id}>
            <div className="card">
              {/* <img
                src={`data:${pet.imageType};base64,${btoa(
                  String.fromCharCode(...new Uint8Array(pet.imageData))
                )}`}
                alt={pet.name}
                className="card-img-top"
                style={{ width: '100%', height: 'auto' }}
              /> */}
              <img
  src={`data:${pet.imageType};base64,${pet.imageData}`}
  alt={pet.name}
  className="card-img-top"
  style={{ width: '100%', height: 'auto' }}
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
                {
                  !pet.fostered &&
                  <>
                    <button onClick={() => handleViewDetails(pet)}>
                      View details
                    </button>
                    {/* <button onClick={() => handleFosterNow(pet)}>
                      Foster Now
                    </button>
                    <button onClick={handleAdoptToday}>
                      Adopt Today
                    </button> */}
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
