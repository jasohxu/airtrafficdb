import React, { useState } from 'react';
import { Form, Button, Alert } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const InsertComponent = () => {
  const [selectedClass, setSelectedClass] = useState('');
  const [formData, setFormData] = useState({});
  const [error, setError] = useState('');
  const classOptions = ['Airline', 'Airport', 'Passenger', 'Flight', 'Ticket'];
  const navigate = useNavigate();

  const handleBack = () => {
    navigate('/'); // Navigate to the homepage
  };

  const handleClassChange = (e) => {
    setSelectedClass(e.target.value);
    setFormData({}); // Reset form data when class changes
    setError(''); // Reset error message
  };

  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const requiredFieldsFilled = Object.values(formData).every((value) => value.trim() !== '');
    if (!requiredFieldsFilled) {
      setError('Please fill out all fields.');
      return;
    }
  
    // Define the API endpoint based on the selected class
    let apiEndpoint;
    switch (selectedClass) {
      case 'Airline':
        apiEndpoint = 'http://localhost:8080/api/airlines';
        break;
      case 'Airport':
        apiEndpoint = 'http://localhost:8080/api/airports';
        break;
      case 'Passenger':
        apiEndpoint = 'http://localhost:8080/api/passengers';
        break;
      case 'Flight':
        apiEndpoint = 'http://localhost:8080/api/flights';
        break;
      case 'Ticket':
        apiEndpoint = 'http://localhost:8080/api/tickets';
        break;
      default:
        setError('Invalid class selected.');
        return;
    }
  
    // Send POST request to the backend
    fetch(apiEndpoint, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formData),
    })
    .then(response => {
      if (!response.ok) {
        throw new Error(response.statusText);
      }
      return response.json();
    })
    .then(data => {
      console.log('Success:', data);
      // Handle success
    })
    .catch((error) => {
      console.error('Error:', error);
      setError('An error occurred while submitting the form. It might be a duplicate entry.');
    });
  };

const renderInputField = (name, type, placeholder) => {
  return (
    <Form.Control 
      type={type} 
      name={name} 
      placeholder={placeholder} 
      className="mb-2" 
      value={formData[name] || ''} 
      onChange={handleInputChange} 
    />
  );
};

const renderInputFields = () => {
    switch (selectedClass) {
      case 'Airline':
        return (
          <>
            {renderInputField('abbreviation', 'text', 'Airline Abbreviation')}
            {renderInputField('fullName', 'text', 'Full Name')}
          </>
        );
      case 'Airport':
        return (
          <>
            {renderInputField('abbreviation', 'text', 'Airport Abbreviation')}
            {renderInputField('fullName', 'text', 'Full Name')}
            {renderInputField('city', 'text', 'City')}
          </>
        );
      case 'Passenger':
        return (
          <>
            {renderInputField('passengerID', 'number', 'Passenger ID')}
            {renderInputField('name', 'text', 'Name')}
            {renderInputField('dateOfBirth', 'date', 'Date of Birth')}
          </>
        );
      case 'Flight':
        return (
          <>
            {renderInputField('flightNumber', 'number', 'Flight Number')}
            {renderInputField('airline', 'text', 'Airline Abbreviation')}
            {renderInputField('origin', 'text', 'Origin Airport Abbreviation')}
            {renderInputField('destination', 'text', 'Destination Airport Abbreviation')}
            {renderInputField('departureTime', 'time', 'Departure Time')}
            {renderInputField('arrivalTime', 'time', 'Arrival Time')}
          </>
        );
      case 'Ticket':
        return (
          <>
            {renderInputField('ticketID', 'number', 'Ticket ID')}
            {renderInputField('passengerID', 'number', 'Passenger ID')}
            {renderInputField('flightNumber', 'number', 'Flight Number')}
            {renderInputField('flightDate', 'date', 'Flight Date')}
          </>
        );
      default:
        return <div>Select a class to add</div>;
    }
  };

return (
  <div>
    <h2>Insert Data</h2>
    <Form onSubmit={handleSubmit}>
      <Form.Group>
        <Form.Label>Select Class Type</Form.Label>
        <Form.Control as="select" value={selectedClass} onChange={handleClassChange}>
          <option value="">Select...</option>
          {classOptions.map((option, index) => (
            <option key={index} value={option}>
              {option}
            </option>
          ))}
        </Form.Control>
      </Form.Group>
      {renderInputFields()}
      <Button variant="success" type="submit">
        Insert
      </Button>
      <Button variant="secondary" onClick={handleBack} className="ms-2">
        Back
      </Button>
      {error && <Alert variant="danger" className="mt-3">{error}</Alert>}
    </Form>
  </div>
);
};

export default InsertComponent;