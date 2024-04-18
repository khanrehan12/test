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

import com.releationcombined.Repo.StudentRepo;
import com.releationcombined.entity.Student;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@GetMapping("/")
	public List<Student> getdata(){
	    return repo.findAll();
	    
	}
	
	@PostMapping("/")
	public ResponseEntity<String> savedata(@RequestBody Student s) {
		repo.save(s);
		return new ResponseEntity<String>("Post the data successfull... student block",HttpStatus.OK); 
	}
	
	@PutMapping
	public ResponseEntity<String> putdata(@RequestBody Student s){
		repo.save(s);
		return new ResponseEntity<String>("Update the data successfull... student block",HttpStatus.OK); 
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedata(@PathVariable("id") int id) {
		 repo.deleteById(id);
		 return new ResponseEntity<String>("Delete the data successfull....  student block",HttpStatus.OK);
	}

}
