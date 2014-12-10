Wearable
========
Setup Instructions

1. Update android SDK tools to version 23.0.0 and greater

2. Update your SDK with Android 4.4W.2 (API 20) or higher

3. Download Google Play services, Google repository, Google support library

1. Create Wearable emulator ( either round or square ) and start it.

2. Connect your android device through usb and install android wear app on your device

3. Forward the AVD's communication port to the connected handheld device
      `adb -d forward tcp:5601 tcp:5601`
      
4. Pair emulator and device by clicking the settings option on android wear application.





