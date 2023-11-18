package th.mfu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import th.mfu.Domain.*;
import th.mfu.Repository.UserRepository;
import th.mfu.Service.*;
import java.util.*;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

     @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes attributes) {
        if ("Admin".equals(username) && "1234".equals(password)) {
            return "redirect:/admin-dashboard";
        } else if ("Barista".equals(username) && "1234".equals(password)) {
            return "redirect:/barista-dashboard";
        }
        
        attributes.addFlashAttribute("error", "Invalid username or password");
        return "redirect:/login";
    }
    @GetMapping("admin-dashboard")
    public String showAdminForm(){
        return "admin-dashboard";
    }
    @GetMapping("barista-dashboard")
    public String showBaristaForm(){
        return "barista-dashboard";
    }



    // @GetMapping("/view")
    // public String userShopping() {
    //     return "main";
    // }

    // @GetMapping("/admin")
    // public String showAdminDashboard() {
    //     return "admin-dashboard";
    // }

    // @GetMapping("/Hab")
    // public String hahh(Model model) {
    //     Admin admin = new Admin();
    //     admin.setName("hdfjjvgfdkhg");
    //     model.addAttribute("test", admin);
    //     return "Barista";
    // }

    // @GetMapping("/barista")
    // public String showBaristaDashboard() {
    //     return "barista-dashboard";
    // }
    }
