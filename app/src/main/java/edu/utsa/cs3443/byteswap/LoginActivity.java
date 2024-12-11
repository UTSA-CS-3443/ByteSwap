package edu.utsa.cs3443.byteswap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity class for user login. Manages user authentication and navigation to other activities.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Input field for the username.
     */
    EditText username;
    /**
     * Input field for the password.
     */
    EditText password;
    /**
     * Button to trigger the login process.
     */
    Button loginButton;
    /**
     * Button to navigate to the registration screen.
     */
    Button signupButton;

    /**
     * Called when the activity is starting. Sets up the layout and initializes components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied. Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        username = findViewById(R.id.username);
        password = findViewById(R.id.password_toggle);
        loginButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        // Check if the user is already logged in
        SharedPreferences sharedPref = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPref.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            navigateToMainActivity();
        }

        // Login button logic
        loginButton.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (databaseHelper.validateUser(user, pass)) {
                Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                // Save login state
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.apply();

                // Navigate to MainActivity
                navigateToMainActivity();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }
        });

        // Navigate to the registration activity
        signupButton.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Navigates to the MainActivity and finishes the current activity.
     */
    private void navigateToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Prevent returning to LoginActivity
    }
}
