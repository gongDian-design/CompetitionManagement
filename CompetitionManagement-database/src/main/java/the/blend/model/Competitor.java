package the.blend.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * @author: 钱曹宇
 * @date: 2020/5/29 11:10 下午
 * @description:
 */
@Entity
public class Competitor {
    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false)
    @Length(max = 8, min = 8)
    private String studentNo;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(2) check gender in ('男','保密','女')")
    private String gender;

    private String school;

    private String university;

    @Column(nullable = false)
    @Length(min = 11, max = 11)
    private String phoneNo;

    @Column(nullable = false)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "group_id")
    private Group group;

    @Override
    public String toString() {
        return "Competitor{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", school='" + school + '\'' +
                ", university='" + university + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
