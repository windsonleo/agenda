package com.tecsoluction.agenda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractRestController;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;


@RestController
@RequestMapping(value = "paciente")
public class PacienteControllerRest extends AbstractRestController<Paciente> {

    private final PacienteServicoImpl userService;


    @Autowired
    public PacienteControllerRest(PacienteServicoImpl dao) {
        this.userService = dao;
    }

    @Override
    protected PacienteServicoImpl getservice() {
        // TODO Auto-generated method stub
        return userService;
    }
    
    @RequestMapping(value = "/listar/", method = RequestMethod.GET)
    public List<Paciente> listarPacientes() {

        return getservice().findAll();

    }


}
