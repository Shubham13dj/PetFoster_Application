import React from 'react';
import '../styles/contactUs.css'; // Import the CSS file

function ContactUs() {
  return (
    <div className="contact-us-container">
      <h1>Contact Us</h1>
      <p>If you have any questions or concerns, feel free to reach out to us. We're here to help!</p>

      <div className="contact-info">
        <div className="info-item">
          <i className="fas fa-envelope"></i>
          <p>Email: <a href="mailto:support@petfoster.com">support@petfoster.com</a></p>
        </div>

        <div className="info-item">
          <i className="fas fa-phone-alt"></i>
          <p>Phone: <a href="tel:+918855008089">8855008089</a></p>
        </div>

        <div className="info-item">
          <i className="fas fa-map-marker-alt"></i>
          <p>Address: Pashan pune , Maharashtra </p>
        </div>

        <div className="info-item">
          <i className="fas fa-clock"></i>
          <p>Working Hours: Mon - Fri, 9 AM to 6 PM</p>
        </div>
      </div>

      <p>We look forward to assisting you!</p>
    </div>
  );
}

export default ContactUs;
