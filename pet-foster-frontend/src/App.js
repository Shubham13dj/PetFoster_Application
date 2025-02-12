// import React from 'react';
// import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; 
// import Register from './component/Register';
// import 'bootstrap/dist/css/bootstrap.min.css';
// import './App.css'; 
// import Layout from './component/Layout';
// import Authprovider from './context/Authprovider';
// import Navbar from './component/NavBar';
// import { Outlet } from 'react-router-dom';
// import Footer from './component/Footer';
// import FosterRequestPage from './component/FosterRequestPage';
// import AddPetDetailsPage from './component/AddPetDetailsPage';
// import { createContext, useEffect, useState } from 'react';
// import { lookInSession } from './common/session';

// export const UserContext = createContext({})
// const App = () => {

//   const [ userAuth, setUserAuth ] = useState({});

//     useEffect(()=>{
//         let userInSession = lookInSession("user");

//         userInSession ? setUserAuth(JSON.parse(userInSession)) : setUserAuth({ jsonToken: null })

//     }, [])

//   return (
//     <UserContext.Provider value={{userAuth, setUserAuth}}>
//     <div className="app-container">
//       <header>
//       <Navbar />  {/* Render the Navbar */}
//       </header>

//       <main  className="content">
//         {/* Render the child components here */}
//         <Outlet />  {/* This is where child routes will render */}
    
//       </main>

//       <footer className="footer">
//         <Footer /> {/* Render the Footer */}
//       </footer>
     
//     </div>
//     </UserContext.Provider>
//   );
// };

// export default App;
import React, { createContext, useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Outlet } from 'react-router-dom'; 
import Register from './component/Register';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'; 
import Layout from './component/Layout';
import Authprovider from './context/Authprovider';
import Navbar from './component/NavBar';
import Footer from './component/Footer';
import FosterRequestPage from './component/FosterRequestPage';
import AddPetDetailsPage from './component/AddPetDetailsPage';
import { lookInSession } from './common/session';

export const UserContext = createContext({});

const App = () => {
  const [userAuth, setUserAuth] = useState({});

  useEffect(() => {
    let userInSession = lookInSession("user");
    userInSession ? setUserAuth(JSON.parse(userInSession)) : setUserAuth({ jsonToken: null });
  }, []);

  return (
    <UserContext.Provider value={{userAuth, setUserAuth}}>
      <div className="app-container">
        <header>
          <Navbar />
        </header>

        <main className="content app-content">
          <Outlet />
        </main>

        <footer className="footer">
          <Footer />
        </footer>
      </div>
    </UserContext.Provider>
  );
};

export default App;
