import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.db.exception.RecordNotFoundException;
import com.h2.db.model.EmployeeEntity;
import com.h2.db.model.repository.EmployeeRepository;


@Service
public class StockService {
	
	@Autowired
	EmployeeRepository repository;
	
	public List<Admin> getAllEmployees()
	{
		System.out.println("getAllEmployees");
		List<Admin> result = (List<Admin>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	
	public Admin getAdminById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getAdminById");
		Optional<Admin> admin = repository.findById(id);
		
		if(admin.isPresent()) {
			return admin.get();
		} else {
			throw new RecordNotFoundException("No Item record exist for given id");
		}
	}
	
	public Admin createOrUpdateEmployee(Admin entity) 
	{
		System.out.println("createOrUpdateStock");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<Admin> employee = repository.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				Admin newEntity = employee.get();
				newEntity.setName(entity.getName());
				newEntity.setValue(entity.Value());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteAdminById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteAdminById");
		
		Optional<Admin> stockV = repository.findById(id);
		
		if(stockV.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Stock record exist for given id");
		}
	} 
}