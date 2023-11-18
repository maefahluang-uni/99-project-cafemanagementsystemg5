package th.mfu.Controller;



import th.mfu.Domain.*;
import th.mfu.Repository.*;
import th.mfu.Service.*;
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
public class BaristaController {
    @Autowired
    BaristaRepository repository;


    @GetMapping("/barista-page")
    public String baristapage(Model model){
        model.addAttribute("order", repository.findAll());
        return "Barista";
    }
    


}
