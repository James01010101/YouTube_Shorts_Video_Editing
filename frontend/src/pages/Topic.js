import React, { useState } from "react";
import { useParams, useNavigate } from 'react-router-dom';

// styling
import './Topic.css';

function Topic() {
    // this allows me to traverse through the pages of my site
    const navigate = useNavigate();

    const { topicID } = useParams();



    // when i click my buttons
    // TODO: #11 connect the continue and new buttons to the Edit page
    function clickedContinue() {
        console.log("Continue button clicked");

        // fetch the most recent video number to continue working on
    }

    function clickedNew() {
        console.log("New button clicked");
        
        // start a new video to work on with number n+1
    }

    // TODO: #9 add a textbox for the manual topic button
    function clickedManual() {
        console.log("Manual button clicked");

        // allow the user to input a video number to work on
    }


    return (
        <div id="mainDiv">
            <p id="topic">TOPIC: {topicID}</p>

            {/* 3 buttons */}
            <button className="topicButton" id="continueButton" onClick={clickedContinue}>Continue</button>
            <button className="topicButton" id="newButton" onClick={clickedNew}>New</button>
            <button className="topicButton" id="manualButton" onClick={clickedManual}>Manual</button>

        </div>
    );
}


export default Topic;