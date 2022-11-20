package com.hrms.pervez;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class Daoper {
    @PersistenceContext
    private EntityManager em;


    public List<Educationn> selectdeptlnamefromemploye(int x,int y) {
        Session session=em.unwrap(Session.class);
        Criteria cr = session.createCriteria(Educationn.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("name"), "name")
                        .add(Projections.property("address"), "address"))
                .setResultTransformer(Transformers.aliasToBean(Educationn.class));

        List<Educationn> list = cr.list();

        return	list;
    }
}
