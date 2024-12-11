package edu.utsa.cs3443.byteswap;

/**
 * Represents a post in the feed with user information, content, timestamp, and an image resource.
 */
public class Post {
    private String username;
    private String content;
    private String timestamp;
    private int imageResId;

    /**
     * Constructs a Post with the specified details.
     *
     * @param username the username of the person who created the post
     * @param content the content of the post
     * @param timestamp the time when the post was created
     * @param imageResId the resource ID of the image associated with the post
     */
    
    public Post(String username, String content, String timestamp, int imageResId) {
        this.username = username;
        this.content = content;
        this.timestamp = timestamp;
        this.imageResId = imageResId;
    }

    /**
     * @return the username of the post's creator
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the content of the post
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the timestamp of the post
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @return the resource ID of the post's image
     */
    public int getImageResId() {
        return imageResId;
    }
}
