package edu.utsa.cs3443.byteswap;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import edu.utsa.cs3443.byteswap.Profile;
import android.widget.Toast;
private EditText statusInput;
private Button postButton;
private GridLayout postsGrid;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        statusInput = findViewById(R.id.statusInput); // Ensure statusInput is defined in XML
        postButton = findViewById(R.id.postButton);   // Ensure postButton is defined in XML
        postsGrid = findViewById(R.id.postsGrid);     // Ensure postsGrid is defined in XML

        // Set listener for the Post button
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String statusText = statusInput.getText().toString();

                if (statusText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a status to post", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity.this, "Posted: " + statusText, Toast.LENGTH_SHORT).show();

                // Create a new ImageView (new post)
                ImageView newPostImage = new ImageView(MainActivity.this);
                newPostImage.setLayoutParams(new GridLayout.LayoutParams());
                newPostImage.setImageResource(R.drawable.food1); // Placeholder food image

                // Add the new post to the grid
                postsGrid.addView(newPostImage);

                // Clear the status input field
                statusInput.setText("");
            }
        });

        // Set up other buttons (like Settings)
        setUpButtons();
    }
}
