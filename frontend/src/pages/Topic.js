import React, { useState } from "react";
import { useParams } from 'react-router-dom';

// styling
import './Topic.css';

function Topic() {
    const { topicID } = useParams();

    return (
        <div id="mainDiv">
            <p>TOPIC: {topicID}</p>
        </div>
    );
}


export default Topic;