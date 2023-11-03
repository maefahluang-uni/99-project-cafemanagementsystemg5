package th;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import th.mfu.Domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    
}
