import React, { useState } from 'react';
import { Form, Button, Container, Card, Row, Col, Alert } from 'react-bootstrap';

const FosterRequestPage = () => {
  // State hooks to store form values and validation errors
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [notes, setNotes] = useState('');
  const [petId, setPetId] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Basic validation: Check if all fields are filled and start date is before end date
    if (!startDate || !endDate || !petId) {
      setError('Please fill out all required fields.');
      setSuccess(false);
      return;
    }

    if (new Date(startDate) > new Date(endDate)) {
      setError('Start date must be before end date.');
      setSuccess(false);
      return;
    }

    // If validation passes
    setError('');
    setSuccess(true);
    console.log('Foster Request Submitted:', { startDate, endDate, notes, petId });
    alert('Foster request submitted successfully!');
  };

  // Handle form reset
  const handleClear = () => {
    setStartDate('');
    setEndDate('');
    setNotes('');
    setPetId('');
    setError('');
    setSuccess(false);
  };

  return (
    <Container className="mt-5">
      <Row className="justify-content-center">
        <Col lg={6} md={8} sm={12}>
          <Card className="shadow-lg rounded p-4">
            <Card.Body>
              <h2 className="text-center mb-4" style={{ color: '#2c3e50' }}>
                Foster Request Form
              </h2>
              
              {error && <Alert variant="danger">{error}</Alert>}
              {success && <Alert variant="success">Form submitted successfully!</Alert>}

              <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formStartDate">
                  <Form.Label className="fw-bold">Start Date</Form.Label>
                  <Form.Control
                    type="date"
                    value={startDate}
                    onChange={(e) => setStartDate(e.target.value)}
                    isInvalid={!startDate}
                    required
                  />
                  <Form.Control.Feedback type="invalid">
                    Please select a start date.
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group controlId="formEndDate">
                  <Form.Label className="fw-bold">End Date</Form.Label>
                  <Form.Control
                    type="date"
                    value={endDate}
                    onChange={(e) => setEndDate(e.target.value)}
                    isInvalid={!endDate}
                    required
                  />
                  <Form.Control.Feedback type="invalid">
                    Please select an end date.
                  </Form.Control.Feedback>
                </Form.Group>

                <Form.Group controlId="formNotes">
                  <Form.Label className="fw-bold">Notes</Form.Label>
                  <Form.Control
                    as="textarea"
                    rows={3}
                    value={notes}
                    onChange={(e) => setNotes(e.target.value)}
                    placeholder="Add any special requests or details..."
                  />
                </Form.Group>

                <Form.Group controlId="formPetId">
                  <Form.Label className="fw-bold">Pet ID</Form.Label>
                  <Form.Control
                    type="text"
                    value={petId}
                    onChange={(e) => setPetId(e.target.value)}
                    isInvalid={!petId}
                    required
                    placeholder="Enter Pet ID"
                  />
                  <Form.Control.Feedback type="invalid">
                    Please enter a pet ID.
                  </Form.Control.Feedback>
                </Form.Group>

                <div className="mt-4 d-flex justify-content-between">
                  <Button
                    variant="success"
                    type="submit"
                    className="px-4 py-2"
                    style={{ borderRadius: '5px' }}
                  >
                    Submit
                  </Button>
                  <Button
                    variant="danger"
                    onClick={handleClear}
                    className="px-4 py-2"
                    style={{ borderRadius: '5px' }}
                  >
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

export default FosterRequestPage;
