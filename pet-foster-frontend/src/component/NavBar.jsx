import React, { useContext, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { FaBarsStaggered, FaBlog, FaXmark } from 'react-icons/fa6';
import  {AuthContext}  from '../context/Authprovider';
import { UserContext } from '../App';

function Navbar() {
  const [isSticky, setSticky] = useState(false);
  const {  user } = useContext(AuthContext);
  
  let { userAuth: { jsonToken }, setUserAuth } = useContext(UserContext)
  
  useEffect(() => {
    const handleScroll = () => {
      setSticky(window.scrollY > 100);
    };

    window.addEventListener('scroll', handleScroll);
    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  // Navigation items
  const navItems = 
  jsonToken ?
  [
    { link: 'Home', path: '/' },
    { link: 'About', path: '/about' },
    { link: 'Logout', path: '/logout' },
  ]
    :
  [ 
    { link: 'Home', path: '/' },
    { link: 'About', path: '/about' },
    { link: 'Sign Up', path: '/signup' },
    { link: 'Login', path: '/login' }
  ];

  return (
    <nav className={`navbar navbar-expand-lg ${isSticky ? 'bg-primary' : 'bg-dark'} fixed-top `}>
      <div className="container">
        {/* Brand Logo */}
        <Link to="/" className="navbar-brand text-primary fw-bold">
          <FaBlog className="me-2" /> Pet-Foster
        </Link>

        {/* Toggle Button for Mobile */}
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
        >
          <FaBarsStaggered />
        </button>

        {/* Navbar Links */}
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            {navItems.map((item) => (
              <li key={item.link} className="nav-item">
                <Link to={item.path} className="nav-link text-white">
                  {item.link}
                </Link>
              </li>
            ))}
          </ul>

          {/*  user Info (Only visible when logged in) */}
          <div className="d-flex align-items-center ms-3">
            { user ? (
              <span className="text-dark fw-bold">{ user.email}</span>
            ) : (
              ''
            )}
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
