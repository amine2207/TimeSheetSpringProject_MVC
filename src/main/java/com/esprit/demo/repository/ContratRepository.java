package com.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {

}
