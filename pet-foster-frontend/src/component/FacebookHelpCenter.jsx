import React from 'react';
import '../styles/facebookHelpCenter.css';

function FacebookHelpCenter() {
  return (
    <div className="facebook-help-center-container">
      <h1 className="help-center-heading">💡 Facebook Help Center</h1>
      <p className="help-center-intro">
        Welcome to our Facebook Help Center! Find answers to common questions and learn more about how to use our service.
      </p>

      <div className="help-section">
        <h2 className="section-heading">How to Get Started on Facebook</h2>
        <p className="help-text">
          Getting started with Facebook is easy! Follow these steps:
        </p>
        <ul className="help-steps">
          <li>1. Create an account on Facebook.</li>
          <li>2. Set up your profile with a profile picture and bio.</li>
          <li>3. Explore the News Feed and start interacting with posts.</li>
          <li>4. If you encounter any issues, check the Help section or contact us.</li>
        </ul>
      </div>

      <div className="social-media-section">
        <h2 className="section-heading">Follow Us on Facebook</h2>
        <p className="facebook-info">
          Stay updated with the latest news and tips by following us on Facebook. Join the conversation and let us know if you need any help!
        </p>
        <div className="facebook-feed">
          {/* Embed Facebook feed using an iframe */}
            <h2>https://facebook.com/PetFosterCdac</h2>
        </div>
      </div>
    </div>
  );
}

export default FacebookHelpCenter;
