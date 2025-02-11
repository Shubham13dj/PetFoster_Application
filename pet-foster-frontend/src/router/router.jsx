import { Children } from "react";
import App from "../App";
import Login from "../component/Login";
import CareerPage from "../component/CareerPage";
import BlogPage from "../component/BlogPage";
import TwitterPage from "../component/TwitterHelpCenter";
import FacebookHelpCenter from "../component/FacebookHelpCenter";
import ContactUs from "../component/ContactUs";
import {
    createBrowserRouter
  } from "react-router-dom";
import About from "../component/About";
import Register from "../component/Register";
import Homepage from "../component/Homepage";
import Logout from "../component/Logout";
import UserDashboard from "../component/UserDashboard";
import AddPetDetailsPage from "../component/AddPetDetailsPage";
import FosterRequestPage from "../component/FosterRequestPage";
import Petdetails from "../component/PetDetailsPage"

  const router = createBrowserRouter([
    {
        path: "/",
        element : <App/>,
        children: [
            {
                path: "/",
                element: <Homepage />
            },
            {
                path: "/about",
                element: <About />
            },
            {
                path: "/pet-details/:id",
                element: <Petdetails />
            }
            ,
            {
                path: "/foster_request/:id",
                element: <FosterRequestPage />
            },
            {
                path: "/logout",
                element: <Logout />
            },
            {
                path: "/Signup",
                element: <Register />
            },{
                path: "/login",
                element: <Login />
            },
            {
                path: "/dashboard",
                element: <UserDashboard />
            },
            {
                path: "/add-pet",
                element: <AddPetDetailsPage />
            },{
                path: "component/career",   
                element: <CareerPage />
              },{ 
                path: "/blog", 
                element: <BlogPage /> 
            }, {
                path: "/twitter",  
                element: <TwitterPage />  
            },{
                path: "/facebook",   
                element: <FacebookHelpCenter />,
              },{
                path: "/contact-us",  
                element: <ContactUs /> 
              }
        ]
    }
  ]
)

export default router;