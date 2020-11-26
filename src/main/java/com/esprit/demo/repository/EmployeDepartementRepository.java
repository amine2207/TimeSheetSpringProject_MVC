package com.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Departement;
import com.esprit.demo.entity.Employe;

@Repository
public interface EmployeDepartementRepository extends JpaRepository<Departement,Employe> {

}
