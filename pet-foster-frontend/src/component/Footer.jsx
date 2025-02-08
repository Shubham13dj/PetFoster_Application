import React from 'react';
import { BsDribbble, BsFacebook, BsGithub, BsInstagram, BsTwitter } from 'react-icons/bs';

function Footer() {
  return (
    <footer className="bg-dark text-light py-4 mt-5">
      <div className="container">
        <div className="row">
          {/* Company Section */}
          <div className="col-md-3">
            <h5>Company</h5>
            <ul className="list-unstyled">
              <li><a href="#" className="text-light text-decoration-none">About</a></li>
              <li><a href="component/career" className="text-light text-decoration-none">Career</a></li>
              <li><a href="#" className="text-light text-decoration-none">Brand Center</a></li>
              <li><a href="#" className="text-light text-decoration-none">Blog</a></li>
            </ul>
          </div>

          {/* Help Center Section */}
          <div className="col-md-3">
            <h5>Help Center</h5>
            <ul className="list-unstyled">
              <li><a href="#" className="text-light text-decoration-none">Discord Server</a></li>
              <li><a href="#" className="text-light text-decoration-none">Twitter</a></li>
              <li><a href="#" className="text-light text-decoration-none">Facebook</a></li>
              <li><a href="#" className="text-light text-decoration-none">Contact Us</a></li>
            </ul>
          </div>

          {/* Legal Section */}
          <div className="col-md-3">
            <h5>Legal</h5>
            <ul className="list-unstyled">
              <li><a href="#" className="text-light text-decoration-none">Privacy Policy</a></li>
              <li><a href="#" className="text-light text-decoration-none">Licensing</a></li>
              <li><a href="#" className="text-light text-decoration-none">Terms & Conditions</a></li>
            </ul>
          </div>

          {/* Download Section */}
          <div className="col-md-3">
            <h5>Download</h5>
            <ul className="list-unstyled">
              <li><a href="#" className="text-light text-decoration-none">iOS</a></li>
              <li><a href="#" className="text-light text-decoration-none">Android</a></li>
              <li><a href="#" className="text-light text-decoration-none">Windows</a></li>
              <li><a href="#" className="text-light text-decoration-none">MacOS</a></li>
            </ul>
          </div>
        </div>

        {/* Copyright & Social Media */}
        <div className="d-flex justify-content-between align-items-center mt-4 border-top pt-3">
          <p className="mb-0">&copy; {new Date().getFullYear()} Pet-Foster. All Rights Reserved.</p>

          {/* Social Media Icons */}
          <div className="d-flex gap-3">
            <a href="#" className="text-light fs-5"><BsFacebook /></a>
            <a href="#" className="text-light fs-5"><BsInstagram /></a>
            <a href="#" className="text-light fs-5"><BsTwitter /></a>
            <a href="#" className="text-light fs-5"><BsGithub /></a>
            <a href="#" className="text-light fs-5"><BsDribbble /></a>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
