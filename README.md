# Konotor PhoneGap/Cordova Plugin
### Platform Support

This plugin supports PhoneGap/Cordova apps with version 3.0.0 and above running on iOS and Android.

## Installation
#### Automatic Installation using PhoneGap/Cordova CLI (for iOS and Android)

1 a) Install this plugin using PhoneGap/Cordova CLI:

Cordova 5 and above

     cordova plugin add cordova-plugin-konotor --variable APP_ID="YOUR_APP_ID" --variable APP_KEY="YOUR_APP_KEY"

Others

        phonegap plugin add https://github.com/konotor/phonegap-sdk.git --variable APP_ID="YOUR_APP_ID" --variable APP_KEY="YOUR_APP_KEY"

                                    or

        cordova plugin add  https://github.com/konotor/phonegap-sdk.git --variable APP_ID="YOUR_APP_ID" --variable APP_KEY="YOUR_APP_KEY"

(Note that the Phonegap CLI didn't support --variable before version 3.6.3, so please use the Cordova CLI as shown above in case you're on an older version)

1 b) Alternately, configure for phonegap build in config.xml

    <gap:plugin name="cordova-plugin-konotor" source="npm" version="1.0.0">
        <param name="APP_ID" value="YOUR_APP_ID"/>
        <param name="APP_KEY" value="YOUR_APP_KEY"/>
    </gap:plugin>

2. Add this script tag to your index.html:

        <input id="talkToUs" type="button" value="Talk To Us"></input>

3. Add/update your index.js as follows:

   Add the following line in `bindEvents` function

        document.getElementById('talkToUs', addEventListener("click", this.talkToUs));
        
   Add the following line in `onDeviceReady` function

        konotor.init();

   Add a `talkToUs` method

        talkToUs: function() {
            konotor.launchKonotorScreen();
        }
