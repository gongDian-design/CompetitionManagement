package the.blend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import the.blend.dao.CompetitionRepository;
import the.blend.dao.ManagerRepository;
import the.blend.model.Competition;
import the.blend.model.Manager;
import the.blend.model.SignForm;

import java.util.Set;

/**
 * @author: 钱曹宇
 * @date: 2020/5/30 5:15 下午
 * @description:
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class DatabaseGenerateTest {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Test
    public void createTest() {
    }

    @Test
    @Rollback()
    public void createManager() {
        Manager manager = new Manager();
        manager.setCompetitionName("name");
        manager.setLoginName("name");
        manager.setPassword("password");

        managerRepository.save(manager);
    }

    @Test
    @Rollback()
    public void createCompetition() {
        Manager manager = managerRepository.findAll().get(0);

        SignForm signForm = new SignForm();
        signForm.setMaxPeople(4);
        signForm.setMinPeople(1);
        signForm.setRequireGroupName(true);

        Competition competition = new Competition();
        competition.setInformation("info");
        competition.setYear("2019");
        competition.setSignForm(signForm);
        competition.setManager(manager);

        competitionRepository.save(competition);
    }

    @Test
    @Rollback
    public void checkCompetition() {
        createManager();
        createCompetition();

        Manager manager = managerRepository.findAll().get(0);

        Set<Competition> holdCompetition = manager.getHoldCompetitions();

        System.out.println(holdCompetition);
    }
}
