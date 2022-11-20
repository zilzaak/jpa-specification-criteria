package com.hrms.pervez;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/pervez")
public class EducationController {
    @Autowired
    private Serviceper srvc;

@Autowired
private PervezEmpEducationrepo repo;

    @PostMapping("/create")
    public  ResponseEntity<Educationn> createedu(@RequestBody Educationn empEducation){
       repo.save(empEducation);
return  new ResponseEntity<Educationn>(empEducation , HttpStatus.OK);
   }



    @PutMapping("/update")
    public  ResponseEntity<Educationn> updateemp(@RequestBody Educationn empEducation){
        repo.save(empEducation);
      return new ResponseEntity<Educationn>(empEducation , HttpStatus.OK);

  }







    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteemp(@PathVariable Long id){
        try{

            Educationn emp=repo.findById(id).get();
           repo.delete(emp);
            return new ResponseEntity<>("successfully deleted" , HttpStatus.OK);

        }catch(Exception e){

            return new ResponseEntity<>("the record is not found" , HttpStatus.NOT_FOUND);
        }
        finally{
            return new ResponseEntity<>("the given value is not long type" , HttpStatus.BAD_REQUEST);
        }
    }






    @GetMapping("/findbycode/{code}")
    public  ResponseEntity<List<Educationn>> findemp(@PathVariable String code){


            List<Educationn> list=repo.findByCode(code);


            return new ResponseEntity<List<Educationn>>(list , HttpStatus.OK);


    }



   @GetMapping("/all")
    public  ResponseEntity<List<Educationn> > findempall(){

        List<Educationn> results=srvc.selectnameaddress(5,1);



return new ResponseEntity<List<Educationn>>(results ,HttpStatus.OK );


    }


}
