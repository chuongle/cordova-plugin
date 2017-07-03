exports.echo = function(arg0, success, error) {
    cordova.exec(success, error, "twilio", "echo", [arg0]);
};

exports.call = function(arg0, success, error) {
    cordova.exec(success, error, "twilio", "call", [arg0]);
};