package jpaspecificationWithCriteria1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jpaspecificationWithCriteria1.entity.Employe;
import jpaspecificationWithCriteria1.service.CustomService;

@RestController
@RequestMapping("/custom")
public class Employecontroller2 {

	@Autowired
	CustomService srvc;
	
	
@GetMapping(value="/fbyfnamedept/{fname}/{dept}")
public ResponseEntity<List<Employe>> getabyfnameanddept(@PathVariable String fname , @PathVariable String dept){

	return new ResponseEntity<List<Employe>>(srvc.find(fname,dept),HttpStatus.OK);
}
	
	

@GetMapping(value="/findbylastnamelike/{lname}")
public ResponseEntity<List<Employe>> findbylnamelike(@PathVariable String lname){

	return new ResponseEntity<List<Employe>>(srvc.findbylastnamelike(lname),HttpStatus.OK);
}


@GetMapping(value="/findbydeptor/{dept}/{dept1}")
public ResponseEntity<List<Employe>> findbydeptor(@PathVariable String dept,@PathVariable String dept1){

	return new ResponseEntity<List<Employe>>(srvc.findbydeptor(dept, dept1),HttpStatus.OK);
}

@GetMapping(value="/selectdeptlastname")
public ResponseEntity<List<Employe>> selectdeptlnamefromemploye(){

	return new ResponseEntity<List<Employe>>(srvc.selectdeptlnamefromemploye(),HttpStatus.OK);
}


	
}
