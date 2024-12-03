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

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private FeedAdapter feedAdapter;
    private List<Post> postList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data
        postList = new ArrayList<>();
        populatePosts();

        // Set up adapter
        feedAdapter = new FeedAdapter(postList);
        recyclerView.setAdapter(feedAdapter);

        return view;
    }

    private void populatePosts() {
        postList.add(new Post("ReeseSylvester", "Pastrami Meatballs", "5 min ago", R.drawable.image1));
        postList.add(new Post("JibrilPascua", "Mozzarella and Pesto Bread", "15 min ago", R.drawable.image2));
        postList.add(new Post("BrookeLane", "Cranberry-Brie Knots", "30 min ago", R.drawable.image3));
        postList.add(new Post("IqraAbdullah", "Baked Brie with Cranberry-Pecan Crumble", "1 hour ago", R.drawable.image4));
        postList.add(new Post("RainaRivera", "Mediterranean Holiday Board", "2 hours ago", R.drawable.image5));
        postList.add(new Post("user1", "Toasted Ravioli", "3 hours ago", R.drawable.image6));
        postList.add(new Post("user2", "Cheese-Stuffed Pepper Christmas Tree", "5 hours ago", R.drawable.image7));
    }
}
