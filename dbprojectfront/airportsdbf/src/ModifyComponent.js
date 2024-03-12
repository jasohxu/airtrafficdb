import React, { useState } from 'react';
import { Form, Button, Alert, Container } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const ModifyComponent = () => {
  const [selectedClass, setSelectedClass] = useState('');
  const [primaryKeyValue, setPrimaryKeyValue] = useState('');
  const [itemData, setItemData] = useState(null);
  const [error, setError] = useState('');

  const navigate = useNavigate();

  const handleBack = () => {
    navigate('/');
  };

  const handleClassChange = (event) => {
    setSelectedClass(event.target.value);
    setPrimaryKeyValue('');
    setItemData(null);
    setError('');
  };

  const handleSearch = () => {
    if (!primaryKeyValue) {
      setError('Please enter a primary key value.');
      return;
    }
  
    // Assuming the API endpoint follows a similar structure
    const apiEndpoint = `/api/${selectedClass.toLowerCase()}s/${primaryKeyValue}`;
  
    fetch(apiEndpoint)
      .then(response => {
        if (!response.ok) {
          throw new Error('Item not found');
        }
        return response.json();
      })
      .then(data => {
        setItemData(data);
        setError(''); // Clear any previous error
      })
      .catch(error => {
        console.error('Error:', error);
        setItemData(null); // Clear any previous data
        setError('Item not found. Please check the input and try again.');
      });
  };

  const handleInputChange = (event) => {
    setItemData({ ...itemData, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Assuming `abbreviation` is the primary key
    const updateEndpoint = `http://localhost:8080/api/${selectedClass.toLowerCase()}s/${primaryKeyValue}`;
  
    fetch(updateEndpoint, { 
      method: 'PUT', 
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(itemData) 
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Update failed');
      }
      return response.json();
    })
    .then(data => {
      alert('Update successful');
    })
    .catch(error => {
      console.error('Error:', error);
      alert('An error occurred while updating');
    });
  };

  const renderInputFields = () => {
    if (!itemData) return null;
  
    switch (selectedClass) {
      case 'Airline':
        return (
          <>
            <Form.Group className="mb-3">
              <Form.Label>Airline Abbreviation</Form.Label>
              <Form.Control readOnly type="text" name="abbreviation" value={itemData.abbreviation || ''} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Full Name</Form.Label>
              <Form.Control type="text" name="fullName" value={itemData.fullName || ''} onChange={handleInputChange} />
            </Form.Group>
          </>
        );
      case 'Airport':
        return (
          <>
            <Form.Group className="mb-3">
              <Form.Label>Airport Abbreviation</Form.Label>
              <Form.Control readOnly type="text" name="abbreviation" value={itemData.abbreviation || ''} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Full Name</Form.Label>
              <Form.Control type="text" name="fullName" value={itemData.fullName || ''} onChange={handleInputChange} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>City</Form.Label>
              <Form.Control type="text" name="city" value={itemData.city || ''} onChange={handleInputChange} />
            </Form.Group>
          </>
        );
      case 'Passenger':
        return (
          <>
            <Form.Group className="mb-3">
              <Form.Label>Passenger ID</Form.Label>
              <Form.Control readOnly type="number" name="passengerID" value={itemData.passengerID || ''} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Name</Form.Label>
              <Form.Control type="text" name="name" value={itemData.name || ''} onChange={handleInputChange} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Date of Birth</Form.Label>
              <Form.Control type="date" name="dateOfBirth" value={itemData.dateOfBirth || ''} onChange={handleInputChange} />
            </Form.Group>
          </>
        )
        case 'Flight':
            return (
              <>
                <Form.Group className="mb-3">
                  <Form.Label>Flight Number</Form.Label>
                  <Form.Control readOnly type="number" name="flightNumber" value={itemData.flightNumber || ''} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Airline Abbreviation</Form.Label>
                  <Form.Control type="text" name="airline" value={itemData.airline || ''} onChange={handleInputChange} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Origin Airport Abbreviation</Form.Label>
                  <Form.Control type="text" name="origin" value={itemData.origin || ''} onChange={handleInputChange} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Destination Airport Abbreviation</Form.Label>
                  <Form.Control type="text" name="destination" value={itemData.destination || ''} onChange={handleInputChange} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Departure Time</Form.Label>
                  <Form.Control type="time" name="departureTime" value={itemData.departureTime || ''} onChange={handleInputChange} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Arrival Time</Form.Label>
                  <Form.Control type="time" name="arrivalTime" value={itemData.arrivalTime || ''} onChange={handleInputChange} />
                </Form.Group>
              </>
            );
          case 'Ticket':
            return (
              <>
                <Form.Group className="mb-3">
                  <Form.Label>Ticket ID</Form.Label>
                  <Form.Control readOnly type="number" name="ticketID" value={itemData.ticketID || ''} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Passenger ID</Form.Label>
                  <Form.Control type="number" name="passengerID" value={itemData.passengerID || ''} onChange={handleInputChange} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Flight Number</Form.Label>
                  <Form.Control type="number" name="flightNumber" value={itemData.flightNumber || ''} onChange={handleInputChange} />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>Flight Date</Form.Label>
                  <Form.Control type="date" name="flightDate" value={itemData.flightDate || ''} onChange={handleInputChange} />
                </Form.Group>
              </>
            );
          default:
            return null;
        }
  };

  const renderPrimaryKeyField = () => {
    if (!itemData || !primaryKeyValue) return null;

    let label;
    switch (selectedClass) {
      case 'Airline':
        label = 'Airline Abbreviation';
        break;
      case 'Airport':
        label = 'Airport Abbreviation';
        break;
      case 'Passenger':
        label = 'Passenger ID';
        break;
      case 'Flight':
        label = 'Flight Number';
        break;
      case 'Ticket':
        label = 'Ticket ID';
        break;
      default:
        return null;
    }
    return (
      <Form.Group className="mb-3">
        <Form.Label>{label}</Form.Label>
        <Form.Control readOnly type="text" value={primaryKeyValue} disabled />
      </Form.Group>
    );
  };

  const renderPrimaryKeyInput = () => {
    let label, type;
    switch (selectedClass) {
      case 'Airline':
        label = 'Airline Abbreviation';
        type = 'text';
        break;
      case 'Airport':
        label = 'Airport Abbreviation';
        type = 'text';
        break;
      case 'Passenger':
        label = 'Passenger ID';
        type = 'number';
        break;
      case 'Flight':
        label = 'Flight Number';
        type = 'number';
        break;
      case 'Ticket':
        label = 'Ticket ID';
        type = 'number';
        break;
      default:
        return null;
    }
    return (
      <Form.Group className="mb-3" controlId="primaryKey">
        <Form.Label>{label}</Form.Label>
        <Form.Control 
          type={type} 
          value={primaryKeyValue}
          onChange={(e) => setPrimaryKeyValue(e.target.value)} 
        />
      </Form.Group>
    );
  };

  if (error) {
    return (
      <Container>
        <Alert variant="danger">{error}</Alert>
        <Button onClick={() => setError('')}>Back to Search</Button>
      </Container>
    );
  }

  return (
    <Container>
      <h1>Modify Data</h1>
      <Form>
        <Form.Group className="mb-3" controlId="classSelect">
          <Form.Label>Select Class</Form.Label>
          <Form.Select aria-label="Select class" value={selectedClass} onChange={handleClassChange}>
            <option value="">Select a class...</option>
            <option value="Airline">Airline</option>
            <option value="Airport">Airport</option>
            <option value="Passenger">Passenger</option>
            <option value="Flight">Flight</option>
            <option value="Ticket">Ticket</option>
          </Form.Select>
        </Form.Group>
        {renderPrimaryKeyInput()}
        <Button variant="primary" onClick={handleSearch}>Search</Button>
        <Button variant="secondary" onClick={handleBack} className="ms-2">
          Back
        </Button>
      </Form>
      {itemData && (
        <>
          {renderPrimaryKeyField()}
          <Form onSubmit={handleSubmit}>
            {renderInputFields()}
            <Button variant="success" type="submit">Submit Changes</Button>
          </Form>
        </>
      )}
      {error && <Alert variant="danger">{error}</Alert>}
    </Container>
  );
};

export default ModifyComponent;
