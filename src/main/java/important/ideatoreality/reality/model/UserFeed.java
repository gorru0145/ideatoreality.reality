package important.ideatoreality.reality.model;

public class UserFeed {

    private Long id;
    private String name;
    private String email;
    private String ideadata;

    public UserFeed(){
    }
    public UserFeed(String name,String email,String ideadata){
        this.name=name;
        this.email=email;
        this.ideadata=ideadata;
    }
    public Long getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIdeadata(){
        return ideadata;
    }
    public void setIdeadata(){
        this.ideadata=ideadata;
    }


}
