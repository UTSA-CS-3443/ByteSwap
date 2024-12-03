package edu.utsa.cs3443.byteswap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
// Import necessary classes
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Account extends Fragment {

    private Button backButton;

    public Account() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View view = inflater.inflate(R.layout.account_page, container, false);

        // Initialize and set up the back button
        setBackButton(view);

        return view;
    }

    private void setBackButton(View view) {
        backButton = view.findViewById(R.id.back_button);
        if (backButton != null) {
            backButton.setOnClickListener(v -> {
                // Use fragment transaction to navigate back
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().popBackStack();
                } else {
                    Toast.makeText(getContext(), "Cannot navigate back", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getContext(), "Back button not found", Toast.LENGTH_SHORT).show();
        }
    }
}
