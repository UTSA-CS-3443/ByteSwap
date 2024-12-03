package edu.utsa.cs3443.byteswap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Settings extends Fragment {

    private Button backButton;
    private Button aboutUsButton;
    private Button funnyDebugButton;
    private Button accountButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View view = inflater.inflate(R.layout.settings_controller, container, false);

        // Set up buttons and their click listeners
        setBackButton(view);
        setAboutUsButton(view);
        setFunnyButton(view);
        setAccountButton(view);

        return view;
    }

    private void setBackButton(View view) {
        backButton = view.findViewById(R.id.back_button);
        if (backButton != null) {
            backButton.setOnClickListener(v -> {
                // Use fragment transactions to navigate back instead of `finish()`
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack();
                } else {
                    Toast.makeText(getContext(), "Cannot navigate back", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getContext(), "Back button not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setAboutUsButton(View view) {
        aboutUsButton = view.findViewById(R.id.about_Us);
        if (aboutUsButton != null) {
            aboutUsButton.setOnClickListener(v -> {
                // Start AboutUs activity
                Intent intent = new Intent(getActivity(), AboutUs.class);
                startActivity(intent);
            });
        } else {
            Toast.makeText(getContext(), "About Us button not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setFunnyButton(View view) {
        funnyDebugButton = view.findViewById(R.id.funnyDebug);
        if (funnyDebugButton != null) {
            funnyDebugButton.setOnClickListener(v -> {
                // Start debug_funny activity
                Intent intent = new Intent(getActivity(), debug_funny.class);
                startActivity(intent);
            });
        } else {
            Toast.makeText(getContext(), "Funny Debug button not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setAccountButton(View view) {
        accountButton = view.findViewById(R.id.account_button);
        if (accountButton != null) {
            accountButton.setOnClickListener(v -> {
                // Start Account activity
                Intent intent = new Intent(getActivity(), Account.class);
                startActivity(intent);
            });
        } else {
            Toast.makeText(getContext(), "Account button not found", Toast.LENGTH_SHORT).show();
        }
    }
}
