package the.blend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import the.blend.model.Competition;

/**
 * @author: 钱曹宇
 * @date: 2020/5/30 9:31 下午
 * @description:
 */
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
