package com.releationcombined.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.releationcombined.Repo.TeacherRepo;
import com.releationcombined.entity.Teacher;

@RestController
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	TeacherRepo repo;
	
	@GetMapping("/")
	public List<Teacher> getdata(){
	    return repo.findAll();
	    
	}
	
	@PostMapping("/")
	public ResponseEntity<List<Teacher>> savedata(@RequestBody Teacher s) {
		repo.save(s);
		return new ResponseEntity("Post the data successfull... in Teacher block",HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<List<Teacher>> putdata(@RequestBody Teacher s){
		 repo.save(s);
		 return new ResponseEntity("Update the data successfull.. ",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Teacher>>deletedata(@PathVariable("id") int id) {
		 repo.deleteById(id);
		 return new ResponseEntity("Delete the data successfull.... in Teacher block..",HttpStatus.OK);
	}
}
