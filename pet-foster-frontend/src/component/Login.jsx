import React, { useContext, useState } from 'react';
import { Link, useLocation, useNavigate, Navigate } from 'react-router-dom';
import { AuthContext } from '../context/Authprovider';
import googleLogo from '../imgs/google-logo.svg';
import loginpagecopy from '../imgs/loginpagecopy.jpg';  // Import the image
import { toast } from 'react-hot-toast';
import { UserContext } from '../App';
import { storeInSession } from '../common/session';
import axios from 'axios';

function Login() {
    const { login, loginWithGoogle } = useContext(AuthContext);
    const [error, setError] = useState('');
    const location = useLocation();
    const navigate = useNavigate();
    
    let { userAuth: { jsonToken }, setUserAuth } = useContext(UserContext)

    const form = location.state?.form?.pathname || "/";

    const userAuthThroughServer = (serverRoute, formData) => {
        console.log(process.env.REACT_APP_SERVER_DOMAIN)
        console.log(formData)
        axios.post("http://localhost:9000" + serverRoute, formData)
            .then(({ data }) => {
                storeInSession("user", JSON.stringify(data))
                // console.log(data)

                // console.log(sessionStorage)

                setUserAuth(data)
            })
            .catch(({ response }) => {
                //toast.error(response.data.error)
            })
    }
    
    const handleSignUp = (e) => {
        e.preventDefault();
        const form = e.target;
        const email = form.email.value;
        const password = form.password.value;

       let forms = new FormData(form);

       let formData = {}

       for(let [key, value] of forms.entries()){
        formData[key] = value;
       }

       userAuthThroughServer("/users/login", formData);

        login(email, password)
            .then((userCredential) => {
                alert("Welcome, you have logged in successfully!");
                navigate('/');
            })
            .catch((error) => {
                setError("Email or Password is incorrect");
            });
    };

    const handleRegister = () => {
        loginWithGoogle().then(() => {
            alert('Logged in with Google');
            navigate("/");
        });
    };

    return (
        jsonToken ?
            <Navigate to="/" />
        :
        <div
            className="d-flex align-items-center justify-content-center vh-100"
            style={{
                backgroundImage: `url(${loginpagecopy})`,
                backgroundSize: '80% 100%', 
                backgroundPosition: 'center',
                backgroundRepeat: 'no-repeat',
            }}
        >
            <div className="card shadow-lg p-4" style={{ width: "400px" }}>
                <div className="card-body">
                    <h2 className="text-center text-primary">Login</h2>
                    <form onSubmit={handleSignUp}>
                        <div className="mb-3">
                            <label htmlFor="email" className="form-label">Email address</label>
                            <input
                                type="email"
                                id="email"
                                name="email"
                                className="form-control"
                                placeholder="Enter your email"
                                required
                            />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="password" className="form-label">Password</label>
                            <input
                                type="password"
                                id="password"
                                name="password"
                                className="form-control"
                                placeholder="Enter your password"
                                required
                            />
                        </div>

                        {error && <p className="text-danger">{error}</p>}

                        <button type="submit" className="btn btn-primary w-100">Login</button>
                    </form>

                    <div className="text-center mt-3">
                        <p>Don't have an account? <Link to="/signup" className="text-primary">Sign Up</Link></p>
                    </div>

                    <hr />

                    <div className="d-flex justify-content-center">
                        <button onClick={handleRegister} className="btn btn-outline-dark d-flex align-items-center">
                            <img src={googleLogo} alt="Google Logo" className="me-2" width="24" />
                            Login with Google
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;


