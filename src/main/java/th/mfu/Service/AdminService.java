package th.mfu.Service;

import org.springframework.stereotype.Service;

import th.mfu.Domain.*;
import th.mfu.Controller.*;


@Service
public class AdminService {

    public void processDailySales(DailySale dailySalesData) {
       
        System.out.println("Received daily sales data: " + dailySalesData);
    }

    public int calculateDailyTotalSales() {
        return 0;
    }
}
