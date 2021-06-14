package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/** ファイル情報を全て取得. */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "getAllFiles",
            query = "SELECT m FROM FileInfo AS m ORDER BY m.updated_at DESC"
            )
})
/**
 * ファイル情報を管理するEntityクラス.
 */
@Table(name = "file_infos")
public class FileInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "data", nullable = false, columnDefinition="mediumblob")
    private byte[] data;

    @Column(name = "is_image", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean is_image;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean getIs_image() {
        return is_image;
    }

    public void setIs_image(boolean is_image) {
        this.is_image = is_image;
    }
    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}