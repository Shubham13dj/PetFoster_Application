import { Children } from "react";
import App from "../App";
import SignUp from "../component/SignUp";
import Login from "../component/Login";
import {
    createBrowserRouter
  } from "react-router-dom";
import About from "../component/About";
import Register from "../component/Register";
import Homepage from "../component/Homepage";
import Logout from "../component/Logout";
import UserDashboard from "../component/UserDashboard";

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
            }
        ]
    }
  ]
)

export default router;