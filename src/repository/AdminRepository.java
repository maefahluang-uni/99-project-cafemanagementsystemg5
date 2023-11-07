package th;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h2.db.model.EmployeeEntity;


@Repository
public interface AdminRepository 
			extends CrudRepository<AdminEntity, Long> {

}
  