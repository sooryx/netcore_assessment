
# Netcore smart tech SDK Integration for Android & iOS

# Android SDK Integration

## 1.Adding Dependencies in pubspec.yaml

To integrate the required SDK, I referred to articles that outlined the necessary dependencies. I added the following to my pubspec.yaml file:

dependencies:

    smartech_base: ^3.5.0
    smartech_push: ^3.5.0
    smartech_appinbox: ^3.5.0


## 2. Configuring the android/build.gradle File
Following guidance from integration resources, I modified the android/build.gradle file to add repositories needed for the SDK. This included adding Netcore's Maven repository, along with Google’s and MavenCentral:
```plaintext
allprojects {
    repositories {
        maven { url 'https://artifacts.netcore.co.in/artifactory/android' }
        maven { url 'https://dl.google.com/dl/android/maven2' }
        mavenCentral()
    }
}
```
## 3. Setting Dependencies in android/app/build.gradle
In android/app/build.gradle, I ensured that dependencies matched the SDK versions I’m using:

-Set the SDK version to match the version of the SDK you're using:
```plaintext
dependencies {
    implementation 'com.netcore.android:smartech-appinbox:3.5.3'
    implementation 'com.netcore.android:smartech-push:3.5.2'
}
```

##4. Adding Permissions in AndroidManifest.xml
Based on recommended configurations, I included necessary permissions for the app to support push notifications and other SDK features:
```plaintext
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.VIBRATE"/>
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
<uses-permission android:name="com.android.alarm.permission.SET_ALARM"/>
```
## 5  Initializing the SDK
In MainActivity.java or MainActivity.kt, I initialized the SDK within the onCreate method. Referring to setup resources, I incorporated the initialization as follows:
```plaintext
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    // Initialize SDK
    Smartech.getInstance().initialize(getApplicationContext(), "YOUR_SDK_KEY");
}
```


# IOS SDK Integration

## 1.Updating the iOS Podfile
To include the SDK dependencies for iOS, I referred to integration steps and updated the ios/Podfile:
```plaintext
platform :ios, '10.0'

target 'Runner' do
  use_frameworks!
  pod 'SmartechAppinbox', '~> 3.5.3'
  pod 'SmartechPush', '~> 3.5.2'
end
```
## 2. Adding Configuration in Info.plist
Based on iOS setup documentation, I updated Info.plist to include configurations for push notifications and other app settings:
```plaintext
<key>NSAppTransportSecurity</key>
<dict>
    <key>NSAllowsArbitraryLoads</key>
    <true/>
</dict>

```

## 3. SDK Initialization in AppDelegate.swift
In AppDelegate.swift, I implemented the SDK initialization within didFinishLaunchingWithOptions, following integration guides:

```plaintext
import UIKit
import Flutter
import SmartechAppinbox
import SmartechPush

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
    Smartech.initializeSdk(application: application, launchOptions: launchOptions)
    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
}

```

## 4. Configuring Push Notifications (Optional)
For apps requiring push notifications, I used article references to request notification permissions as follows:

```plaintext

UNUserNotificationCenter.current().requestAuthorization(options: [.alert, .badge, .sound]) { granted, error in
  if granted {
    DispatchQueue.main.async {
      UIApplication.shared.registerForRemoteNotifications()
    }
  }
}

```





