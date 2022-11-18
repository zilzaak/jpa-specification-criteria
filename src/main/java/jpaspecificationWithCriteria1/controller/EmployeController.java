package jpaspecificationWithCriteria1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpaspecificationWithCriteria1.entity.Employe;
import jpaspecificationWithCriteria1.repository.EmployeRepository;

@RestController
@RequestMapping("/employe")
public class EmployeController {

	@Autowired
	private EmployeRepository emprepo;
	
	
	@PostMapping("/create")
	ResponseEntity<?> create(@RequestBody Employe emp){
		emprepo.save(emp);
		Map<String,Object> response=new HashMap<>();
		response.put("employe", emp);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<?> getbyId(@PathVariable Long id){
		
		Map<String,Object> response=new HashMap<>();
		response.put("employe",emprepo.findById(id).get());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	ResponseEntity<?> update(@RequestBody Employe emp){
	
		Map<String,Object> response=new HashMap<>();
		response.put("employelist", emprepo.save(emp));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}	
	
	@GetMapping("/all")
	ResponseEntity<?> all(){
	
		Map<String,Object> response=new HashMap<>();
		response.put("employelist", emprepo.findAll());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}	
	
	
@GetMapping("/fnameanddept/{fname}/{dept}")
public ResponseEntity<?> getabyfnameanddept(@PathVariable String fname , @PathVariable String dept){
	try {
	List<Employe> lst=emprepo.findByFirstnameAndDepartment(fname, dept);
	return new ResponseEntity<>(lst,HttpStatus.OK);
	}catch(Exception e){
		
		return new ResponseEntity<>("user with these id not found",HttpStatus.NOT_FOUND);
	}finally {
		
		return new ResponseEntity<>("list size is  null",HttpStatus.NOT_FOUND);
	}
	
}
	
}
