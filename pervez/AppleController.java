package com.hrms.pervez;


import com.hrms.pervez.JpaSpecificationexample.Apple;
import com.hrms.pervez.JpaSpecificationexample.AppleRepository;
import com.hrms.pervez.JpaSpecificationexample.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping(value="/apple")
public class AppleController {
    @Autowired
    private AppleService appleService;

    @Autowired
    private AppleRepository arr;

    @GetMapping("/")
    ResponseEntity<List<Apple>> projection() {
        List<Apple> lst = appleService.getAllSpecification("Fuji", Arrays.asList("sweet", "tangy"), 1.1f, 4.4f);
return new ResponseEntity<List<Apple>>(lst, HttpStatus.OK);
    }


    @PostMapping("/add")
    ResponseEntity<Apple> addapple(@RequestBody Apple a) {
       arr.save(a);
        return new ResponseEntity<Apple>(a , HttpStatus.OK);
    }


    @PostMapping("/findbyname")
    ResponseEntity<List<Apple>> namelike(@RequestBody Apple ap) {
        List<Apple> lst = appleService.getAppleNameLike(ap.getAppleName());
        return new ResponseEntity<List<Apple>>(lst, HttpStatus.OK);
    }

    @GetMapping("/findbyprice/{price1}/{price2}")
    ResponseEntity<List<Apple>> bypricebetween(@PathVariable float price1, @PathVariable float price2) {
        List<Apple> lst = appleService.getApplepricebetween(price1,price2);
        return new ResponseEntity<List<Apple>>(lst, HttpStatus.OK);
    }



}