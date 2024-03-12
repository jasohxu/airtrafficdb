import React, { useState } from 'react';
import { Form, Button, Container, Modal } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom'; // Import useNavigate from react-router-dom

const RemoveComponent = () => {
  const [selectedClass, setSelectedClass] = useState('');
  const [primaryKeyValue, setPrimaryKeyValue] = useState('');
  const [showConfirmModal, setShowConfirmModal] = useState(false);
  const navigate = useNavigate();

  const handleClassChange = (event) => {
    setSelectedClass(event.target.value);
    setPrimaryKeyValue('');
  };

  const handleRemove = () => {
    setShowConfirmModal(true);
  };

  const confirmRemoval = () => {
    if (!selectedClass || !primaryKeyValue) {
      console.log("Class type or primary key is missing.");
      return;
    }

    const apiEndpoint = `http://localhost:8080/api/${selectedClass.toLowerCase()}s/${primaryKeyValue}`;

    fetch(apiEndpoint, {
      method: 'DELETE',
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Deletion failed');
      }
      return response.json();
    })
    .then(() => {
      console.log(`${selectedClass} with key ${primaryKeyValue} removed successfully`);
    })
    .catch((error) => {
      console.error('Error:', error);
    })
    .finally(() => {
      setShowConfirmModal(false);
      setPrimaryKeyValue('');
    });
  };

  const handleBack = () => {
    navigate('/'); // Navigate back to the homepage
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
      <h1>Remove from Database</h1>
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
        <Button variant="danger" onClick={handleRemove}>
          Remove
        </Button>
        <Button variant="secondary" onClick={handleBack} className="ms-2">
          Back
        </Button>
      </Form>

      <Modal show={showConfirmModal} onHide={() => setShowConfirmModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>Confirm Removal</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          Are you sure you want to remove this item?
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowConfirmModal(false)}>
            Cancel
          </Button>
          <Button variant="danger" onClick={confirmRemoval}>
            Confirm Remove
          </Button>
        </Modal.Footer>
      </Modal>
    </Container>
  );
};

export default RemoveComponent;
