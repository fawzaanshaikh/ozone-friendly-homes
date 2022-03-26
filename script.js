function calculateArea() {
    let height = parseInt(document.getElementById("height").value);
    let width = parseInt(document.getElementById("width").value);

    let area = height * width;

    document.getElementById("output").innerHTML = "Area available to do vertical gardening on one side is: " + area;
}