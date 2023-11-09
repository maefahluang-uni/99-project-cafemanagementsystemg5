
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h2.db.exception.RecordNotFoundException;
import com.h2.db.model.EmployeeEntity;
import com.h2.db.service.EmployeeService;

@Controller
@RequestMapping("/")
public class AdminController 
{
	@Autowired
	EmployeeService service;

	@RequestMapping
	public String getAllItem(Model model) 
	{	
		System.out.println("getAllItem");
		
		List<EmployeeEntity> list = service.getAllItem();

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
