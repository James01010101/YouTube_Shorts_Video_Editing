import React, { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';

// styling
import './Home.css';

function Home() {

    // make the list that i can scroll through with all my elements
    const TopicsScrollableList = ({ items, onItemClick }) => {
        // show the full text for the topic unless it is too large and then just show the acrnym
        return (
            <div className="topics-scrollable-list">
                {items.map((item, index) => (
                    <div key={index} className="scrollable-list-item" onClick={() => onItemClick(item)}>
                        {item[1].length < 17 ? item[1] : item[0]}
                    </div>
                ))}
            </div>
        );
    }


    // call the backend to get all of the topics
    const [topics, setTopics] = useState([]);
    // this is a function that will run once when the page loads ad every time it reloads
    useEffect(() => {
        console.log("Getting all topic titles")
        fetch('http://localhost:7001/get_all_topics')
            .then(response => response.json())
            .then(data => {
                console.log("Data received: ", data);
                setTopics(data);
            })
            .catch(error => {
                console.error('Error fetching all topic titles data:', error);
            }
        );
    }, []); // the empty array means this function will only run once
    

    // TODO: #6 When clicking on an item go to its topics page
    const navigate = useNavigate();
    const handleItemClick = (item) => {
        console.log('Item clicked:', item[1]);

        navigate('/topic/' + item[1]);
    };


    return (
        <div id="mainDiv">
            <h1 id="topicTitle">TOPICS</h1>
            <TopicsScrollableList id="topicsList" items={topics} onItemClick={handleItemClick} />
        </div>
    );
}


export default Home;