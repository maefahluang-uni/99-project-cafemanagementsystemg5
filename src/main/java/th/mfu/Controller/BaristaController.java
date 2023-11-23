package th.mfu.Controller;

import th.mfu.Domain.*;
import th.mfu.Repository.*;
import th.mfu.Service.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BaristaController {

    @Autowired
    private DailySaleRepository repository;

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @GetMapping("/dailysale")
    public String showDailySales(Model model) {
    List<DailySale> dailySales = (List<DailySale>) repository.findAll();
    model.addAttribute("dailysales", dailySales); 
    return "senddaily"; 
    }
    @GetMapping ("add-dailysale")
    public String addDaily(Model model){
        model.addAttribute("daily", new DailySale());
        return "edit-senddaily";
    }
    @PostMapping("/dailysale")
    public String saveDaily(@ModelAttribute DailySale daily){
        repository.save(daily);
        return "redirect:/dailysale";
    }
    @GetMapping("/dailysale/{id}")
    public String getDaily(Model model,@PathVariable Long id){
        DailySale daily = repository.findById(id).get();
        model.addAttribute("daily", daily);
        return "edit-senddaily"; 
    }
     @GetMapping("/dailysale/{id}/edit")
    public String editDaily(Model model, @PathVariable Long id) {
    DailySale daily = repository.findById(id).orElse(null);
    model.addAttribute("daily", daily);
    return "edit-senddaily";
}
    @PostMapping("/dailysale/{id}/edit")
    public String updateDaily(@PathVariable Long id, @ModelAttribute DailySale daily) {
    DailySale existingDaily = repository.findById(id).orElse(null);
    if (existingDaily != null) {
        existingDaily.setName(daily.getName());
        existingDaily.setValue(daily.getValue());
        existingDaily.setDate(daily.getDate());
        repository.save(existingDaily);
    }
    return "redirect:/dailysale";
}
}
