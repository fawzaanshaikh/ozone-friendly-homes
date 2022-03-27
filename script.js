function calculateArea() {
    let height = parseInt(document.getElementById("height").value);
    let width = parseInt(document.getElementById("width").value);

    let area = height * width;

    document.getElementById("output").innerHTML = "Area available to do vertical gardening on one side is: " + area;

    // To get the location of the user once the button is tapped or clicked
    getLocation();
}

var div  = document.getElementById("location");
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else {
        div.innerHTML = "The Browser Does not Support Geolocation";
    }
}

function showPosition(position) {
    div.innerHTML = "The current coordinates are:<br>" + "Latitude: " + position.coords.latitude + "<br>Longitude: " + position.coords.longitude;
}

function showError(error) {
    if(error.PERMISSION_DENIED) {
        div.innerHTML = "The user has denied the request for Geolocation.";
    }
}