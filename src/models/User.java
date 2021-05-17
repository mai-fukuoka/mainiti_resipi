package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="users")
@NamedQueries({
    @NamedQuery(
            name="checkRegisteredUser_id",
            query="SELECT COUNT(u) FROM User AS u WHERE u.user_id = :user_id"
            ),

    @NamedQuery(
            name = "checkLoginUser_idAndPassword",
            query = "SELECT u FROM User AS u WHERE u.user_id = :user_id AND u.password = :pass"
            )
})

@Entity
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id",length=20,nullable=false,unique=true)
    private String user_id;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="password",length=64,nullable=false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
