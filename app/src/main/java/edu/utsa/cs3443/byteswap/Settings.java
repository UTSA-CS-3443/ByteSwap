package edu.utsa.cs3443.byteswap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
public class Settings extends AppCompatActivity {

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_controller);

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
}
