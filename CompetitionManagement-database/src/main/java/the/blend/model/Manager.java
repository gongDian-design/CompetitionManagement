package the.blend.model;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author: 钱曹宇
 * @date: 2020/5/29 11:00 下午
 * @description:
 */
@Entity
public class Manager {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String loginName;

    @Length(min = 10)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String competitionName;

    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Competition> holdCompetitions;

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", competitionName='" + competitionName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public Set<Competition> getHoldCompetitions() {
        return holdCompetitions;
    }

    public void setHoldCompetitions(Set<Competition> holdCompetitions) {
        this.holdCompetitions = holdCompetitions;
    }
}
