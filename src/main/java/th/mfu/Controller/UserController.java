package th.mfu.Controller;

import th.mfu.Domain.*;
import th.mfu.Service.*;
import java.util.*;

import javax.transaction.Transactional;

import th.mfu.Controller.*;
import th.mfu.Repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    AdminRepository adminrepo;
    
    @Autowired
    OrderRepository menurepo;

    @Autowired
    CustomerRepository cusrepo;
    
    public UserController(AdminRepository adminrepo, OrderRepository menurepo, CustomerRepository cusrepo) {
        this.adminrepo = adminrepo;
        this.menurepo = menurepo;
        this.cusrepo = cusrepo;
    }

    @GetMapping("/view")
    public String userShopping() {
        return "main";
    }
    @GetMapping("/addmenu")
    public String AddMenu(Model model){
        model.addAttribute("addMenu", AddMenu(model));
        return "main";
    }
    //  @GetMapping("carts")
    //  public String AddToCart(Model model){
    //      model.addAttributes("addcart",new Cart());
    //      return "main";
    //  }
    //  @PostMapping("carts")
    //  public String saveCart(@ModelAttribute Cart addcart){
    //      cusrepo.save(addcart);
    //      return "redirect:/main";
    //  }
    //  @Transactional
	//  @RequestMapping(path = "/delete/{id}")
    //  public String deleteItemById(Model model, @PathVariable("id") Long id)
    //  throws RecordNotFoundException 
    //  {
    //      System.out.println("deleteItemById" + id);
	//  	service.deleteItemById(id);
	//  	return "redirect:/main";
    //  }
    
}
