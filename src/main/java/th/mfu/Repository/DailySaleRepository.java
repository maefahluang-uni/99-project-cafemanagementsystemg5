package th.mfu.Repository;

import th.mfu.Domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailySaleRepository extends CrudRepository<DailySale, Long> {

}
