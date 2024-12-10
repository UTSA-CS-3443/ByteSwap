package edu.utsa.cs3443.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import edu.utsa.cs3443.myapplication.ChatBubbleAdapter;
import edu.utsa.cs3443.myapplication.R;

public class MessageChatActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message_chat);

        TextView contactName = findViewById(R.id.contactNameHeader);

        Intent intent = getIntent();

        ListView chat = findViewById(R.id.chatList);

        String name = DMActivity.decodeExtra(intent);
        contactName.setText(name);

        setupButton(R.id.backButton);


        ArrayList<String[]> messageHistory = populateChatHistory(name);

        chat.setAdapter(new ChatBubbleAdapter(this, messageHistory));


    }

    public void onClick(View view) {
        if (view.getId() == R.id.backButton) {
            finish();
        }
    }

    public void setupButton(int buttonId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(this);
    }


    public static ArrayList<String[]> populateChatHistory(String contactName) {
        // TODO: replace with file i/o instead of hard coding values
        
        ArrayList<String[]> messages = new ArrayList<String[]>();
        
        String userName = "user";

        switch (contactName) {
            case "Brooke":

                messages.add(new String[]{contactName, "Hey"});
                messages.add(new String[]{userName, "Hello"});
                messages.add(new String[]{contactName, "How are you"});
                messages.add(new String[]{userName, "I'm good wbu"});
                break;

                case "Raina":

                messages.add(new String[]{contactName, "Hello"});
                messages.add(new String[]{userName, "Hello"});
                messages.add(new String[]{userName, "How are you"});
                break;

            case "Jib":

                messages.add(new String[]{contactName, "HI!!"});
                messages.add(new String[]{userName, "Heyy"});
                messages.add(new String[]{contactName, "How is the project going?"});
                messages.add(new String[]{userName, "It could be better"});
                break;

            case "Reese":

                messages.add(new String[]{contactName, "Hey, how have you been?!"});
                messages.add(new String[]{userName, "Heyy, I am doing awesome! How about you?"});
                messages.add(new String[]{contactName, "It's good, I really liked your recent post"});
                messages.add(new String[]{userName, "OMG thank you!"});
                break;

            case "Iqra":

                messages.add(new String[]{contactName, "I liked your recent post!!"});
                messages.add(new String[]{userName, "Thank you, yours looks awesome as well, I might it try soon"});
                messages.add(new String[]{contactName, "Let me know how it turns out!"});
                messages.add(new String[]{userName, "Will do!"});
                break;

            case "Dr.Hosseini":

                messages.add(new String[]{contactName, "Hi group Ctrl-Alt-Dominate!!"});
                messages.add(new String[]{userName, "Hello!"});
                messages.add(new String[]{contactName, "I really like yall's app!"});
                messages.add(new String[]{userName, "Thanks! So does that mean we get a 100?!"});
                break;

            case "Sam":
                break;
        }
        
        return messages;
    }
}