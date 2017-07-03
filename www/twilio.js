exports.echo = function(arg0, success, error) {
    cordova.exec(success, error, "Twilio", "echo", [arg0]);
};

exports.call = function(arg0, success, error) {
    cordova.exec(success, error, "Twilio", "call", [arg0]);
};