package edu.utsa.cs3443.byteswap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private List<Post> postList;

    public FeedAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.usernameTextView.setText(post.getUsername());
        holder.contentTextView.setText(post.getContent());
        holder.timestampTextView.setText(post.getTimestamp());
        holder.postImageView.setImageResource(post.getImageResId());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    static class FeedViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTextView;
        TextView contentTextView;
        TextView timestampTextView;
        ImageView postImageView;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
            timestampTextView = itemView.findViewById(R.id.timestampTextView);
            postImageView = itemView.findViewById(R.id.postImageView);
        }
    }
}
