package the.blend.dao;

import the.blend.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 钱曹宇
 * @date: 2020/5/30 5:32 下午
 * @description:
 */
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
