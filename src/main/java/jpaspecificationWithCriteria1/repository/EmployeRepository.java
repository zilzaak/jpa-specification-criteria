package jpaspecificationWithCriteria1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jpaspecificationWithCriteria1.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long>{
	
	List<Employe> findByFirstnameAndDepartment(String f,String d);

}
