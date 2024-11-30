package edu.utsa.cs3443.byteswap;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpButtons();
    }


    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.settingsButton) {
            Intent newIntent = new Intent(MainActivity.this, Settings.class);
            startActivity(newIntent);
        }
    }
    private void setUpButtons(){
        Button trickButton = findViewById(R.id.settingsButton);
        trickButton.setText("Settings");
        trickButton.setOnClickListener(this);


    }
}
