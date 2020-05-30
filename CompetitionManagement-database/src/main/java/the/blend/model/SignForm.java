package the.blend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author: 钱曹宇
 * @date: 2020/5/29 11:12 下午
 * @description:
 */
@Entity
public class SignForm {
    @Id
    @GeneratedValue
    private Long id;

    private int maxPeople;

    @Min(1)
    @Column(columnDefinition = "int default 1")
    private int minPeople;

    @Column(nullable = false)
    private Boolean requireGroupName;

    @Override
    public String toString() {
        return "SignForm{" +
                "id=" + id +
                ", maxPeople=" + maxPeople +
                ", minPeople=" + minPeople +
                ", requireGroupName=" + requireGroupName +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(int minPeople) {
        this.minPeople = minPeople;
    }

    public Boolean getRequireGroupName() {
        return requireGroupName;
    }

    public void setRequireGroupName(Boolean requireGroupName) {
        this.requireGroupName = requireGroupName;
    }
}
