import React, { useContext, useEffect, useState } from 'react';
import { Form, Button, Container, Card, Row, Col, Alert } from 'react-bootstrap';
import axios from 'axios'; // Import axios
import { UserContext } from '../App';
import { useLocation, useParams } from 'react-router-dom';
import toast from 'react-hot-toast';

const FosterRequestPage = () => {

  
  // const { state } = useLocation(); // This will get the state passed from the previous page
  // const pet = state?.pet; // Extract the pet object

  const Id = useParams()
  const petId = Id.id;
  console.log(petId);

  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [notes, setNotes] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);
  const [ pet, setPet ] = useState()

  const { userAuth,userAuth: { jsonToken } } = useContext(UserContext);

  const handleSubmit = async (e) => {

    e.preventDefault();
    console.log(startDate + ' '+ endDate);
    if (!startDate || !endDate) {
      setError('Please fill out all required fields.');
      setSuccess(false);
      return;
    }

    if (new Date(startDate) > new Date(endDate)) {
      setError('Start date must be before end date.');
      setSuccess(false);
      return;
    }

    setError('');
    setSuccess(true);

    const date = new Date().toISOString();

    const formData = {
      petId: petId, // Include pet ID in the request
      startDate: startDate,
      endDate: endDate,
      notes: notes,
      userId: userAuth.id,
      requestDate: date
    };

    // console.log(fosterRequestDTO);
    
   
    // Axios POST request to the backend
    try {
      const response = await axios.post(`http://localhost:9000/foster-request/${userAuth.id}/${petId}`, formData, {
        headers: {
          'Authorization': `Bearer ${jsonToken}`,
          'Content-Type': 'application/json', // Ensure the correct content type
        },
      });
      console.log('Foster Request Submitted:', response.data);
      alert('Foster request submitted successfully!');

    } catch (error) {
      console.error('Error submitting foster request:', error);
      setError('There was an error submitting your request. Please try again.');
      setSuccess(false);
    }
  };

  useEffect(()=>{
    try{
      axios.get(`http://localhost:9000/pets/${petId}`, {
        headers:{
          'Authorization': `Bearer ${jsonToken}`
        }
      })
      .then((response)=>{
        setPet(response.data)
      })
      .catch(()=>{
        toast.error("pet not found")
      })
    }catch{

    }
  },[])

  const handleClear = () => {
    setStartDate('');
    setEndDate('');
    setNotes('');
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
                Foster Request Form for {pet ? pet.name : 'Pet'}
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

                {/* Display pet ID without input */}
                <Form.Group controlId="formPetId">
                  <Form.Label className="fw-bold">Pet ID</Form.Label>
                  <Form.Control
                    type="text"
                    value={petId ? petId : ''}
                    readOnly
                    disabled
                  />
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
