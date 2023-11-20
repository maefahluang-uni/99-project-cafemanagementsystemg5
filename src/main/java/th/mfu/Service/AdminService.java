package th.mfu.Service;

import org.springframework.stereotype.Service;

import th.mfu.Domain.*;
import th.mfu.Controller.*;


@Service
public class AdminService {

    public void processDailySales(Dailytotalsale dailySalesData) {
        // ทำการประมวลผลข้อมูลที่ได้รับจาก Barista
        // เช่น บันทึกลงฐานข้อมูลหรือทำการแจ้งเตือน
        // ในที่นี้เราสมมติว่ามีการล็อกข้อมูลลง console
        System.out.println("Received daily sales data: " + dailySalesData);
    }

    public int calculateDailyTotalSales() {
        return 0;
    }
}
