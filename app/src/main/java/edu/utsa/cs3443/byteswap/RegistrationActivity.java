package edu.utsa.cs3443.byteswap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity class for user registration. Handles input validation and interaction with the database.
 */
public class RegistrationActivity extends AppCompatActivity {

    /**
     * Input field for the username.
     */
    /**
     * Input field for the password.
     */
    EditText usernameInput, passwordInput;
    /**
     * Button to trigger the registration process.
     */
    Button registerButton;
    /**
     * Helper object for database operations.
     */
    DatabaseHelper databaseHelper;

    /**
     * Called when the activity is starting. Sets up the layout and initializes components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied. Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize UI components
        usernameInput = findViewById(R.id.register_username);
        passwordInput = findViewById(R.id.register_password);
        registerButton = findViewById(R.id.register_button);
        databaseHelper = new DatabaseHelper(this);

        // Set up the registration button click listener
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                // Validate input fields
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (databaseHelper.addUser(username, password)) {
                    Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    finish(); // Go back to login page
                } else {
                    Toast.makeText(RegistrationActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
