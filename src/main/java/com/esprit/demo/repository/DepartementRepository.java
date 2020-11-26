package com.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
	
}

