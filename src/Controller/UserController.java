import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
    
        
    @Autowired
    AdminRepository adminrepo;
    @Autowired
    MenuRepository menurepo;
    @Autowired
    CustomerRepository cusrepo;

    public  UserController(AdminRepository adminrepo,MenuRepository menurepo,CustomerRepository cusrepo){
        this.adminrepo = repository;
        this.menurepo = menuRepository;
        this.cusrepo = cusRepository;
    }
    @GetMapping("/")
    public String AddMenu(Model model){
        model.addAttribute("addMenu",new Menu());
        return "add-menu";
    }


    @GetMapping("carts")
    public String AddToCart(Model model){
        model.addAttributes("addcart",new Cart());
        return "cart-cus";
    }

    @PostMapping("carts")
    public String saveCart(@ModelAttribute Cart addcart){
        cusrepo.save(addcart);
        return "redirect:/carts";

    }
    @Transactional
	@RequestMapping(path = "/delete/{id}")
    public String deleteItemById(Model model, @PathVariable("id") Long id)
    throws RecordNotFoundException 
    {
        System.out.println("deleteItemById" + id);
		
		service.deleteItemById(id);
		return "redirect:/carts";

    }
    
}
