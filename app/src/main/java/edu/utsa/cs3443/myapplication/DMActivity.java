package edu.utsa.cs3443.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DMActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_messages);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//        private static final String TAG = "DMActivity";
//
//        /**
//         * Initialises the Twitter factory instance used to authenticate and create new Twitter object instances.
//         */
//        private static final DMActivity factory = new DMActivity(
//                new ConfigurationBuilder()
//                        .setDebugEnabled(true)
//                        .setOAuthConsumerKey("<your app's API key>")
//                        .setOAuthConsumerSecret("<your app's API secret>")
//                        .setOAuthAccessToken("<a user's access token for your app>")
//                        .setOAuthAccessTokenSecret("<a user's access token secret for your app>")
//                        .setTweetModeExtended(true)
//                        .build());
//
//        public <DirectMessageList> Object DMActivity (int count, String nextCursor) {
//            if (count < 1 || count > 50) {
//                Log.e(TAG, "Invalid input - count must be between 1 and 50.");
//                return null;
//            }
//            DirectMessage directmessage = factory.getInstance();
//            DirectMessageList messages;
//            try {
//                if (nextCursor == null) {
//                    messages = directmessage.getDirectMessages(count);
//                } else {
//                    messages = directmessage.getDirectMessages(count, nextCursor);
//                }
//            } catch (TwitterException e) {
//                Log.e(TAG, "Failed to retrieve direct messages from Twitter API", e);
//                // You can implement specific error handling for some Twitter error codes here, since e.g. server overload you could
//                // wait and try again instead of returning null
//                return null;
//            }
//            return messages;
//        }
//
//        public DirectMessageList getAllAvailableDirectMessages() {
//            int maxCount = 50;
//            DirectMessageList messages = getLastXDirectMessages(maxCount, null);
//            if (messages == null) {
//                return messages;
//            }
//            String nextCursor = messages.getNextCursor();
//            while (nextCursor != null && !nextCursor.equals("")) {
//                try {
//                    Thread.sleep(60 * 1000);
//                } catch (Exception e) {
//                    Log.e(TAG, "Interrupted", e);
//                    return null;
//                }
//                DirectMessageList nextList = getLastXDirectMessages(maxCount, nextCursor);
//                if (nextList == null) {
//                    return messages;
//                }
//                nextCursor = nextList.getNextCursor();
//                messages.addAll(nextList);
//            }
//            return messages;
//        }
//
//    }
    }
