package th.mfu.Repository;

import th.mfu.Domain.*;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    // Define any custom query methods you may need here
}
