package com.tecsoluction.agenda.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsoluction.agenda.entidade.Paciente;

@Repository
public interface IPacienteDAO extends JpaRepository<Paciente, UUID> {


//	@Query("SELECT p FROM Usuario p where p.username=")
//    Usuario findByEmail(String email);

}
