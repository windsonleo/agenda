package com.tecsoluction.agenda.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsoluction.agenda.entidade.Patologia;


@Repository
public interface IPatologiaDAO extends JpaRepository<Patologia, UUID> {
	
//    @Query("SELECT p FROM Atividade p where p.novo='TRUE'")
//    List<Atividade> findAllNew();
	

}
