import React, { useState } from 'react';
import { Form, Button, Container } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const SearchComponent = () => {
  const navigate = useNavigate();
  const [selectedClass, setSelectedClass] = useState('');
  const [primaryKeyValue, setPrimaryKeyValue] = useState('');
  const [, setResults] = useState([]);

  const handleBack = () => {
    navigate('/'); // Navigate to the homepage
  };

  const handleClassChange = (event) => {
    setSelectedClass(event.target.value);
    setPrimaryKeyValue('');
  };

  const handleSearch = () => {

    if (!primaryKeyValue) {
      alert('Please enter a search query');
      return;
    }

    const apiEndpoint = `/api/${selectedClass.toLowerCase()}s/${primaryKeyValue}`;
    
    fetch(apiEndpoint)
      .then(response => response.json())
      .then(data => {
        setResults(data);
        navigate('/results', { state: { results: data } });
      })
      .catch(error => {
        console.error('Error:', error);
      });
  };

  const renderInputField = () => {
    switch (selectedClass) {
      case 'Airline':
        return renderPrimaryKeyInput('Airline Abbreviation');
      case 'Airport':
        return renderPrimaryKeyInput('Airport Abbreviation');
      case 'Passenger':
        return renderPrimaryKeyInput('Passenger ID', 'number');
      case 'Flight':
        return renderPrimaryKeyInput('Flight Number', 'number');
      case 'Ticket':
        return renderPrimaryKeyInput('Ticket ID', 'number');
      default:
        return null;
    }
  };

  const renderPrimaryKeyInput = (label, type = 'text') => (
    <Form.Group className="mb-3" controlId="primaryKey">
      <Form.Label>{label}</Form.Label>
      <Form.Control 
        type={type} 
        value={primaryKeyValue}
        onChange={(e) => setPrimaryKeyValue(e.target.value)} 
      />
    </Form.Group>
  );

  return (
    <Container>
      <h1>Search in Database</h1>
      <Form>
        <Form.Group className="mb-3" controlId="classSelect">
          <Form.Label>Select Class</Form.Label>
          <Form.Select aria-label="Select class" onChange={handleClassChange}>
            <option value="">Select a class...</option>
            <option value="Airline">Airline</option>
            <option value="Airport">Airport</option>
            <option value="Passenger">Passenger</option>
            <option value="Flight">Flight</option>
            <option value="Ticket">Ticket</option>
          </Form.Select>
        </Form.Group>
        {renderInputField()}
        <Button variant="primary" onClick={handleSearch}>
          Search
        </Button>
        <Button variant="secondary" onClick={handleBack} className="ms-2">
          Back
        </Button>
      </Form>
    </Container>
  );
};

export default SearchComponent;
