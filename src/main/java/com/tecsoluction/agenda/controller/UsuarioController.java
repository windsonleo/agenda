package com.tecsoluction.agenda.controller;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tecsoluction.agenda.entidade.Role;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.RoleServicoImpl;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;





@Controller
@RequestMapping("usuario/")
public class UsuarioController extends AbstractController<Usuario> {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	
	 private final RoleServicoImpl roleservico;
	 
	 private final UsuarioServicoImpl ususervice;
	 
	
	
    public UsuarioController(RoleServicoImpl roleimpl,UsuarioServicoImpl usuimpl) {
		super("usuario");
		this.roleservico = roleimpl;
		this.ususervice = usuimpl;
		
	}


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Role.class, new AbstractEditor<Role>(this.roleservico) {
        });

    }
	
    @ModelAttribute
    public void addAttributes(Model model) {

    	
    	List<Role> roles = roleservico.findAll();
    	
//    	Genero[] generos = Genero.values();

        Usuario usuario = new Usuario();
//        usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        usuario = ususervice.findByUsername(usuario.getUsername());

                
//        model.addAttribute("usuarioAtt", usuario);
//        model.addAttribute("generos", generos);
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roles);

        

    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profileUsuario(HttpServletRequest request) {

        UUID idf = UUID.fromString(request.getParameter("id"));

        ModelAndView profileusuario = new ModelAndView("/public/profile");

        Usuario usuario = getservice().findOne(idf);

        profileusuario.addObject("usuario", usuario);

        return profileusuario;
    }
    
    
    
    
    
    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public ModelAndView Registro(Locale locale, Model model) {
       
    	logger.info("Welcome registro ! The client locale is {}.", locale);

        ModelAndView home = new ModelAndView("/public/registro");


        return home;
    }
    
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public ModelAndView RegistroPost(Locale locale, Model model, HttpServletRequest request) {
       
    	logger.info("Welcome registro ! The client locale is {}.", locale);

        ModelAndView home = new ModelAndView("/public/registro");
        
        Usuario usuario = new Usuario();
        
//        usuario.setUsername(request.getParameter("username"));
//        usuario.setEmail(request.getParameter("email"));
//        usuario.setSenha(request.getParameter("senha"));
//        usuario.setRoles(new HashMap().put(arg0, arg1));
       
        getservice().save(usuario);


        return new ModelAndView("forward:/login");
    }

	@Override
	protected UsuarioServicoImpl getservice() {

		return ususervice;
	}
    
    

}
