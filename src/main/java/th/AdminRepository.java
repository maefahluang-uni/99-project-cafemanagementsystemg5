package th;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.Domain.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>{
    public List<Admin> findByConcertId(Long concertId);
    public List<Admin> deleteByConcertId(long id);
    public List<Admin> findByBookedFalseAndConcertId(Long concertId);
    public List<Admin> findByBookedTrueAndConcertId(Long concertId);
    public List<Admin> findByBookedTrue();
}

    