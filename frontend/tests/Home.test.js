import { render, screen, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom';
import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

import Home from '../src/pages/Home';


// Clear all mocks after each test, the mocks are the fetch functions what hit the server
afterEach(() => {
    jest.clearAllMocks();
});



// test the get all topics call
test('get all topics', async () => {

    // Mocked topics
    const topics = [
        ["TWD", "The Walking Dead"],
        ["AOT", "Attack On Titan"],
    ];

    // mock the fetch call for testing
    global.fetch = jest.fn(() => {
        let promise = Promise.resolve({
            json: () => Promise.resolve(topics),
        });

        return promise;
    });

    // render the actual page
    render(
        <Router>
            <Home />
        </Router>
    );

    //const linkElement = screen.getByText(/learn react/i);
    //expect(linkElement).toBeInTheDocument();

    // check that it correctly called the right route
    expect(fetch).toHaveBeenCalledWith('http://localhost:7001/get_all_topics');

    // check that all elements are rendered to the screen
    await waitFor(() => {
        // Check that all topics are displayed
        topics.forEach((topic, index) => {
            let element0 = screen.queryByText(topic[0]);
            let element1 = screen.queryByText(topic[1]);

            // only one will actually be on the screen so check that once is there
            if (element0) {
                expect(element0).toBeInTheDocument();
            } else if (element1) {
                expect(element1).toBeInTheDocument();
            } else {
                throw new Error('No (' + topic[0] + ', ' + topic[1] + ')' + ' in the document');
            }
        });
    });
});