package com.tecsoluction.agenda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractRestController;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;


@RestController
@RequestMapping(value = "usuario")
public class UsuarioControllerRest extends AbstractRestController<Usuario> {

    private final UsuarioServicoImpl userService;


    @Autowired
    public UsuarioControllerRest(UsuarioServicoImpl dao) {
        this.userService = dao;
    }

    @Override
    protected UsuarioServicoImpl getservice() {
        // TODO Auto-generated method stub
        return userService;
    }
    
    @RequestMapping(value = "/listar/", method = RequestMethod.GET)
    public List<Usuario> listarCategoriaPai() {

        return getservice().findAll();

    }


}
