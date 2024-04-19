import React, { useState } from "react"; 
import './App.css';

function App() {

    const [age, setAge] = useState(0);
    const getAge = () => {
        console.log("Getting person data")
        fetch('http://localhost:7001/get_name')
            .then(response => response.json())
            .then(data => {
                console.log("Data received: ", data);
                setAge(data["Age"]);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    };

    return (
        <div id="mainDiv">
            <h1>Click to get age</h1>
            <button onClick={getAge}>Get Age</button>
            <p id="ageText">Your age is: {age}</p>
        </div>
    );
}

export default App;
