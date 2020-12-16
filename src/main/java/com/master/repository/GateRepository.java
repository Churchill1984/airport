package com.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.master.model.Gate;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long>{

}
