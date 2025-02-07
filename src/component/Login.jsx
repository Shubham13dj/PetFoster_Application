import React, { useContext, useState } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/Authprovider';
import googleLogo from '../imgs/google-logo.svg';

function Login() {
    const { login, loginWithGoogle } = useContext(AuthContext);
    const [error, setError] = useState('');
    const location = useLocation();
    const navigate = useNavigate();

    const form = location.state?.form?.pathname || "/";

    const handleSignUp = (event) => {
        event.preventDefault();
        const form = event.target;
        const email = form.email.value;
        const password = form.password.value;

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
        <div className="d-flex align-items-center justify-content-center vh-100 bg-light">
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
                        <p>Don't have an account? <Link to="/sign-up" className="text-primary">Sign Up</Link></p>
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
