package dzone.springboot.mysql.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends CrudRepository<dzone.springboot.mysql.model.System, Long> {

}
