import React, { useState, useEffect } from "react";
import "../styles/Homepage.css";
import Card from './Card'
import img1 from "../imgs/img1.jpg";
import img2 from "../imgs/img2.jpg";
import img3 from "../imgs/img3.jpg";
import img4 from "../imgs/img4.jpg";

const images = [img1, img2, img3, img4];
const texts = [
  {
    title: "Give Them a Second Chance 🐾",
    description: "Open your heart and home to a pet in need.",
  },
  {
    title: "Every Paw Deserves Love ❤",
    description: "Your kindness can change a life forever.",
  },
  {
    title: "Be Their Hero 🦸‍♂",
    description: "Foster a pet and make a real difference today.",
  },
  {
    title: "Help Create a Better Tomorrow 🌎",
    description: "Provide a safe and loving home for a pet in need.",
  },
];

function Homepage() {
  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    const timer = setInterval(() => {
      setCurrentIndex((prevIndex) => (prevIndex + 1) % images.length);
    }, 4000);
    return () => clearInterval(timer); // Clean up on component unmount
  }, []);

  const handleNext = () => {
    setCurrentIndex((prevIndex) => (prevIndex + 1) % images.length);
  };

  const handlePrev = () => {
    setCurrentIndex(
      (prevIndex) => (prevIndex - 1 + images.length) % images.length
    );
  };

  return (
    <div className="homepage-container">
      <div className="slideshow">
        <div className="slide">
          <img src={images[currentIndex]} alt="Slide" className="slide-image" />
          <div className="image-text">
            <h2>{texts[currentIndex].title}</h2>
            <p>{texts[currentIndex].description}</p>
          </div>
        </div>
        <button className="prev-btn" onClick={handlePrev}>
          ❮
        </button>
        <button className="next-btn" onClick={handleNext}>
          ❯
        </button>
      </div>

      <div>
        <Card/>
      </div>
    </div>
  );
}

export default Homepage;