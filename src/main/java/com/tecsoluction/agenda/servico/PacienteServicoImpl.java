package com.tecsoluction.agenda.servico;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsoluction.agenda.dao.IPacienteDAO;
import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.framework.AbstractEntityService;


/*  criar validacaoes para que o servico as chamem caso nao haja erros execute a acao  */


@Service("pacienteService")
@Transactional
//@PersistenceContext
public class PacienteServicoImpl extends AbstractEntityService<Paciente> {


    @Autowired
    private IPacienteDAO dao;


    public PacienteServicoImpl() {

        super(Paciente.class, "paciente");


    }
    
    @Override
    public Paciente save(Paciente user) {

//		user.setRoles(new HashSet<>());
//		userRepository.save(user);
        dao.saveAndFlush(user);

        return user;

    }


//    public Paciente findByEmail(String email) {
//
//        return dao.findByEmail(email);
//    }


    @Override
    protected JpaRepository<Paciente, UUID> getDao() {

        return dao;
    }


    @Override
    protected void validateSave(Paciente post) {
        // TODO Auto-generated method stub

    }

    @Override
    protected String getIdEntity(Paciente paciente) {
        return paciente.getId().toString();
    }


    @Override
    protected void validateEdit(Paciente post) {
        // TODO Auto-generated method stub

    }


    @Override
    protected void validateDelete(UUID id) {
        // TODO Auto-generated method stub

    }


}
