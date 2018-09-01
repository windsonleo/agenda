package com.tecsoluction.agenda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tecsoluction.agenda.entidade.Atendimento;
import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.entidade.Patologia;
import com.tecsoluction.agenda.entidade.Role;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.AtendimentoServicoImpl;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;
import com.tecsoluction.agenda.servico.RoleServicoImpl;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;
import com.tecsoluction.agenda.util.StatusAtendimento;
import com.tecsoluction.agenda.util.StatusAtividade;





@Controller
@RequestMapping("atendimento/")
public class AtendimentoController extends AbstractController<Atendimento> {
	
	private static final Logger logger = LoggerFactory.getLogger(AtendimentoController.class);

	
//	 private final RoleServicoImpl roleservico;
	 
	 private final AtendimentoServicoImpl atendimentoservice;
	 
	 
	 private final UsuarioServicoImpl usuarioservice;
	 
	 private final PacienteServicoImpl pacienteservice;
	 
	 
	    private StatusAtendimento status[];
	    
	    
	    private List<Paciente> pacientes = new ArrayList<Paciente>();
	    
	    private List<Usuario> usuarios = new ArrayList<Usuario>();
	    
	    private Atendimento atendimento;
	    
	 
	
	@Autowired
    public AtendimentoController(AtendimentoServicoImpl usuimpl,PacienteServicoImpl pac,UsuarioServicoImpl usu) {
		super("atendimento");
//		this.roleservico = roleimpl;
		this.atendimentoservice = usuimpl;
		this.pacienteservice = pac;
		this.usuarioservice = usu;
		
	}


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Atendimento.class, new AbstractEditor<Atendimento>(this.atendimentoservice) {
        });

    }
	
    @ModelAttribute
    public void addAttributes(Model model) {

    	
//    	List<Role> roles = roleservico.findAll();
    	
//    	Genero[] generos = Genero.values();

//        Usuario usuario = new Usuario();
//        usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        usuario = ususervice.findByUsername(usuario.getUsername());

                
//        model.addAttribute("usuarioAtt", usuario);
//        model.addAttribute("generos", generos);
//        model.addAttribute("usuario", usuario);
//        model.addAttribute("roles", roles);
    	
    	status = StatusAtendimento.values();
    	
    	pacientes = pacienteservice.findAll();
    	
    	usuarios = usuarioservice.findAll();
    	
    	atendimento = new Atendimento();
    	
    	model.addAttribute("status", status);
    	model.addAttribute("pacientes", pacientes);
    	model.addAttribute("usuarios", usuarios);
    	  model.addAttribute("atendimento", atendimento);

        

    }
    
    @RequestMapping(value = "/adicionar", method = RequestMethod.GET)
    public ModelAndView AdicionarAtendimentos(HttpServletRequest request,@ModelAttribute Atendimento model) {

//        UUID idf = UUID.fromString(request.getParameter("id"));

//        ModelAndView home = new ModelAndView("/public/home");

//        Usuario usuario = getservice().findOne(idf);

//        profileusuario.addObject("usuario", usuario);
        
        getservice().save(model);

        return new ModelAndView("redirect:/home");
    }
    
    @RequestMapping(value = "/excluir", method = RequestMethod.GET)
    public ModelAndView ExcluirAtendimentos(HttpServletRequest request,@ModelAttribute Atendimento model) {

        UUID idf = UUID.fromString(request.getParameter("id"));

//        ModelAndView home = new ModelAndView("/public/home");

        Atendimento atendimento = getservice().findOne(idf);

//        profileusuario.addObject("usuario", usuario);
        
        getservice().delete(atendimento.getId());

        return new ModelAndView("redirect:/home");
    }
//    
//    
//    
//    
//    
//    @RequestMapping(value = "/registro", method = RequestMethod.GET)
//    public ModelAndView Registro(Locale locale, Model model) {
//       
//    	logger.info("Welcome registro ! The client locale is {}.", locale);
//
//        ModelAndView home = new ModelAndView("/public/registro");
//
//
//        return home;
//    }
//    
//    @RequestMapping(value = "/registro", method = RequestMethod.POST)
//    public ModelAndView RegistroPost(Locale locale, Model model, HttpServletRequest request) {
//       
//    	logger.info("Welcome registro ! The client locale is {}.", locale);
//
//        ModelAndView home = new ModelAndView("/public/registro");
//        
//        Usuario usuario = new Usuario();
//        
////        usuario.setUsername(request.getParameter("username"));
////        usuario.setEmail(request.getParameter("email"));
////        usuario.setSenha(request.getParameter("senha"));
////        usuario.setRoles(new HashMap().put(arg0, arg1));
//       
//        getservice().save(usuario);
//
//
//        return new ModelAndView("forward:/login");
//    }

	@Override
	protected AtendimentoServicoImpl getservice() {

		return atendimentoservice;
	}
    
    

}
