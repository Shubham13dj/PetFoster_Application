import { Children } from "react";
import App from "../App";
import SignUp from "../component/SignUp";
import Login from "../component/Login";
import CareerPage from "../component/CareerPage";
import BlogPage from "../component/BlogPage";
import TwitterPage from "../component/TwitterHelpCenter";
import FacebookHelpCenter from "../component/FacebookHelpCenter";
import {
    createBrowserRouter
  } from "react-router-dom";
import About from "../component/About";
import Register from "../component/Register";
import Homepage from "../component/Homepage";
import Logout from "../component/Logout";
import UserDashboard from "../component/UserDashboard";
import AddPetDetailsPage from "../component/AddPetDetailsPage";

  const router = createBrowserRouter([
    {
        path: "/",
        element : <App/>,
        children: [
            {
                path: "",
                element: <Homepage />
            },
            {
                path: "/about",
                element: <About />
            },
            // {
            //     path: "/shop",
            //     element: <h1>Shop</h1>
            // }
            // ,
            // {
            //     path: "/contact",
            //     element: <h1>Contact</h1>
            // },
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
              }
        ]
    }
  ]
)

export default router;