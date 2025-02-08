import React, { useState, useEffect } from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css';
import 'swiper/css/pagination';
import { Pagination } from 'swiper/modules';
import './Card.css'; // Import the CSS file

// Card component
const Card = () => {
  const [pets, setPets] = useState([]);

  // Fetch data from the API
  useEffect(() => {
    fetch('http://localhost:8080/pets')
      .then((response) => response.json()) // Parse the response to JSON
      .then((data) => {
        console.log('Fetched Data:', data); // Log the data
        setPets(data); // Set the fetched data in the state
      })
      .catch((error) => {
        console.error('Error fetching pets:', error); // Log any errors that happen during fetch
      });
  }, []); // Empty dependency array means this runs once when the component mounts

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
          <SwiperSlide key={pet.foster_id}>
            <div className="card">
              {/* Image section */}
              <img src={pet.photo_url} alt={pet.name} className="card-img-top" />

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
              </div>
            </div>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default Card;
