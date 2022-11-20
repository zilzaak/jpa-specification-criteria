package com.hrms.pervez.JpaSpecificationexample;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleRepository extends CrudRepository<Apple, Long>, JpaSpecificationExecutor {

}