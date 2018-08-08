package com.tecsoluction.agenda.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;





@Controller
@RequestMapping("paciente/")
public class PacienteController extends AbstractController<Paciente> {
	
	private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

		 
	 private final PacienteServicoImpl ususervice;
	 
	
	
    public PacienteController(PacienteServicoImpl usuimpl) {
		super("paciente");
	
		this.ususervice = usuimpl;
		
	}


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Paciente.class, new AbstractEditor<Paciente>(this.ususervice) {
        });

    }
	
    @ModelAttribute
    public void addAttributes(Model model) {

    	
//    	List<Role> roles = roleservico.findAll();
    	
//    	Genero[] generos = Genero.values();

        Paciente paciente = new Paciente();
//        paciente.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        paciente = ususervice.findByUsername(paciente.getUsername());

                
//        model.addAttribute("pacienteAtt", paciente);
//        model.addAttribute("generos", generos);
        model.addAttribute("paciente", paciente);
//        model.addAttribute("roles", roles);

        

    }
    
//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public ModelAndView profilePaciente(HttpServletRequest request) {
//
//        UUID idf = UUID.fromString(request.getParameter("id"));
//
//        ModelAndView profilepaciente = new ModelAndView("/public/profile");
//
//        Paciente paciente = getservice().findOne(idf);
//
//        profilepaciente.addObject("paciente", paciente);
//
//        return profilepaciente;
//    }
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
//        Paciente paciente = new Paciente();
//        
////        paciente.setUsername(request.getParameter("username"));
////        paciente.setEmail(request.getParameter("email"));
////        paciente.setSenha(request.getParameter("senha"));
////        paciente.setRoles(new HashMap().put(arg0, arg1));
//       
//        getservice().save(paciente);
//
//
//        return new ModelAndView("forward:/login");
//    }

	@Override
	protected PacienteServicoImpl getservice() {

		return ususervice;
	}
    
    

}
