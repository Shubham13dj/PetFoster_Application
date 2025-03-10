import React, { useContext, useState } from 'react';
import { Form, Button, Container, Row, Col, Card, Alert } from 'react-bootstrap';
import axios from 'axios';
import { toast } from 'react-hot-toast';
import { UserContext } from '../App';
// import '../styles/AddPetDetailsPage.css'

const AddPetDetailsPage = () => {
  const [petName, setPetName] = useState('');
  const [petAge, setPetAge] = useState('');
  const [species, setSpecies] = useState('');
  const [breed, setBreed] = useState('');
  const [healthStatus, setHealthStatus] = useState('');
  const [location, setLocation] = useState('');
  const [description, setDescription] = useState('');
  const [photo, setPhoto] = useState(null);
  const [availableForAdopt, setAvailableForAdopt] = useState(false);
  const [availableForFoster, setAvailableForFoster] = useState(false);
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);

  const { userAuth, userAuth: { jsonToken } } = useContext(UserContext);

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!petName || !petAge || !species || !breed || !healthStatus || !location) {
      setError('Please fill out all fields and upload a photo.');
      setSuccess(false);
      return;
    }

    if (!/^[A-Za-z\s]+$/.test(petName)) {
      setError('Pet name should only contain letters and spaces.');
      setSuccess(false);
      return;
    }

    if (isNaN(petAge) || petAge <= 0) {
      setError('Pet age should be a valid positive number.');
      setSuccess(false);
      return;
    }

    if (!/^\d{6}$/.test(location)) {
      setError('Location (pincode) should be a 6-digit number.');
      setSuccess(false);
      return;
    }

    const formData = new FormData();
    const petData = {
      name: petName,
      age: petAge,
      species: species,
      breed: breed,
      healthStatus: healthStatus,
      location: location,
      description: description,
      availableForAdopt: availableForAdopt,
      availableForFoster: availableForFoster
    };

    formData.append('petDetails', new Blob([JSON.stringify(petData)], { type: 'application/json' }));
    formData.append('imageData', photo);
    formData.append("userId", userAuth.id);

    try {
      const response = await axios.post(`http://localhost:9000/pets/${userAuth.id}`, formData, {
        headers: {
          'Authorization': `Bearer ${jsonToken}`,
        },
      });

      setError('');
      setSuccess(true);
      setPetName('');
      setPetAge('');
      setSpecies('');
      setBreed('');
      setHealthStatus('');
      setLocation('');
      setDescription('');
      setPhoto(null);
      setAvailableForAdopt(false);
      setAvailableForFoster(false);
    } catch {
      toast.error("Error: Cannot insert Data");
    }
  };

  const handleClear = () => {
    setPetName('');
    setPetAge('');
    setSpecies('');
    setBreed('');
    setHealthStatus('');
    setLocation('');
    setDescription('');
    setPhoto(null);
    setAvailableForAdopt(false);
    setAvailableForFoster(false);
    setError('');
    setSuccess(false);
  };

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
              {error && <Alert variant="danger">{error}</Alert>}
              {success && <Alert variant="success">Pet added successfully!</Alert>}
              <Form onSubmit={handleSubmit}>
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
                <Form.Group controlId="formPhoto">
                  <Form.Label className="fw-bold">Upload Photo</Form.Label>
                  <Form.Control
                    type="file"
                    onChange={handlePhotoChange}
                    required
                  />
                </Form.Group>
                <Form.Group controlId="formAvailableForAdopt">
                  <Form.Check 
                    type="checkbox" 
                    label="Available for Adoption"
                    checked={availableForAdopt}
                    onChange={(e) => setAvailableForAdopt(e.target.checked)}
                  />
                </Form.Group>
                <Form.Group controlId="formAvailableForFoster">
                  <Form.Check 
                    type="checkbox" 
                    label="Available for Foster"
                    checked={availableForFoster}
                    onChange={(e) => setAvailableForFoster(e.target.checked)}
                  />
                </Form.Group>
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
