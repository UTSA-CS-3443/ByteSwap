package edu.utsa.cs3443.byteswap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    private EditText statusInput;
    private Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        statusInput = findViewById(R.id.statusInput);
        postButton = findViewById(R.id.postButton);

        // Set up post button functionality
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String statusText = statusInput.getText().toString().trim();

                if (!statusText.isEmpty()) {
                    // Show a toast with the status message
                    Toast.makeText(Profile.this, "Posted: " + statusText, Toast.LENGTH_SHORT).show();

                    // Clear the input field after posting
                    statusInput.setText("");
                } else {
                    // Inform the user if the status is empty
                    Toast.makeText(Profile.this, "Please enter a status!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

