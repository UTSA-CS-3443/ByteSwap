package edu.utsa.cs3443.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DMActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list;
    private edu.utsa.cs3443.dm.ListViewAdapter adapter;
    private ArrayList<String[]> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmactivity);
        setupButton(R.id.backButton);
        list = findViewById(R.id.messagesList);

        arrayList = new ArrayList<String[]>();


        arrayList.add(new String[]{"Brooke", "Hello this is my last message"});
        arrayList.add(new String[]{"Raina", "I am done"});
        arrayList.add(new String[]{"Jib", "Hello this is my last message"});
        arrayList.add(new String[]{"Reese", "Hello this is my last message"});
        arrayList.add(new String[]{"Iqra", "Hello this is my last message"});

        adapter = new edu.utsa.cs3443.dm.ListViewAdapter(this, arrayList);
        list.setAdapter(adapter);
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