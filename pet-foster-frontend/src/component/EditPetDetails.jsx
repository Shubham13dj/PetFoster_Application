import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import FosterRequestPage from './FosterRequestPage'; // Import your foster form component
import { Container, Row, Col, Card, Form, Button, Alert } from 'react-bootstrap';

const PetDetails = () => {
    const navigate = useNavigate();
    
    
    const Id = useParams();
    const petId = Id.id;


    const [pet, setPet] = useState();
    const [petAge, setPetAge] = useState('');
    const [healthStatus, setHealthStatus] = useState('');
    const [location, setLocation] = useState('');
    const [description, setDescription] = useState('');
    const [availableForAdopt, setAvailableForAdopt] = useState(false);
    const [availableForFoster, setAvailableForFoster] = useState(false);
    const [showFosterForm, setShowFosterForm] = useState(false);

    useEffect(() => {
        axios.get(`http://localhost:9000/pets/${petId}`)
            .then((response) => {
                const petData = response.data;
                setPet(petData);
                setPetAge(petData.age);
                setHealthStatus(petData.healthStatus);
                setLocation(petData.location);
                setDescription(petData.description);
                setAvailableForAdopt(petData.availableForAdopt);
                setAvailableForFoster(petData.availableForFoster);
            })
            .catch((error) => {
                console.error('Error fetching pet details:', error);
            });
    }, [petId]);

    const handleFosterChange = (e) => {
        setAvailableForFoster(e.target.checked);
        setShowFosterForm(e.target.checked);
    };

    const handleFosterFormClose = () => {
        setShowFosterForm(false);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log({
            petAge,
            healthStatus,
            location,
            description,
            availableForAdopt,
            availableForFoster
        });
    };

    if (!pet) {
        return <div>Loading...</div>;
    }

    return (
        <Container className="mt-5">
            <Row className="justify-content-center">
                <Col lg={6} md={8} sm={12}>
                    <Card className="shadow-lg rounded p-4">
                        <Card.Body>
                            <h2 className="text-center mb-4" style={{ color: '#2c3e50' }}>
                                Pet Details for {pet ? pet.name : 'Pet'}
                            </h2>

                            <Form onSubmit={handleSubmit}>
                                <Form.Group controlId="formPetName">
                                    <Form.Label className="fw-bold">Pet Name</Form.Label>
                                    <Form.Control type="text" value={pet.name} readOnly />
                                </Form.Group>

                                <Form.Group controlId="formPetAge">
                                    <Form.Label className="fw-bold">Age</Form.Label>
                                    <Form.Control
                                        type="number"
                                        value={petAge}
                                        onChange={(e) => setPetAge(e.target.value)}
                                        required
                                    />
                                </Form.Group>

                                <Form.Group controlId="formPetSpecies">
                                    <Form.Label className="fw-bold">Species</Form.Label>
                                    <Form.Control type="text" value={pet.species} readOnly />
                                </Form.Group>

                                <Form.Group controlId="formPetBreed">
                                    <Form.Label className="fw-bold">Breed</Form.Label>
                                    <Form.Control type="text" value={pet.breed} readOnly />
                                </Form.Group>

                                <Form.Group controlId="formHealthStatus">
                                    <Form.Label className="fw-bold">Health Status</Form.Label>
                                    <Form.Control
                                        as="select"
                                        value={healthStatus}
                                        onChange={(e) => setHealthStatus(e.target.value)}
                                        required
                                    >
                                        <option value="Healthy">Healthy</option>
                                        <option value="Injured">Injured</option>
                                        <option value="Sick">Sick</option>
                                    </Form.Control>
                                </Form.Group>

                                <Form.Group controlId="formLocation">
                                    <Form.Label className="fw-bold">Location</Form.Label>
                                    <Form.Control
                                        type="text"
                                        value={location}
                                        onChange={(e) => setLocation(e.target.value)}
                                        required
                                    />
                                </Form.Group>

                                <Form.Group controlId="formDescription">
                                    <Form.Label className="fw-bold">Description</Form.Label>
                                    <Form.Control
                                        as="textarea"
                                        rows={3}
                                        value={description}
                                        onChange={(e) => setDescription(e.target.value)}
                                        placeholder="Add a description..."
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
                                        onChange={handleFosterChange}
                                    />
                                </Form.Group>

                                <div className="mt-4 d-flex justify-content-between">
                                    <Button variant="primary" type="submit" className="px-4 py-2" style={{ borderRadius: '5px' }}>
                                        Save
                                    </Button>
                                </div>
                            </Form>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
            {showFosterForm && (
                <Row className="justify-content-center mt-4">
                    <Col lg={6} md={8} sm={12}>
                        <Card className="shadow-lg rounded p-4">
                            <Card.Body>
                                <FosterRequestPage />
                                <div className="text-center mt-4">
                                    <Button variant="secondary" onClick={handleFosterFormClose}>
                                        Back to Pet Details
                                    </Button>
                                </div>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            )}
        </Container>
    );
};

export default PetDetails;
