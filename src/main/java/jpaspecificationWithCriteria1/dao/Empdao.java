package jpaspecificationWithCriteria1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import jpaspecificationWithCriteria1.entity.Employe;

@Repository
public class Empdao {

	@PersistenceContext
	private EntityManager em;
	

	public List<Employe> find(String f, String d) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employe> cq=cb.createQuery(Employe.class);
		
		Root<Employe> root=cq.from(Employe.class);
		
		Predicate firstnamepredicate=cb.equal(root.get("firstname"),f);
		Predicate departmentpredicate=cb.equal(root.get("department"), d);
		cq.where(firstnamepredicate , departmentpredicate );
		
		
		 TypedQuery<Employe> query=em.createQuery(cq);
		 
	return	query.getResultList();
	
	}


	public List<Employe> findbydeptor(String dept , String dept1) {
		// it will search where dept name is either dept or dept1 that means select all from employe where dept=dept1 or dept=dept2
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employe> cq=cb.createQuery(Employe.class);
		
		Root<Employe> root=cq.from(Employe.class);
		
		Predicate d1=cb.equal(root.get("department"),dept);
		Predicate d2=cb.equal(root.get("department"), dept1);
		Predicate finalpredicate=cb.or(d1,d2);
		cq.where(finalpredicate);
		TypedQuery<Employe> query=em.createQuery(cq);
		return	query.getResultList();
	}


	public List<Employe> findbylastnamelike(String lname) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employe> cq=cb.createQuery(Employe.class);
		Root<Employe> root=cq.from(Employe.class);
		Predicate d1=cb.like(root.get("lastname"),lname);

		cq.where(d1);
		TypedQuery<Employe> query=em.createQuery(cq);
		return	query.getResultList();
	}


	public List<Employe> selectdeptlnamefromemploye() {
		Session session=em.unwrap(Session.class);
		Criteria cr = session.createCriteria(Employe.class)
			    .setProjection(Projections.projectionList()
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("department"), "department"))
			    .setResultTransformer(Transformers.aliasToBean(Employe.class));

			  List<Employe> list = cr.list();
		
		return	list;
	}
	
}
