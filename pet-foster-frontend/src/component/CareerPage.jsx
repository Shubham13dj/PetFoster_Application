import React from "react";
import "../styles/career.css"; // Import CSS file for styling

function CareerPage() {
  return (
    <div className="career-container">
      <h1>🐾 Join Our Pet Foster Team! 🐾</h1>
      <p className="career-intro">
        Passionate about animals? Want to make a difference in pet care and adoption? 
        Join our mission to create a loving and safe environment for every pet! ❤️
      </p>

      <h2>📌 Current Openings</h2>

      <div className="job-card">
        <h3>🐶 Pet Care Specialist</h3>
        <p><strong>Responsibilities:</strong></p>
        <ul>
          <li>Ensure proper care, feeding, and exercise of pets</li>
          <li>Monitor pet health and well-being</li>
          <li>Educate foster families on pet care best practices</li>
        </ul>
        <p><strong>Requirements:</strong></p>
        <ul>
          <li>Experience in pet care or veterinary assistance</li>
          <li>Love and passion for animals</li>
          <li>Basic knowledge of pet health and nutrition</li>
        </ul>
      </div>

      <div className="job-card">
        <h3>🏠 Foster Coordinator</h3>
        <p><strong>Responsibilities:</strong></p>
        <ul>
          <li>Connect pets with the right foster families</li>
          <li>Provide guidance and support to foster caregivers</li>
          <li>Ensure pets are placed in a safe and loving environment</li>
        </ul>
        <p><strong>Requirements:</strong></p>
        <ul>
          <li>Experience in animal rescue or foster coordination</li>
          <li>Strong organizational and communication skills</li>
          <li>Ability to manage multiple foster placements</li>
        </ul>
      </div>

      <div className="job-card">
        <h3>📢 Adoption Outreach Specialist</h3>
        <p><strong>Responsibilities:</strong></p>
        <ul>
          <li>Promote pet adoption programs</li>
          <li>Work with shelters and rescue organizations</li>
          <li>Organize pet adoption events</li>
        </ul>
        <p><strong>Requirements:</strong></p>
        <ul>
          <li>Experience in marketing or community outreach</li>
          <li>Passion for animal welfare</li>
          <li>Creative ideas to boost pet adoptions</li>
        </ul>
      </div>

      <div className="job-card">
        <h3>💻 Pet Tech Developer</h3>
        <p><strong>Responsibilities:</strong></p>
        <ul>
          <li>Develop and maintain the Pet Foster platform</li>
          <li>Enhance the user experience for pet lovers</li>
          <li>Ensure seamless communication between foster parents and shelters</li>
        </ul>
        <p><strong>Requirements:</strong></p>
        <ul>
          <li>Experience in JavaScript (React.js preferred)</li>
          <li>Knowledge of backend development and databases</li>
          <li>Passion for technology and pet welfare</li>
        </ul>
      </div>

      <h2>📞 Get in Touch</h2>
      <p>Interested? Contact us at:</p>
      <p className="contact-details">
        📧 Email: <a href="Cdac@petfoster.com">careers@petfoster.com</a><br />
        📞 Phone: +91 88550 08089
      </p>
    </div>
  );
}

export default CareerPage;
