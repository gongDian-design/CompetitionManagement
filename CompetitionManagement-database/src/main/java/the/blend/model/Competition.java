package the.blend.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author: 钱曹宇
 * @date: 2020/5/29 11:12 下午
 * @description:
 */
@Entity
public class Competition {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String information;

    @Size(max = 4, min = 4)
    @Column(nullable = false)
    private String year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id", referencedColumnName = "id")
    private SignForm signForm;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(nullable = false)
    private Manager manager;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "competition")
    private Set<Notice> notice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "competition")
    private Set<Stage> nowStage;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "competition")
    private Set<Group> groups;

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", information='" + information + '\'' +
                ", year='" + year + '\'' +
                ", signForm=" + signForm +
                ", manager=" + manager +
                ", notice=" + notice +
                ", nowStage=" + nowStage +
                ", groups=" + groups +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public SignForm getSignForm() {
        return signForm;
    }

    public void setSignForm(SignForm signForm) {
        this.signForm = signForm;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Notice> getNotice() {
        return notice;
    }

    public void setNotice(Set<Notice> notice) {
        this.notice = notice;
    }

    public Set<Stage> getNowStage() {
        return nowStage;
    }

    public void setNowStage(Set<Stage> nowStage) {
        this.nowStage = nowStage;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
