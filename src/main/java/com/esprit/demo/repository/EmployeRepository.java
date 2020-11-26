package com.esprit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {

	@Query(value="select * from t_employe", nativeQuery = true)
	List<Employe> getByPrenomJPQL();
	
	@Query(value="select count(*) from t_employe", nativeQuery = true)
	long getCount();
}
