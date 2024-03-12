import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import SearchComponent from './SearchComponent';
import InsertComponent from './InsertComponent';
import RemoveComponent from './RemoveComponent';
import ModifyComponent from './ModifyComponent';
import ResultComponent from './ResultComponent';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'react-bootstrap';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/search" element={<SearchComponent />} />
        <Route path="/insert" element={<InsertComponent />} />
        <Route path="/remove" element={<RemoveComponent />} />
        <Route path="/modify" element={<ModifyComponent />} />
        <Route path="/results" element={<ResultComponent />} />
      </Routes>
    </Router>
  );
}

const Home = () => (
  <div className="text-center mt-5">
    <h1>Airplane Log</h1>
    <div className="mt-4">
        <Link to="/search"><Button variant="primary" className="m-2">Search</Button></Link>
        <Link to="/insert"><Button variant="success" className="m-2">Insert</Button></Link>
        <Link to="/remove"><Button variant="danger" className="m-2">Remove</Button></Link>
        <Link to="/modify"><Button variant="warning" className="m-2">Modify</Button></Link>
    </div>
  </div>
);

export default App;