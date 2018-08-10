package com.tecsoluction.agenda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tecsoluction.agenda.entidade.Atividade;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractRestController;
import com.tecsoluction.agenda.servico.AtividadeServicoImpl;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;


@RestController
@RequestMapping(value = "atividade")
public class AtividadeControllerRest extends AbstractRestController<Atividade> {

    private final AtividadeServicoImpl userService;


    @Autowired
    public AtividadeControllerRest(AtividadeServicoImpl dao) {
        this.userService = dao;
    }

    @Override
    protected AtividadeServicoImpl getservice() {
        // TODO Auto-generated method stub
        return userService;
    }
    
    @RequestMapping(value = "/listar/", method = RequestMethod.GET)
    public List<Atividade> listarAtividades() {

        return getservice().findAll();

    }


}
