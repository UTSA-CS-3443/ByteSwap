package edu.utsa.cs3443.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs3443.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButton(R.id.button);
    }



    public void onClick(View view)
    {
        if (view.getId() == R.id.button)
        {
            Intent intent = new Intent(this, DMActivity.class);
            startActivity(intent);
        }
    }

    public void setupButton(int buttonId)
    {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

}