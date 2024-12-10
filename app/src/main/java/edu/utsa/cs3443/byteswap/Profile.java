package edu.utsa.cs3443.byteswap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    private static final int CREATE_POST_REQUEST = 1;
    private GridLayout postsGrid;
    private Button postButton;
    private EditText statusInput; // New EditText for "What's on your mind?"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        postsGrid = findViewById(R.id.postsGrid);
        postButton = findViewById(R.id.postButton);
        statusInput = findViewById(R.id.statusInput); // Initialize status input field

        // Set up post button functionality
        postButton.setOnClickListener(v -> {
            String statusText = statusInput.getText().toString().trim();

            if (!statusText.isEmpty()) {
                // Add status as a new post without an image (optional)
                addPostToGrid(statusText, null); // Passing null as no image is selected
                statusInput.setText("What's on your mind?"); // Clear the status input field
            } else {
                Toast.makeText(Profile.this, "Please enter a status!", Toast.LENGTH_SHORT).show();
            }

            // Optionally, allow launching CreatePostActivity for image posts
            // Launch CreatePostActivity for caption and image
            Intent intent = new Intent(Profile.this, CreatePostActivity.class);
            startActivityForResult(intent, CREATE_POST_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_POST_REQUEST && resultCode == RESULT_OK && data != null) {
            // Get the caption and image URI from the intent
            String caption = data.getStringExtra("caption");
            String imageUriString = data.getStringExtra("imageUri");
            Uri imageUri = Uri.parse(imageUriString);

            // Add the new post to the grid
            addPostToGrid(caption, imageUri);
        }
    }

    private void addPostToGrid(String caption, Uri imageUri) {
        // Create an ImageView for the image if it's not null
        if (imageUri != null) {
            ImageView postImage = new ImageView(this);
            postImage.setLayoutParams(new GridLayout.LayoutParams());
            postImage.setImageURI(imageUri);
            postImage.setContentDescription("Post Image");

            // Add the ImageView to the GridLayout
            postsGrid.addView(postImage);
        }

        // Create a TextView for the caption (status message or post caption)
        TextView postCaption = new TextView(this);
        postCaption.setText(caption);
        postCaption.setLayoutParams(new GridLayout.LayoutParams());
        postCaption.setPadding(0, 8, 0, 0);  // Add some spacing between image and caption

        // Add the TextView to the GridLayout
        postsGrid.addView(postCaption);
    }
}




