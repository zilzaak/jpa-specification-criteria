package com.hrms.pervez;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PervezEmpEducationrepo extends  JpaRepository<Educationn, Long> , PagingAndSortingRepository<Educationn,Long> {


    List<Educationn> findByCode(String code);

    @Query(value = "select * from educationn ",nativeQuery = true)
    Page<Educationn> findAllName(Pageable pageable);

}
