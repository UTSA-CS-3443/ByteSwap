package edu.utsa.cs3443.byteswap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Account extends Fragment {

    private EditText statusInput;
    private Button postButton;

    public Account() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_profile, container, false);

        // Initialize views
        statusInput = view.findViewById(R.id.statusInput);
        postButton = view.findViewById(R.id.postButton);

        // Set up post button functionality
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String statusText = statusInput.getText().toString().trim();

                if (!statusText.isEmpty()) {
                    // Show a toast with the status message
                    Toast.makeText(getContext(), "Posted: " + statusText, Toast.LENGTH_SHORT).show();

                    // Clear the input field after posting
                    statusInput.setText("");
                } else {
                    // Inform the user if the status is empty
                    Toast.makeText(getContext(), "Please enter a status!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
