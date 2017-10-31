var status = false;

function startTraining(UUID, gesture_id, user_id, device_id) {
    status=true;


    var url = "//"+window.location.host+"/startTraining";
    var method = "POST";
    var postData = new Object();
    postData.SessionID = UUID;
    postData.gesture_id = gesture_id;
    postData.user_id = user_id;
    postData.device_id = device_id;
    var jsonString= JSON.stringify(postData);

// You REALLY want async = true.
// Otherwise, it'll block ALL execution waiting for server response.
    var async = true;

    var request = new XMLHttpRequest();

// Before we send anything, we first have to say what we will do when the
// server responds. This seems backwards (say how we'll respond before we send
// the request? huh?), but that's how Javascript works.
// This function attached to the XMLHttpRequest "onload" property specifies how
// the HTTP response will be handled.
    request.onload = function () {


        // Because of javascript's fabulous closure concept, the XMLHttpRequest "request"
        // object declared above is available in this function even though this function
        // executes long after the request is sent and long after this function is
        // instantiated. This fact is CRUCIAL to the workings of XHR in ordinary
        // applications.

        // You can get all kinds of information about the HTTP response.
        var status = request.status; // HTTP response status, e.g., 200 for "200 OK"
        var data = request.responseText; // Returned data, e.g., an HTML document.

        if (status==200) {
            document.getElementById("spinner").setAttribute("class", "fa  fa-spinner fa-spin");
            document.getElementById("startstop").setAttribute("class","btn btn-danger btn-lg btn-block");
        }
        else {
            alert("Something went wrong: "+status);
        }

    };

    request.open(method, url, async);

    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
// Or... request.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
// Or... whatever

// Actually sends the request to the server.
    request.send(jsonString);

}

function setToLastSession(list) {
    alert("Seeting");
}

function stopTraining() {
    status = false;
    open("//"+window.location.host+"/stopTraining", "_self");
    document.getElementById("startstop").setAttribute("class","btn btn-success btn-lg btn-block");
    document.getElementById("spinner").setAttribute("class", "fa");


}

function keypress() {

    if (status=="true") {
        stopTraining();
    } else {
        var user_id= document.getElementById("InputUser").options[document.getElementById("InputUser").selectedIndex].id;
        var gesture_id= document.getElementById("InputGesture").options[document.getElementById("InputGesture").selectedIndex].id;
        var device_id= document.getElementById("InputDevice").options[document.getElementById("InputDevice").selectedIndex].id;
        startTraining(document.getElementById("InputUUID").value,gesture_id , user_id, device_id );
    }
}



window.onkeydown = function (e) {
    var code = e.keyCode ? e.keyCode : e.which;
    if (code === 13 || code ===32) { //up key
        keypress();
    }
};


function deleteTD(UUID) {
    open("//"+window.location.host+"/deleteTrainingData/"+UUID, "_self");
}
