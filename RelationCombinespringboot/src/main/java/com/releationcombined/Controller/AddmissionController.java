package com.releationcombined.Controller;

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
import com.releationcombined.entity.Addmission;


@RestController
@RequestMapping("/addmission")

public class AddmissionController {
	@Autowired
	AddmissionRepo repo;
	
	@GetMapping("/")
	public List<Addmission> getdata(){
	    return repo.findAll();
	    
	}
	
	@PostMapping("/")
	
	public ResponseEntity<String> savedata(@RequestBody Addmission a){
		
		if(a.getFee()<5000)
		{
		return new ResponseEntity<String>("Amount is low ",HttpStatus.BAD_REQUEST);
		}else {
			repo.save(a);
			return new  ResponseEntity<String>("Amount is Okay ",HttpStatus.OK);
		}
		
	}
//	public void savedata(@RequestBody Addmission s) {
//		repo.save(s);
//	}
	
	
	
	@PutMapping
	public ResponseEntity<List<Addmission>> putdata(@RequestBody Addmission s){
	 repo.save(s);
	 return new ResponseEntity("Successfull update..,",HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletedata(@PathVariable("id") int id) {
		 repo.deleteById(id);
		 System.out.println("Delete the data successfull.... addmission");
	}
}
