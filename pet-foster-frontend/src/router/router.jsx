import { Children } from "react";
import App from "../App";
import SignUp from "../component/SignUp";
import Login from "../component/Login";
import {
    createBrowserRouter
  } from "react-router-dom";
import About from "../component/About";
import Register from "../component/Register";
import HomePage from "../pages/HomePage";

  const router = createBrowserRouter([
    {
        path: "/",
        element : <App/>,
        children: [
            {
                path: "/",
                element: <HomePage />
            },
            {
                path: "/about",
                element: <About />
            },
            // {
            //     path: "/shop",
            //     element: <h1>Shop</h1>
            // }
            // ,{
            //     path: "/contact",
            //     element: <h1>Contact</h1>
            // }
            {
                path: "/Signup",
                element: <Register />
            },{
                path: "/login",
                element: <Login/>
            }
        ]
    }
  ]
)

export default router;