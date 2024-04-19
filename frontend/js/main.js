


// add a listener to the button that will fetch data from the server
document.getElementById('fetchDataButton').addEventListener('click', function() {
    fetch('http://localhost:7001/get_name')
        .then(response => response.json())
        .then(data => {
            document.getElementById('dataDisplayText').textContent = JSON.stringify(data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            document.getElementById('dataDisplay').textContent = 'Failed to fetch data.';
        });
});


// add a listener to the button that will fetch age data from the server
document.getElementById('ageButton').addEventListener('click', function() {
    fetch('http://localhost:7001/get_name')
        .then(response => response.json())
        .then(data => {
            let age = data["Age"];
            document.getElementById('ageText').textContent = age;
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            document.getElementById('ageText').textContent = 'Failed to fetch age data.';
        });

});