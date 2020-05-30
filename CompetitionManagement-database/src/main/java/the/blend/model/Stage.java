package the.blend.model;

import javax.persistence.*;

/**
 * @author: 钱曹宇
 * @date: 2020/5/29 11:11 下午
 * @description:
 */
@Entity
public class Stage {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private Boolean requireUploadFile;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requireUploadFile=" + requireUploadFile +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRequireUploadFile() {
        return requireUploadFile;
    }

    public void setRequireUploadFile(Boolean requireUploadFile) {
        this.requireUploadFile = requireUploadFile;
    }
}
