package th.mfu.Repository;

import th.mfu.Domain.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaristaRepository extends JpaRepository<Barista, Long> {

    // เมทอดที่ใช้ในการค้นหา Barista จาก ID
    Barista findById(long id);

    // เมทอดที่ใช้ในการค้นหา Barista จาก password
    Barista findByPassword(Integer password);

    // เมทอดที่ใช้ในการค้นหา Barista ทั้งหมด
    List<Barista> findAll();

    // เมทอดที่ใช้ในการบันทึก Barista ลงในฐานข้อมูล
    Barista save(Barista barista);

    // เมทอดที่ใช้ในการลบ Barista จากฐานข้อมูล
    void deleteById(long id);

    // เมทอดอื่นๆ ตามความต้องการของโปรเจค
}
