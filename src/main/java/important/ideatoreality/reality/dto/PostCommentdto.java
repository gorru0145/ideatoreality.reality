package important.ideatoreality.reality.dto;

import important.ideatoreality.reality.model.User_Post;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class PostCommentdto {
    private Long pcid;
    private String comment;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private UserPostdto post;
    private UserDetailsdto user;

    public UserPostdto getPost() {
        return post;
    }

    public void setPost(UserPostdto post) {
        this.post = post;
    }

    public UserDetailsdto getUser() {
        return user;
    }

    public void setUser(UserDetailsdto user) {
        this.user = user;
    }

    public Long getPcid() {
        return pcid;
    }

    public void setPcid(Long pcid) {
        this.pcid = pcid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


}

