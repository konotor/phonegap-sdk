# Konotor PhoneGap/Cordova Plugin
### Platform Support

This plugin supports PhoneGap/Cordova apps with version 3.0.0 and above running on iOS and Android.

## Installation
#### Automatic Installation using PhoneGap/Cordova CLI(For iOS and Android)

1. Install this plugin using PhoneGap/Cordova cli:

        phonegap plugin add  https://bitbucket.org/bharaths/konotor.git --variable APP_ID="YOUR_APP_ID" --variable APP_KEY="YOUR_APP_KEY"

                                    or

        cordova plugin add  https://bitbucket.org/bharaths/konotor.git --variable APP_ID="YOUR_APP_ID" --variable APP_KEY="YOUR_APP_KEY"

(Note that the Phonegap CLI didn't support --variable before version 3.6.3, so please use the Cordova CLI as shown above in case you're on an older version)

2. Add this script tag to your index.html:

        <input id="KonotorMenu" type="button" value="Talk To Us" onclick="konotor.launchKonotorScreen();"></input>