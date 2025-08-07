package important.ideatoreality.reality.dto;

import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.List;

public class UserPostdto {
    private Long pid;
    private String postWrittenData;
    private String postTags;
    private String imageLocation;
    private LocalDateTime addDateTime;
    private UserDetailsdto user;
    private List<PostCommentdto> comments;
    private List<UserDetailsdto> likes;

    public UserDetailsdto getUser() {
        return user;
    }

    public void setUser(UserDetailsdto user) {
        this.user = user;
    }


    public List<UserDetailsdto> getLikes() {
        return likes;
    }

    public void setLikes(List<UserDetailsdto> likes) {
        this.likes = likes;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPostWrittenData() {
        return postWrittenData;
    }

    public void setPostWrittenData(String postWrittenData) {
        this.postWrittenData = postWrittenData;
    }

    public String getPostTags() {
        return postTags;
    }

    public void setPostTags(String postTags) {
        this.postTags = postTags;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public LocalDateTime getAddDateTime() {
        return addDateTime;
    }

    public void setAddDateTime(LocalDateTime addDateTime) {
        this.addDateTime = addDateTime;
    }

    public List<PostCommentdto> getComments() {
        return comments;
    }

    public void setComments(List<PostCommentdto> comments) {
        this.comments = comments;
    }

}
