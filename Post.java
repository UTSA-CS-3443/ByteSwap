package edu.utsa.cs3443.byteswap;

public class Post {
    private String username;
    private String content;
    private String timestamp;
    private int imageResId;

    public Post(String username, String content, String timestamp, int imageResId) {
        this.username = username;
        this.content = content;
        this.timestamp = timestamp;
        this.imageResId = imageResId;
    }

    public String getUsername() { return username; }
    public String getContent() { return content; }
    public String getTimestamp() { return timestamp; }
    public int getImageResId() { return imageResId; }
}
