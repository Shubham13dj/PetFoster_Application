import { Children } from "react";
import App from "../App";
import SignUp from "../component/SignUp";
import Login from "../component/Login";
import {
    createBrowserRouter
  } from "react-router-dom";

  const router = createBrowserRouter([
    {
        path: "/",
        element : <App/>,
        children: [
            // {
            //     path: "/",
            //     element: <h1>Home</h1>
            // },
            // {
            //     path: "/about",
            //     element: <h1>About</h1>
            // },
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
                element: <SignUp/>
            },{
                path: "/login",
                element: <Login/>
            }
        ]
    }
  ]
)

export default router;