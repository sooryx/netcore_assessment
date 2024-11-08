import UIKit
import Flutter
import SmartechBase
import SmartechPush
import SmartechAppInbox

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
    Smartech.sharedInstance().initialize(withAppId: "YOUR_SMARTECH_APP_ID_HERE", inApplication: application)

    SmartechPush.sharedInstance().initialize(withAppId: "YOUR_SMARTECH_APP_ID_HERE")
    SmartechAppInbox.sharedInstance().initialize(withAppId: "YOUR_SMARTECH_APP_ID_HERE")

    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
}
