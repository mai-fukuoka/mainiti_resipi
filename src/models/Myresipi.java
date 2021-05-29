package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="myresipis")
@NamedQueries({
    @NamedQuery(
    name="getAllMyresipsis",
            query="SELECT m FROM Myresipi AS m ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name="getMyreipisCount",
            query="SELECT COUNT(m) FROM Myresipi AS m"
            ),
})

@Entity
public class Myresipi {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @Column(name="title",length=255,nullable=false)
    private String title;

    @Lob
    @Column(name="content",nullable=false)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
