package edu.utsa.cs3443.byteswap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity class for the "Debug Funny" screen, containing an easter egg view.
 * Provides functionality for navigating back to the previous screen.
 */
public class debug_funny extends AppCompatActivity {

    /**
     * Button for navigating back to the previous activity.
     */
    private Button backButton;
    /**
     * Called when the activity is starting. Sets up the layout and initializes components.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied. Otherwise, it is null.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_view_easteregg);
        setBackButton();

    }

    /**
     * Sets up the back button to close the activity and navigate back to the previous screen.
     * Displays a Toast message if the back button is not found in the layout.
     */
    private void setBackButton(){
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
