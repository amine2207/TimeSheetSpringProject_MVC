package com.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Entreprise;
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	
}
