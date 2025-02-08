import React from "react";
import "../styles/About.css"; // Custom CSS for more styling
import missionImg from "../imgs/mission.jpg";
import valuesImg from "../imgs/values.jpg";

const About = () => {
  return (
    <div className="container my-5">
      <h2 className="text-center fw-bold display-5 mb-4">About PetFoster</h2>

      {/* Mission Section */}
      <div className="row align-items-center mb-5">
        <div className="col-md-6">
          <img src={missionImg} alt="Mission" className="img-fluid rounded shadow" />
        </div>
        <div className="col-md-6">
          <h3 className="fw-bold">Our Mission</h3>
          <p className="text-muted">
            Our mission is to create a network where pets and people find each other through the power of foster care.
            We ensure every pet receives love, care, and attention while waiting for adoption.
          </p>
          <button className="btn btn-primary mt-3">Learn More</button>
        </div>
      </div>

      {/* Values Section */}
      <div className="row align-items-center flex-md-row-reverse">
        <div className="col-md-6">
          <img src={valuesImg} alt="Values" className="img-fluid rounded shadow" />
        </div>
        <div className="col-md-6">
          <h3 className="fw-bold">Our Values</h3>
          <ul className="list-group list-group-flush">
            <li className="list-group-item">💖 Empathy and compassion for all animals</li>
            <li className="list-group-item">🏡 Creating strong pet-family bonds</li>
            <li className="list-group-item">🐾 Ensuring pets receive top care before adoption</li>
            <li className="list-group-item">🌍 Promoting responsible pet ownership</li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default About;
