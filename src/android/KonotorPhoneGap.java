/*
Copyright (c) 2013 Demach Software India Private Limited
*/

package com.demach.konotor;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.demach.konotor.Konotor;


public class KonotorPhoneGap extends CordovaPlugin {

  private static final String INIT="init";
  private static final String LAUNCH_FEEDBACK="launchFeedbackScreen";

  private static final String SET_IDENTIFIER="setIdentifier";
  private static final String SET_USERNAME="setUserName";
  private static final String SET_USEREMAIL="setUserEmail";
  private static final String SET_USERMETA="setUserMeta";
  private static final String SET_WELCOMEMESSAGE="setWelcomeMessage";
  private static final String SET_SUPPORTNAME="setSupportName";
  private static final String SET_NOAUDIORECORDING="setNoAudioRecording";
  private static final String SET_NOPICTUREMESSAGING="setNoPictureMessaging";
  private static final String SET_FEEDBACKSCREENTITLE="setFeedbackScreenTitle";
    private static final String UPDATE="update";
  private static final String GET_UNREADCOUNT="getUnreadCount";
  private static final String REGISTER_UNREADCOUNTCHANGE="registerUnreadCountChangedCallback";

  public static final String KONOTOR_LOCAL_BROADCAST_UNREADMESSAGECOUNT = "Konotor_UnreadMessageCountChanged";
  public JSONArray params;
  public String appID;
  public String appKey;
 // private CallbackContext notificationCallback;

    protected void pluginInitialize() {

        Context context= this.cordova.getActivity().getApplicationContext();

        int appResId = cordova.getActivity().getResources().getIdentifier("KONOTOR_APP_KEY", "string", cordova.getActivity().getPackageName());
        String APP_ID = cordova.getActivity().getString(appResId);

        appResId = cordova.getActivity().getResources().getIdentifier("KONOTOR_APP_ID", "string", cordova.getActivity().getPackageName());

        String APP_KEY = cordova.getActivity().getString(appResId);

        Konotor.getInstance(context).init(APP_ID,APP_KEY);

    }


  @Override
  public boolean execute (String function, JSONArray args,
                          CallbackContext callbackContext) {
      params = args;
      try{
           if (INIT.equals(function)) {
                getPreferenceValues(params);
                  cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext())
                          .init(appID,
                                appKey);
                     //     callbackContext.success();
                      }
                  });

                  return true;

              }

              else if (LAUNCH_FEEDBACK.equals(function)) {
                  Konotor.getInstance(cordova.getActivity().getApplicationContext())
                  .launchFeedbackScreen(cordova.getActivity());
                  callbackContext.success();
                  return true;
              }

              else if (SET_USERMETA.equals(function)) {
                  final String metaField = args.getString(0);
                  final String metaValue=args.getString(1);
            //      cordova.getThreadPool().execute(new Runnable() {
//                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withUserMeta(metaField,metaValue).update();
                        //  callbackContext.success();
//                      }
              //    });

                  return true;

              }

              else if (SET_WELCOMEMESSAGE.equals(function)) {
                  final String welcomeString = args.getString(0);
             //     cordova.getThreadPool().execute(new Runnable() {
             //         public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withWelcomeMessage(welcomeString);
                     //     callbackContext.success();
            //          }
            //      });

                  return true;

              }

              else if (SET_IDENTIFIER.equals(function)) {

                  final String identifier = args.getString(0);
            //      cordova.getThreadPool().execute(new Runnable() {
             //         public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withIdentifier(identifier).update();
                       //   callbackContext.success();
               //       }
               //   });

                  return true;


              }

              else if (SET_USEREMAIL.equals(function)) {

                  final String email = args.getString(0);
                  cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withUserEmail(email).update();
                    //      callbackContext.success();
                      }
                  });

                  return true;

              }

              else if (SET_USERNAME.equals(function)) {

                  final String username = args.getString(0);
                  cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withUserName(username).update();
                   //       callbackContext.success();
                      }
                  });

                  return true;

              }

              else if (SET_FEEDBACKSCREENTITLE.equals(function)) {

                  final String feedbackscreentitle = args.getString(0);
                  cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withFeedbackScreenTitle(feedbackscreentitle).update();
                   //       callbackContext.success();
                      }
                  });

                  return true;

              }
              else if (SET_SUPPORTNAME.equals(function)) {

                  final String supportname = args.getString(0);
                  cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withSupportName(supportname).update();
                   //       callbackContext.success();
                      }
                  });

                  return true;

              }

                  else if (SET_NOAUDIORECORDING.equals(function)) {

                  final String audioRecording = args.getString(0);
                  final Boolean audioValue = Boolean.parseBoolean(audioRecording);
                  cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
Konotor.getInstance(cordova.getActivity().getApplicationContext()).withNoAudioRecording(audioValue).update();
                   //       callbackContext.success();
                      }
                  });

                  return true;

              }
              else if (SET_NOPICTUREMESSAGING.equals(function)) {

                  final String pictureMessaging = args.getString(0);
                  final Boolean pictureValue = Boolean.parseBoolean(pictureMessaging);
                  cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).withNoPictureMessaging(pictureValue).update();
                   //       callbackContext.success();
                      }
                  });

                  return true;

              }

              else if (UPDATE.equals(function)) {
                 cordova.getThreadPool().execute(new Runnable() {
                      public void run() {
                          Konotor.getInstance(cordova.getActivity().getApplicationContext()).update();
                          //       callbackContext.success();
                      }
                  });

                  return true;

              }

              else if (REGISTER_UNREADCOUNTCHANGE.equals(function)) {
                  //final String callbackfunction = args.getString(0);

                  BroadcastReceiver konotor_broadcastReceiver = new BroadcastReceiver()
                  {
                      @Override
                      public void onReceive(Context context, Intent intent) {
                       //   Log.d(TAG,"Got Local Intent");
                          int unreadcount=Konotor.getInstance(cordova.getActivity().getApplicationContext()).getUnreadMessageCount();
                          KonotorPhoneGap.this.webView.sendJavascript("Konotor.setUnreadCount("+unreadcount+")");
                          KonotorPhoneGap.this.webView.sendJavascript("Konotor.unreadCountChanged()");
                      }
                  };
                  IntentFilter konotorIntentFilter = new IntentFilter(KONOTOR_LOCAL_BROADCAST_UNREADMESSAGECOUNT);
                  LocalBroadcastManager.getInstance(cordova.getActivity().getApplicationContext()).registerReceiver(konotor_broadcastReceiver, konotorIntentFilter);;

                  return true;

              }

              else if (GET_UNREADCOUNT.equals(function)) {

                  int count=Konotor.getInstance(cordova.getActivity().getApplicationContext()).getUnreadMessageCount();
                  callbackContext.success(count);

                  return true;

              }

              else {

                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
                return false;

              }
          }
      catch(Exception e){
      return false;
      }
  }
    private void getPreferenceValues(JSONArray paramsPref) {
        try {
            appID = paramsPref.getString(0);
            appKey = paramsPref.getString(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
