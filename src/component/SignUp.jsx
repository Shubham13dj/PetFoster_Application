import React, { useContext, useState } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/Authprovider';
import googleLogo from '../imgs/google-logo.svg';
// import 'bootstrap/dist/css/bootstrap.min.css';

function SignUp() {
    const { createUser, loginWithGoogle } = useContext(AuthContext);
    const [error, setError] = useState('');
    const location = useLocation();
    const navigate = useNavigate();

    const handleSignUp = (event) => {
        event.preventDefault();
        const form = event.target;
        const email = form.email.value;
        const password = form.password.value;

        createUser(email, password)
            .then((userCredential) => {
                alert('Welcome! You have signed up successfully!');
                navigate('/');
            })
            .catch((error) => {
                setError(error.message);
            });
    };

    const handleRegister = () => {
        loginWithGoogle()
            .then((result) => {
                alert('Logged in with Google!');
                navigate('/');
            })
            .catch((error) => {
                setError(error.message);
            });
    };

    return (
        <div className="container d-flex justify-content-center align-items-center min-vh-100">
            <div className="card shadow-lg p-4" style={{ maxWidth: '400px', width: '100%' }}>
                <h2 className="text-center mb-3">Sign Up</h2>
                {error && <div className="alert alert-danger">{error}</div>}

                <form onSubmit={handleSignUp}>
                    <div className="mb-3">
                        <label htmlFor="email" className="form-label">
                            Email Address
                        </label>
                        <input type="email" name="email" className="form-control" required />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">
                            Password
                        </label>
                        <input type="password" name="password" className="form-control" required />
                    </div>
                    <p>
                        Already have an account? <Link to="/login" className="text-primary">Login</Link>
                    </p>
                    <button type="submit" className="btn btn-primary w-100">Sign Up</button>
                </form>

                <hr />
                <div className="text-center mt-3">
                    <button className="btn btn-light border w-100 d-flex align-items-center justify-content-center" onClick={handleRegister}>
                        <img src={googleLogo} alt="Google" className="me-2" style={{ width: '20px' }} />
                        Sign up with Google
                    </button>
                </div>
            </div>
        </div>
    );
}

export default SignUp;
