package th.mfu.Controller;

import java.text.SimpleDateFormat;
import java.util.*;
import th.mfu.Domain.*;
import th.mfu.Service.*;
import th.mfu.Repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    
    @Autowired
    StockRepository repository;
    private AdminService dailySalesService;

    
    public AdminController(StockRepository repository) {
        this.repository = repository;
    }

    //TODO: add initBinder for date format
    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/stocks")
    public String listStocks(Model model) {
        // TODO: list all concerts
        model.addAttribute("stocks", repository.findAll());
        // TODO: return a template to list concerts
        return "list-stock";
    }

   

    @GetMapping("/add-stock")
    public String addStock(Model model) {
        // TODO: pass blank concert to a form
        model.addAttribute("stock", new Stock());
        // TODO: return a template for concert form
        return "add-edit-stock";
    }

    @PostMapping("/stocks")
    public String saveStock(@ModelAttribute Stock stock) {
        // TODO: add concert to DB
        repository.save(stock);
        // TODO: redirect to list concerts
        return "redirect:/stocks";
    }

    @GetMapping("/stocks/{id}")
    public String getStock(Model model, @PathVariable Long id) {
        //TODO: find concert by id
        Stock stock = repository.findById(id).get();
        // TODO: list all concerts
        model.addAttribute("stock", stock);
        // TODO: return a template for concert form
        return "add-edit-stock";
    }


    @GetMapping("/delete-stock/{id}")
    public String deleteStock(@PathVariable long id) {
        // TODO: delete concert from DB
        repository.deleteById(id);
        // TODO: redirect to list concerts
        return "redirect:/stocks";
    }

    
    @GetMapping("/delete-stock")
    public String removeAllStocks() {
        // delete all employees 
        repository.deleteAll();
        return "redirect:/stocks";
    }

    
    // Endpoint สำหรับดึงข้อมูลยอดขายประจำวัน
    @GetMapping("/get-daily-total-sales")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getDailyTotalSales() {
        // ตรวจสอบสิทธิ์ของ Admin ที่เข้าถึงข้อมูล
        // (ตรวจสอบ session, token หรือวิธีการตรวจสอบอื่น ๆ ที่คุณใช้)

        // ดึงข้อมูลยอดขายประจำวันจาก DailySalesService
        int dailyTotalSales = dailySalesService.calculateDailyTotalSales();

        // สร้าง Map เพื่อส่งข้อมูลกลับไปยัง Admin
        Map<String, Object> response = new HashMap<>();
        response.put("totalSales", dailyTotalSales);

        // ส่ง ResponseEntity กลับไปยัง Admin พร้อมกับข้อมูล
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update-daily-total-sales")
    public ResponseEntity<String> updateDailyTotalSales(@RequestBody Dailytotalsale dailySalesData) {
        // นำข้อมูลที่ได้จาก Barista มาใช้
        // สามารถเพิ่มโค้ดที่จะทำอะไรกับข้อมูลได้ตามต้องการ
        return ResponseEntity.ok("Daily total sales updated successfully.");
    }

}