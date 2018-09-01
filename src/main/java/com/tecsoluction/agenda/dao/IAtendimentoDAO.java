package com.tecsoluction.agenda.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecsoluction.agenda.entidade.Atendimento;
import com.tecsoluction.agenda.entidade.Atividade;

@Repository
public interface IAtendimentoDAO extends JpaRepository<Atendimento, UUID> {
	
//    @Query("SELECT p FROM Atividade p where p.novo='TRUE'")
//    List<Atividade> findAllNew();
	

}
