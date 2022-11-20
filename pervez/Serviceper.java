package com.hrms.pervez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service@Transactional
public class Serviceper {

    @Autowired
    private Daoper dao;

    public List<Educationn> selectnameaddress(int x,int y) {
        // TODO Auto-generated method stub
        return dao.selectdeptlnamefromemploye( x,y);
    }





}
