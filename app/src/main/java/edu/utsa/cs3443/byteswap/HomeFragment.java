package edu.utsa.cs3443.byteswap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment that displays a list of posts using a RecyclerView.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private FeedAdapter feedAdapter;
    private List<Post> postList;

    /**
     * Creates and inflates the view for the fragment.
     *
     * @param inflater the LayoutInflater to use for inflating the layout
     * @param container the container in which the fragment is displayed
     * @param savedInstanceState saved state of the fragment
     * @return the View for the fragment's UI
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        postList = new ArrayList<>();
        populatePosts();

        feedAdapter = new FeedAdapter(postList);
        recyclerView.setAdapter(feedAdapter);

        return view;
    }

    /**
     * Populates the list of posts with sample data.
     */
    private void populatePosts() {
        postList.add(new Post("ReeseSylvester", "Pastrami Meatballs", "5 min ago", R.drawable.image1));
        postList.add(new Post("JibrilPascua", "Mozzarella and Pesto Bread", "15 min ago", R.drawable.image2));
        // Add more sample posts...
    }
}
