package edu.utsa.cs3443.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import edu.utsa.cs3443.myapplication.ListViewAdapter;
import edu.utsa.cs3443.myapplication.R;

public class DMActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list;
    private edu.utsa.cs3443.myapplication.ListViewAdapter adapter;
    private ArrayList<String[]> arrayList;

    private static String extraName = "contactName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmactivity);

        setupButton(R.id.backButton);

        list = findViewById(R.id.messagesList);

        arrayList = new ArrayList<String[]>();

        arrayList.add(getContactEntry("Brooke"));
        arrayList.add(getContactEntry("Raina"));
        arrayList.add(getContactEntry("Jib"));
        arrayList.add(getContactEntry("Reese"));
        arrayList.add(getContactEntry("Iqra"));
        arrayList.add(getContactEntry("Dr.Hosseini"));
        arrayList.add(getContactEntry("Sam"));

        adapter = new ListViewAdapter(this, arrayList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String[] names = (String[])adapterView.getAdapter().getItem(i);

            Intent intent = new Intent(DMActivity.this, MessageChatActivity.class);
            intent.putExtra("contactName", names[0]);
            startActivity(intent);

            }
        }

        );
    }

    public static String decodeExtra(Intent intent)
    {
        return intent.getStringExtra(extraName);
    }

    public String[] getContactEntry(String contactName) {
        ArrayList<String[]> messages = MessageChatActivity.populateChatHistory(contactName);

        if (messages.isEmpty()) {
            return new String[]{contactName, "No history"};
        }
        return new String[]{contactName, messages.get(messages.size()-1)[1]};
    }

    public void onClick(View view)
    {
        if (view.getId() == R.id.backButton)
        {
            finish();
        }
    }

    public void setupButton(int buttonId)
    {
        Button button = findViewById(buttonId);
        button.setOnClickListener(this);
    }
}