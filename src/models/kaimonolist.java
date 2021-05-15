package models;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Table(name = "kaimonolists")
@SqlResultSetMapping(name = "deleteResult", columns = { @ColumnResult(name = "count") })
@NamedQueries({
    @NamedQuery(name = "getAllKaimonolists",
                query = "SELECT k FROM Kaimonolist AS k ORDER BY k.id DESC"),
    @NamedQuery(name = "getKaimonolistsCount",
                query = "SELECT COUNT(k) FROM Kaimonolist AS k")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "removeAllKaimonolists",
            query = "DELETE FROM kaimonolists WHERE kaimonolists.userid = :userid",
            resultSetMapping = "deleteResult")
})

@Entity
public class Kaimonolist {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userid", length = 255, nullable = true)
    private String userid;

    @Column(name = "ingredient", length = 255, nullable = false)
    private String ingredient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIngredient() {
        return ingredient;

    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

}
