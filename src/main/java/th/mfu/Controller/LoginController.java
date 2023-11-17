// package th.mfu.Controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;

// import th.mfu.Domain.*;
// import th.mfu.Service.*;
// import java.util.*;


// @Controller
// public class LoginController {
//     @GetMapping("/login")
//     public String showLoginForm() {
//         return "login";
//     }

//     @GetMapping("/view")
//     public String userShopping() {
//         return "main";
//     }

//     @GetMapping("/admin")
//     public String showAdminDashboard() {
//         return "admin-dashboard";
//     }

//     @GetMapping("/Hab")
//     public String hahh(Model model) {
//         Admin admin = new Admin();
//         admin.setName("hdfjjvgfdkhg");
//         model.addAttribute("test", admin);
//         return "Barista";
//     }

//     @GetMapping("/barista")
//     public String showBaristaDashboard() {
//         return "barista-dashboard";
//     }
// }
