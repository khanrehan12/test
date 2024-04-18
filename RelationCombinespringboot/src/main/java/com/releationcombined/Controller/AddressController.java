package com.releationcombined.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.releationcombined.Repo.AddmissionRepo;
import com.releationcombined.Repo.AddressRepo;
import com.releationcombined.Repo.StudentRepo;
import com.releationcombined.entity.Addmission;
import com.releationcombined.entity.Address;
import com.releationcombined.entity.Student;

@RestController
@RequestMapping("/address")

public class AddressController {

	
	@Autowired
	AddressRepo repo;
	
	@Autowired
	StudentRepo studentrepo;
	
	
	@GetMapping("/")
	public List<Address> getdata(){
	    return repo.findAll();
	    
	}
	
	@PostMapping("/")
	public ResponseEntity<List<Address>> savedata(@RequestBody Address s) {
		repo.save(s);
		return new ResponseEntity("Post the data successfull....  address block",HttpStatus.ACCEPTED);
	}
	
	@PutMapping
	public ResponseEntity<List<Address>> putdata(@RequestBody Address s){
	    repo.save(s);
		return new ResponseEntity("Update the data successfull....  address block",HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/{id}")
	public void deletedata(@PathVariable("id") int id) {
		
		List<Student> studentList = studentrepo.findAll();
		for(Student st:studentList) {
			List<Address> addressList = st.getAddress();
			List<Address> addressListnew= new ArrayList<Address>();
			for(Address ad : addressList) {
				if(ad.getId()==id) {
					
				}else {
					addressListnew.add(ad);
				}
			}
			st.setAddress(addressListnew);
			studentrepo.save(st);
		}
		 repo.deleteById(id);
		// return new ResponseEntity("Delete the data successfull....  address block",HttpStatus.ACCEPTED);
	}
}




