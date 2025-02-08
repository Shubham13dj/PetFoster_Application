import React from 'react';
import { BsDribbble, BsFacebook, BsGithub, BsInstagram, BsTwitter } from 'react-icons/bs';
import { Link } from "react-router-dom";
function Footer() {
  return (
    <footer className="bg-dark text-light py-4 mt-5">
      <div className="container">
        <div className="row">
          {/* Company Section */}
          <div className="col-md-3">
            <h5>Company</h5>
            <ul className="list-unstyled">
          
              <li><a href="component/career" className="text-light text-decoration-none">Career</a></li>
             
              <li><a href="/blog" className="text-light text-decoration-none">Blog</a></li>
            </ul>
          </div>

          {/* Help Center Section */}
          <div className="col-md-3">
            <h5>Help Center</h5>
            <ul className="list-unstyled">

              <li><Link to="/twitter" className="text-light text-decoration-none">Twitter</Link></li>
              <li><Link to="/facebook" className="text-light text-decoration-none">Facebook</Link></li>
              <li><Link to="/contact-us" className="text-light text-decoration-none">Contact Us</Link></li>
            </ul>
          </div>

       



        </div>

   
        <div className="d-flex justify-content-between align-items-center mt-4 border-top pt-3">
          <p className="mb-0">&copy; {new Date().getFullYear()} Pet-Foster. All Rights Reserved.</p>


        </div>
      </div>
    </footer>
  );
}

export default Footer;
