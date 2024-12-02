package edu.utsa.cs3443.byteswap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
public class Settings extends AppCompatActivity {

    private Button backButton;
    private Button aboutUsbutton;
    private Button funnyDebug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_controller);
        setAboutUs();
        setFunnyButton();
        setBackButton();

    }


    private void setBackButton() {
        backButton = findViewById(R.id.back_button);
        if (backButton != null) {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Closes the Settings activity and returns to MainActivity
                }
            });
        } else {
            Toast.makeText(this, "Back button not found", Toast.LENGTH_SHORT).show();
        }
    }


    private void setAboutUs() {
        aboutUsbutton = findViewById(R.id.about_Us);
        if (aboutUsbutton != null) {
            aboutUsbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(Settings.this, AboutUs.class);
                    startActivity(Intent);// Closes the Settings activity and returns to MainActivity
                }
            });
        } else {
            Toast.makeText(this, "Back button not found", Toast.LENGTH_SHORT).show();
        }
    }


    private void setFunnyButton() {
        funnyDebug = findViewById(R.id.funnyDebug);
        if (funnyDebug != null) {
            funnyDebug.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(Settings.this, debug_funny.class);
                    startActivity(Intent);// Closes the Settings activity and returns to MainActivity
                }
            });
        } else {
            Toast.makeText(this, "Back button not found", Toast.LENGTH_SHORT).show();
        }
    }

}
