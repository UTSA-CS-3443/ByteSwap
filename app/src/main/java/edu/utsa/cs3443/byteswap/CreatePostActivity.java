package edu.utsa.cs3443.byteswap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreatePostActivity extends AppCompatActivity {

    private EditText captionInput;
    private ImageView selectedImage;
    private Button selectImageButton;
    private Button postButton;
    private Uri imageUri; // Declare imageUri variable

    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        // Initialize views
        captionInput = findViewById(R.id.captionInput);
        selectedImage = findViewById(R.id.selectedImage);
        selectImageButton = findViewById(R.id.selectImageButton);
        postButton = findViewById(R.id.postButton);

        // Set up select image button functionality
        selectImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

        // Set up post button functionality
        postButton.setOnClickListener(v -> {
            String caption = captionInput.getText().toString().trim();

            if (!caption.isEmpty() && imageUri != null) { // Check for imageUri instead of Drawable
                // Create the post object and pass it back to the Profile activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("caption", caption);
                resultIntent.putExtra("imageUri", imageUri.toString()); // Pass the URI as string

                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(CreatePostActivity.this, "Please provide a caption and select an image.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Get the image URI and display it in the ImageView
            imageUri = data.getData(); // Assign the URI to the imageUri variable
            selectedImage.setImageURI(imageUri); // Set the image URI to the ImageView
        }
    }
}

