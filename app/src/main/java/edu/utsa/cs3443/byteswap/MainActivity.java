package edu.utsa.cs3443.byteswap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtons();
    }


    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.settingsButton) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        }
    }
    private void setUpButtons(){
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setText("Settings");
        settingsButton.setOnClickListener(this);


    }
}
