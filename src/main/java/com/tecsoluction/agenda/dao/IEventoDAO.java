package com.tecsoluction.agenda.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsoluction.agenda.entidade.Evento;

@Repository
public interface IEventoDAO extends JpaRepository<Evento, UUID> {
	
//    @Query("SELECT p FROM Atividade p where p.novo='TRUE'")
//    List<Atividade> findAllNew();
	

}
