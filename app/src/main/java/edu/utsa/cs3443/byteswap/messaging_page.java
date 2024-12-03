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

public class messaging_page extends Fragment {

    private ListView list;
    private ListViewAdapter adapter;
    private ArrayList<String[]> arrayList;

    public messaging_page() {
        // Required empty public constructor
    }

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
