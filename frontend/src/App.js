import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';

// styling
import './App.css';

// import my pages
import Home from './pages/Home';
import Topic from './pages/Topic';


function App() {
    // basic template for the different pages
    return (
        <Router>
          <div>
            <nav>
              <ul>
                <li>
                  <Link to="/">Home</Link>  // Creates a link to the home page
                </li>
                <li>
                  <Link to="/topic">Topic</Link>  // Creates a link to the topic page
                </li>
              </ul>
            </nav>
    
            {/* A <Switch> looks through its children <Route>s and
                renders the first one that matches the current URL. */}
            <Routes>
                <Route path="/topic" element={<Topic />} />
                <Route path="/" element={<Home />} />
            </Routes>
          </div>
        </Router>
    );
}

export default App;
