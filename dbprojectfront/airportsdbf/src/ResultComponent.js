import React from 'react';
import { useLocation } from 'react-router-dom';
import { Button, Container, Table } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const ResultComponent = () => {
  const location = useLocation();
  const result = location.state.results;

  const navigate = useNavigate();

  const handleBack = () => {
    navigate('/');
  };

  if (!result || typeof result !== 'object' || Array.isArray(result)) {
    console.error('Result is not an object:', result);
    return <div className="mt-4">Invalid result</div>;
  }

  return (
    <Container className="mt-4">
      <Table striped bordered hover>
        <thead>
        </thead>
        <tbody>
          {Object.entries(result).map(([key, value], index) => (
            <tr key={index}>
              <td>{key}</td>
              <td>{value}</td>
            </tr>
          ))}
        </tbody>
        <Button variant="secondary" onClick={handleBack} className="ms-2">
          Back
        </Button>
      </Table>
    </Container>
  );
};

export default ResultComponent;
