
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MoelAttributed;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.Domain.Stock;
import th.mfu.domain.Admin;
import RecordNotFoundException;
import StockService;
import AdminRepository;


@Controller
@RequestMapping("/")
public class AdminController 
{
	
	@Autowired
	StockService service;

	@RequestMapping
	public String getAllItem(Model model) 
	{	
		System.out.println("getAllItem");
		
		List<Admin> list = service.getAllItem();

		model.addAttribute("Item", list);
		
		return "list-Item";
	}

	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editStockById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("editAdminById" + id);
		if (id.isPresent()) {
			Admin entity = service.getAdminById(id.get());
			model.addAttribute("Item", entity);
		} else {
			model.addAttribute("Item", new Admin());
		}
		
		
		return "add-edit-admin";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteItemById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("deleteItemById" + id);
		
		service.deleteItemById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createAdmin", method = RequestMethod.POST)
	public String createOrUpdateItem(Admin item) 
	{
		System.out.println("createOrUpdateAdmin ");
		
		service.createOrUpdateItem(item);
		
		return "redirect:/";
	}
}
