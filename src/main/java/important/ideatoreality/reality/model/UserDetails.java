package important.ideatoreality.reality.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user_details")
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="user_name")
    private String username;

    private String bio ;

    @Column(name="email_address", nullable = false,unique = true)
    private String emailaddress;

    private String movie;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User_Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<>();


    public UserDetails(){}

    public UserDetails(Long id, String username, String bio, String emailaddress, String movie, List<User_Post> posts,List<PostComment> comments) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.emailaddress = emailaddress;
        this.movie = movie;
        this.posts = posts;
        this.comments=comments;

    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }

    public List<User_Post> getPosts() {
        return posts;
    }

    public void setPosts(List<User_Post> posts) {
        this.posts = posts;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public long getId() {
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
