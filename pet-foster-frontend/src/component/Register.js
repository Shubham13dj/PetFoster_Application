import React, { useState } from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import '../styles/Register.css'; // Import Register-specific styles (no need for App.css here)

const Register = () => {
  // State to capture form values
  const [formData, setFormData] = useState({
    name: '',
    gender: '',
    phoneNumber: '',
    email: '',
    password: '',
    role: '', // Based on UserRole (admin, user, etc.)
    isEnabled: true, // Assuming true by default
    petCount: 0, // Set to 0 initially
    specialization: '', // Optional field
  });

  // Handle form input changes
  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  // Handle form submission (e.g., making a POST request to backend API)
  const handleSubmit = async (e) => {
    e.preventDefault();

    // You would typically make an API call here
    try {
      const response = await fetch('http://your-backend-api-url/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData), // Sending form data to backend
      });

      if (response.ok) {
        alert('Registration successful!');
      } else {
        alert('Registration failed!');
      }
    } catch (error) {
      console.error('Error during registration:', error);
      alert('There was an error, please try again later.');
    }
  };

  return (
    <Container fluid className="d-flex justify-content-center align-items-center min-vh-100">
      <Row className="justify-content-center w-100">
        <Col md={6} className="d-flex justify-content-center">
          {/* Form Container */}
          <div className="register-form">
            <h2 className="text-center">Create an Account</h2>
            <Form onSubmit={handleSubmit}>
              {/* Name Input */}
              <Form.Group controlId="name" className="mb-3">
                <Form.Label>Name</Form.Label>
                <Form.Control
                  type="text"
                  name="name"
                  placeholder="Enter your name"
                  value={formData.name}
                  onChange={handleChange}
                />
              </Form.Group>

              {/* Gender Input */}
              <Form.Group controlId="gender" className="mb-3">
                <Form.Label>Gender</Form.Label>
                <Form.Control
                  as="select"
                  name="gender"
                  value={formData.gender}
                  onChange={handleChange}
                >
                  <option value="">Select Gender</option>
                  <option value="Male">Male</option>
                  <option value="Female">Female</option>
                  <option value="Other">Other</option>
                </Form.Control>
              </Form.Group>

              {/* Phone Number Input */}
              <Form.Group controlId="phoneNumber" className="mb-3">
                <Form.Label>Phone Number</Form.Label>
                <Form.Control
                  type="text"
                  name="phoneNumber"
                  placeholder="Enter your phone number"
                  value={formData.phoneNumber}
                  onChange={handleChange}
                />
              </Form.Group>

              {/* Email Input */}
              <Form.Group controlId="email" className="mb-3">
                <Form.Label>Email</Form.Label>
                <Form.Control
                  type="email"
                  name="email"
                  placeholder="Enter your email"
                  value={formData.email}
                  onChange={handleChange}
                />
              </Form.Group>

              {/* Password Input */}
              <Form.Group controlId="password" className="mb-3">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  name="password"
                  placeholder="Enter your password"
                  value={formData.password}
                  onChange={handleChange}
                />
              </Form.Group>

              {/* Specialization Input (optional) */}
              <Form.Group controlId="specialization" className="mb-3">
                <Form.Label>Specialization</Form.Label>
                <Form.Control
                  type="text"
                  name="specialization"
                  placeholder="Enter your specialization (optional)"
                  value={formData.specialization}
                  onChange={handleChange}
                />
              </Form.Group>

              {/* Submit Button */}
              <Button variant="primary" type="submit" className="w-100">
                Register
              </Button>
            </Form>
          </div>
        </Col>
      </Row>
    </Container>
  );
};

export default Register;
