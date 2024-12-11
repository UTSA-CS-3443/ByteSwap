package edu.utsa.cs3443.byteswap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * Fragment for the messaging page, displaying a list of contacts and their messages.
 */
public class messaging_page extends Fragment {
    
     /**
     * ListView to display the list of contacts.
     */
    private ListView list;
    /**
     * Custom adapter to populate the ListView.
     */
    private ListViewAdapter adapter;
    /**
     * ArrayList to hold the data for the ListView.
     */
    private ArrayList<String[]> arrayList;
    /**
     * Default constructor for the fragment.
     */
    public messaging_page() {
        // Required empty public constructor
    }

    /**
     * Called to create and return the view hierarchy associated with the fragment.
     *
     * @param inflater The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container The parent view that the fragment's UI should attach to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return The root View of the fragment's layout.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View view = inflater.inflate(R.layout.activity_dmactivity, container, false);

        // Initialize the ListView
        list = view.findViewById(R.id.messagesList);

        // Initialize the message list
        arrayList = new ArrayList<>();
        arrayList.add(new String[]{"Brooke", "Hello this is my last message"});
        arrayList.add(new String[]{"Raina", "I am done"});
        arrayList.add(new String[]{"Jib", "Hello this is my last message"});
        arrayList.add(new String[]{"Reese", "Hello this is my last message"});
        arrayList.add(new String[]{"Iqra", "Hello this is my last message"});

        // Set up the ListView adapter
        adapter = new ListViewAdapter(requireContext(), arrayList);
        list.setAdapter(adapter);

        // Set up the Back Button

        return view;
    }

    /**
     * Sets up a button with an OnClickListener to handle back navigation.
     *
     * @param view The root view of the fragment.
     * @param buttonId The resource ID of the button.
     */
    private void setupButton(View view, int buttonId) {
        Button button = view.findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v -> {
                // Handle back navigation for the fragment
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack();
                }
            });
        }
    }
}
