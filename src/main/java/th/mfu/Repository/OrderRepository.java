package th.mfu.Repository;

import th.mfu.Domain.*;
import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Customer,Long> {}
