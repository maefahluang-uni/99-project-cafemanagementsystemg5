package th.mfu.Repository;

import th.mfu.Domain.*;
import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {}
