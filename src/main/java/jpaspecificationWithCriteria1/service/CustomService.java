package jpaspecificationWithCriteria1.service;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpaspecificationWithCriteria1.dao.Empdao;
import jpaspecificationWithCriteria1.entity.Employe;


@Service
@Transactional
public class CustomService {

	@Autowired
	private Empdao dao;
     
     
public List<Employe> find(String f, String d){
	
	return dao.find(f, d);
}


public List<Employe> findbylastnamelike(String lname) {
	// TODO Auto-generated method stub
	return dao.findbylastnamelike(lname);
}

public List<Employe> findbydeptor(String dept , String dept1) {
	// it will search where dept name is either dept or dept1 that means select all from employe where dept=dept1 or dept=dept2
	
	return	dao.findbydeptor(dept, dept1);
}


public List<Employe> selectdeptlnamefromemploye() {
	// TODO Auto-generated method stub
	return dao.selectdeptlnamefromemploye();
}



}
