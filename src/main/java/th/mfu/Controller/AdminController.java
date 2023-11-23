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

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/stocks")
    public String listStocks(Model model) {
        model.addAttribute("stocks", repository.findAll());
        return "list-stock";
    }
    @GetMapping("/add-stock")
    public String addStock(Model model) {
        model.addAttribute("stock", new Stock());
        return "add-edit-stock";
    }
    @PostMapping("/stocks")
    public String saveStock(@ModelAttribute Stock stock) {
        repository.save(stock);
        return "redirect:/stocks";
    }
    @GetMapping("/stocks/{id}")
    public String getStock(Model model, @PathVariable Long id) {
        Stock stock = repository.findById(id).get();
        model.addAttribute("stock", stock);
        return "add-edit-stock";
    }
    @GetMapping("/delete-stock/{id}")
    public String deleteStock(@PathVariable long id) {
        repository.deleteById(id);
        return "redirect:/stocks";
    }
    @GetMapping("/delete-stock")
    public String removeAllStocks() {
        repository.deleteAll();
        return "redirect:/stocks";
    }

}