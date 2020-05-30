package the.blend.model;

import javax.persistence.*;

/**
 * @author: 钱曹宇
 * @date: 2020/5/30 5:09 下午
 * @description:
 */
@Entity
public class GroupRecord {
    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "record_id")
    private UploadRecord record;

    @Override
    public String toString() {
        return "GroupRecord{" +
                "id=" + id +
                ", group=" + group +
                ", record=" + record +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public UploadRecord getRecord() {
        return record;
    }

    public void setRecord(UploadRecord record) {
        this.record = record;
    }
}
