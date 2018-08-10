package com.tecsoluction.agenda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tecsoluction.agenda.entidade.Evento;
import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractRestController;
import com.tecsoluction.agenda.servico.EventoServicoImpl;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;


@RestController
@RequestMapping(value = "evento")
public class EventoControllerRest extends AbstractRestController<Evento> {

    private final EventoServicoImpl userService;


    @Autowired
    public EventoControllerRest(EventoServicoImpl dao) {
        this.userService = dao;
    }

    @Override
    protected EventoServicoImpl getservice() {
        // TODO Auto-generated method stub
        return userService;
    }
    
    @RequestMapping(value = "/listar/", method = RequestMethod.GET)
    public List<Evento> listarEventos() {

        return getservice().findAll();

    }


}
