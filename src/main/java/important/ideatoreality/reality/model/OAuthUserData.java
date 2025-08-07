package important.ideatoreality.reality.model;


import jakarta.persistence.*;

@Entity
@Table(name="oauthuser_data")
public class OAuthUserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;


    private String email;

    private String name;

    @Column(name="principal_detail",length = 4000)
    private String principaldetail;

    protected OAuthUserData() {
    }

    public OAuthUserData(String email, String name, String principaldetail) {
        this.email = email;
        this.name = name;
        this.principaldetail = principaldetail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrincipaldetail() {
        return principaldetail;
    }

    public void setPrincipaldetail(String principaldetail) {
        this.principaldetail = principaldetail;
    }
}
