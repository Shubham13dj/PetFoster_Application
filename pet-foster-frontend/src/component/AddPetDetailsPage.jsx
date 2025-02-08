import React, { useState } from 'react';
import { Form, Button, Container, Row, Col, Card, Alert } from 'react-bootstrap';

const AddPetDetailsPage = () => {
  // State hooks to store form values and validation errors
  const [petName, setPetName] = useState('');
  const [petAge, setPetAge] = useState('');
  const [species, setSpecies] = useState('');
  const [breed, setBreed] = useState('');
  const [healthStatus, setHealthStatus] = useState('');
  const [location, setLocation] = useState('');
  const [description, setDescription] = useState('');
  const [photo, setPhoto] = useState(null);
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Basic validation: Check if all fields are filled and photo is uploaded
    if (!petName || !petAge || !species || !breed || !healthStatus || !location || !description || !photo) {
      setError('Please fill out all fields and upload a photo.');
      setSuccess(false);
      return;
    }

    // Validate Pet Name (should not be a number or special character)
    if (!/^[A-Za-z\s]+$/.test(petName)) {
      setError('Pet name should only contain letters and spaces.');
      setSuccess(false);
      return;
    }

    // Validate Pet Age (should be a valid number)
    if (isNaN(petAge) || petAge <= 0) {
      setError('Pet age should be a valid positive number.');
      setSuccess(false);
      return;
    }

    // Validate Location (should be a 6-digit number)
    if (!/^\d{6}$/.test(location)) {
      setError('Location (pincode) should be a 6-digit number.');
      setSuccess(false);
      return;
    }

    // If validation passes
    setError('');
    setSuccess(true);
    console.log('Pet Added:', { petName, petAge, species, breed, healthStatus, location, description, photo });

    // Reset form after successful submission
    setPetName('');
    setPetAge('');
    setSpecies('');
    setBreed('');
    setHealthStatus('');
    setLocation('');
    setDescription('');
    setPhoto(null);
  };

  // Handle form reset
  const handleClear = () => {
    setPetName('');
    setPetAge('');
    setSpecies('');
    setBreed('');
    setHealthStatus('');
    setLocation('');
    setDescription('');
    setPhoto(null);
    setError('');
    setSuccess(false);
  };

  // Handle photo upload
  const handlePhotoChange = (e) => {
    setPhoto(e.target.files[0]);
  };

  return (
    <Container className="mt-5">
      <Row className="justify-content-center">
        <Col lg={8} md={10} sm={12}>
          <Card className="shadow-lg rounded p-4">
            <Card.Body>
              <h2 className="text-center mb-4" style={{ color: '#2c3e50' }}>Add Pet Details</h2>

              {/* Display error or success message */}
              {error && <Alert variant="danger">{error}</Alert>}
              {success && <Alert variant="success">Pet added successfully!</Alert>}

              {/* Form */}
              <Form onSubmit={handleSubmit}>
                {/* Pet Name */}
                <Form.Group controlId="formPetName">
                  <Form.Label className="fw-bold">Pet Name</Form.Label>
                  <Form.Control
                    type="text"
                    value={petName}
                    onChange={(e) => setPetName(e.target.value)}
                    isInvalid={!petName}
                    required
                    placeholder="Enter Pet Name"
                  />
                  <Form.Control.Feedback type="invalid">
                    Please enter a valid pet name.
                  </Form.Control.Feedback>
                </Form.Group>

                {/* Pet Age */}
                <Form.Group controlId="formPetAge">
                  <Form.Label className="fw-bold">Age</Form.Label>
                  <Form.Control
                    type="number"
                    value={petAge}
                    onChange={(e) => setPetAge(e.target.value)}
                    isInvalid={!petAge}
                    required
                    placeholder="Enter Pet Age"
                  />
                  <Form.Control.Feedback type="invalid">
                    Please enter a valid age.
                  </Form.Control.Feedback>
                </Form.Group>

                {/* Species */}
                <Form.Group controlId="formSpecies">
                  <Form.Label className="fw-bold">Species</Form.Label>
                  <Form.Control
                    as="select"
                    value={species}
                    onChange={(e) => setSpecies(e.target.value)}
                    required
                  >
                    <option value="">Select Species</option>
                    <option value="Dog">Dog</option>
                    <option value="Cat">Cat</option>
                    <option value="Rabbit">Rabbit</option>
                    <option value="Bird">Bird</option>
                    <option value="Reptile">Reptile</option>
                  </Form.Control>
                </Form.Group>

                {/* Breed */}
                <Form.Group controlId="formBreed">
                  <Form.Label className="fw-bold">Breed</Form.Label>
                  <Form.Control
                    type="text"
                    value={breed}
                    onChange={(e) => setBreed(e.target.value)}
                    required
                    placeholder="Enter Pet Breed"
                  />
                </Form.Group>

                {/* Health Status */}
                <Form.Group controlId="formHealthStatus">
                  <Form.Label className="fw-bold">Health Status</Form.Label>
                  <Form.Control
                    as="select"
                    value={healthStatus}
                    onChange={(e) => setHealthStatus(e.target.value)}
                    required
                  >
                    <option value="">Select Health Status</option>
                    <option value="Healthy">Healthy</option>
                    <option value="Needs Treatment">Needs Treatment</option>
                    <option value="Recovering">Recovering</option>
                  </Form.Control>
                </Form.Group>

                {/* Location (Pincode) */}
                <Form.Group controlId="formLocation">
                  <Form.Label className="fw-bold">Location (Pincode)</Form.Label>
                  <Form.Control
                    type="text"
                    value={location}
                    onChange={(e) => setLocation(e.target.value)}
                    isInvalid={!location}
                    required
                  />
                  <Form.Control.Feedback type="invalid">
                    Please enter a valid 6-digit pincode.
                  </Form.Control.Feedback>
                </Form.Group>

                {/* Description */}
                <Form.Group controlId="formDescription">
                  <Form.Label className="fw-bold">Description</Form.Label>
                  <Form.Control
                    as="textarea"
                    rows={3}
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    placeholder="Add a description..."
                  />
                </Form.Group>

                {/* Photo Upload */}
                <Form.Group controlId="formPhoto">
                  <Form.Label className="fw-bold">Upload Photo</Form.Label>
                  <Form.Control
                    type="file"
                    onChange={handlePhotoChange}
                    required
                  />
                </Form.Group>

                {/* Submit and Clear Buttons */}
                <div className="mt-4 d-flex justify-content-between">
                  <Button variant="success" type="submit" className="px-4 py-2" style={{ borderRadius: '5px' }}>
                    Submit
                  </Button>
                  <Button variant="danger" onClick={handleClear} className="px-4 py-2" style={{ borderRadius: '5px' }}>
                    Clear
                  </Button>
                </div>
              </Form>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default AddPetDetailsPage;
