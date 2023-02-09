function onFormSubmit(e) {
    event.preventDefault();
    var formData = readFormData();
    console.log(formData)
}

function readFormData() {
    var formData = {};
    formData["trainingTopic"] = document.getElementById("trainingTopic").value;
    formData["date"] = document.getElementById("date").value;
    formData["userId"] = document.getElementById("userId").value;
    formData["_csrf"] = document.getElementById("_csrf").value;
    return formData;
}