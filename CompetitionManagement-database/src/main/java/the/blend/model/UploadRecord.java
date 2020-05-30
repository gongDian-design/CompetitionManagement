package the.blend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author: 钱曹宇
 * @date: 2020/5/29 11:11 下午
 * @description:
 */
@Entity
public class UploadRecord {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date uploadDate;

    @Column(nullable = false)
    private String filename;

    @OneToMany(mappedBy = "record")
    private Set<GroupRecord> records;

    @Override
    public String toString() {
        return "UploadRecord{" +
                "id=" + id +
                ", uploadDate=" + uploadDate +
                ", filename='" + filename + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
