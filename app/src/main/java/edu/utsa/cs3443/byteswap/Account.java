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

/**
 * Represents the Account fragment, allowing the user to input a status and post it. 
 */
public class Account extends Fragment {
    
    /** EditText for entering the user's status. */
    private EditText statusInput;

    /** Button for posting the user's status. */
    private Button postButton;

     /**
     * Default constructor for the Account fragment.
     * Required to ensure the fragment can be instantiated properly.
     */
    public Account() {
        // Required empty public constructor
    }

    /**
     * Called to create and return the view hierarchy associated with the fragment.
     *
     * @param inflater The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container The parent view that the fragment's UI should be attached to (if applicable).
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous state.
     * @return The View for the fragment's UI, or null if not applicable.
     */
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

                } else {
                    // Inform the user if the status is empty
                    Toast.makeText(getContext(), "Please enter a status!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
