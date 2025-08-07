package important.ideatoreality.reality.model;

import jakarta.persistence.*;
import org.apache.juli.logging.Log;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_post")
public class User_Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    @Column(name = "post_data")
    private String postWrittenData;
    @Column(name = "post_tags")
    private String postTags;
    @Column(name = "image_location")
    private String imageLocation;
    @Column(name = "add_datetime")
    private LocalDateTime addDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails user;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<>();

    @ManyToMany
    private List<UserDetails> likes=new ArrayList<>() ;


    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public List<UserDetails> getLikes() {
        return likes;
    }

    public void setLikes(List<UserDetails> likes) {
        this.likes = likes;
    }


    //  getters, setters

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

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }


}
