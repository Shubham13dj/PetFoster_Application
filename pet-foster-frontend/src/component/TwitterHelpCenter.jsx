import React from 'react';
import '../styles/twitterHelpCenter.css';

function TwitterHelpCenter() {
  return (
    <div className="twitter-help-center-container">
      <h1 className="help-center-heading">💡 Twitter Help Center</h1>
      <p className="help-center-intro">
        Welcome to our Help Center! Here, you'll find helpful tips and resources to assist you in getting started, solving issues, and finding more about our services. If you need further assistance, feel free to reach out via our social media channels.
      </p>

      <div className="help-section">
        <h2 className="section-heading">How to Get Started</h2>
        <p className="help-text">
          Getting started with our service is easy! Follow these steps:
        </p>
        <ul className="help-steps">
          <li>1. Create an account on our website.</li>
          <li>2. Complete your profile setup.</li>
          <li>3. Explore the features available and start interacting with other users.</li>
          <li>4. If you face any issues, check the Help section or contact us through social media.</li>
        </ul>
      </div>

      <div className="social-media-section">
        <h2 className="section-heading">Follow Us on Twitter</h2>
        <p className="twitter-info">
          Stay updated with the latest news and tips by following us on Twitter. Join the conversation and let us know if you need any support!
        </p>
        <div className="twitter-feed">
          {/* Embed Twitter feed using an iframe */}
            <h2>https://x.com/PetFosterCdac</h2>
        </div>
      </div>
    </div>
  );
}

export default TwitterHelpCenter;
