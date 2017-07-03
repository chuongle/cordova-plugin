@objc(Twilio) class Twilio : CDVPlugin {
  @objc(echo:)
  func echo(command: CDVInvokedUrlCommand) {
    var pluginResult = CDVPluginResult(
      status: CDVCommandStatus_ERROR
    )

    let msg = command.arguments[0] as? String ?? ""

    if msg.characters.count > 0 {
      pluginResult = CDVPluginResult(
        status: CDVCommandStatus_OK,
        messageAs: msg
      )
    }

    self.commandDelegate!.send(
      pluginResult,
      callbackId: command.callbackId
    )
  }
  @objc(call:)
  func call(command: CDVInvokedUrlCommand) {
    var pluginResult = CDVPluginResult(
        status: CDVCommandStatus_ERROR
    )
    
    let phone = command.arguments[0] as? String ?? ""

    if phone.characters.count > 0 {
        UIApplication.shared.open(URL(string: "tel://" + phone)!, options: [:], completionHandler: nil)
        pluginResult = CDVPluginResult(
            status: CDVCommandStatus_OK,
            messageAs: "phone call successfully"
        )
    }
    
    self.commandDelegate!.send(
        pluginResult,
        callbackId: command.callbackId
    )
  }
}
