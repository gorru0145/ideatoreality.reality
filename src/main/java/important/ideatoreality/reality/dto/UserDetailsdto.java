package important.ideatoreality.reality.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsdto {


    private Long id;


    private String username;

    private String bio ;


    private String emailaddress;

    public String movie;

    private List<UserPostdto> posts=new ArrayList<>();
    private List<PostCommentdto> comments=new ArrayList<>();

    public UserDetailsdto(Long id, String username, String bio, String emailaddress, String movie, List<UserPostdto> posts,List<PostCommentdto> comments) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.emailaddress = emailaddress;
        this.movie = movie;
        this.posts = posts;
        this.comments=comments;
    }

    public List<PostCommentdto> getComments() {
        return comments;
    }

    public void setComments(List<PostCommentdto> comments) {
        this.comments = comments;
    }

    public List<UserPostdto> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPostdto> posts) {
        this.posts = posts;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
}
