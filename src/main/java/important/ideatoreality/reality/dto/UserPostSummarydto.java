package important.ideatoreality.reality.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserPostSummarydto {
    private Long userId;
    private String username;
    private String mode;
    private Long postId;
    private LocalDateTime postDate;
    private String postData;
    private String postTags;
    private String imageLocation;
    private List<Commentdto> comments;
    private boolean likeduserid;//nested list
    private int likeCount;
    private String[] tagsArray;

    public UserPostSummarydto(Long userId, String username, String mode, Long postId, LocalDateTime postDate,
                              String postData, String postTags, String imageLocation, Long likeCount) {
        this.userId = userId;
        this.username = username;
        this.mode = mode;
        this.postId = postId;
        this.postDate = postDate;
        this.postData = postData;
        this.postTags = postTags;
        this.imageLocation = imageLocation;
        this.likeCount = likeCount != null ? likeCount.intValue() : 0;
        this.comments = new ArrayList<>();

    }

    public boolean getLikeduserid() {
        return likeduserid;
    }

    public void setLikeduserid(boolean likeduserid) {
        this.likeduserid = likeduserid;
    }

    public String[] getTagsArray() {
        return tagsArray;
    }

    public void setTagsArray(String[] tagsArray) {
        this.tagsArray = tagsArray;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getMode() {
        return mode;
    }

    public Long getPostId() {
        return postId;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public String getPostData() {
        return postData;
    }

    public String getPostTags() {
        return postTags;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public List<Commentdto> getComments() {
        return comments;
    }

    public void setComments(List<Commentdto> comments) {
        this.comments = comments;
    }

}
