package th.mfu.Repository;

import th.mfu.Domain.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaristaRepository extends JpaRepository<Barista, Long> {
    Barista findById(long id);
    Barista findByPassword(Integer password);
    List<Barista> findAll();
    Barista save(Barista barista);
    void deleteById(long id);
}
