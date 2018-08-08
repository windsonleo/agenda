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

import com.tecsoluction.agenda.entidade.Evento;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.EventoServicoImpl;





@Controller
@RequestMapping("evento/")
public class EventoController extends AbstractController<Evento> {
	
	private static final Logger logger = LoggerFactory.getLogger(EventoController.class);

	
//	 private final RoleServicoImpl roleservico;
	 
	 private final EventoServicoImpl eventoservice;
	 
	
	
    public EventoController(EventoServicoImpl usuimpl) {
		super("evento");
//		this.roleservico = roleimpl;
		this.eventoservice = usuimpl;
		
	}


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Evento.class, new AbstractEditor<Evento>(this.eventoservice) {
        });

    }
	
    @ModelAttribute
    public void addAttributes(Model model) {

    	
//    	List<Role> roles = roleservico.findAll();
    	
//    	Genero[] generos = Genero.values();

        Evento evento = new Evento();
//        evento.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        evento = ususervice.findByUsername(evento.getUsername());

                
//        model.addAttribute("eventoAtt", evento);
//        model.addAttribute("generos", generos);
        model.addAttribute("evento", evento);
//        model.addAttribute("roles", roles);

        

    }
    
//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public ModelAndView profileEvento(HttpServletRequest request) {
//
//        UUID idf = UUID.fromString(request.getParameter("id"));
//
//        ModelAndView profileevento = new ModelAndView("/public/profile");
//
//        Evento evento = getservice().findOne(idf);
//
//        profileevento.addObject("evento", evento);
//
//        return profileevento;
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
//        Evento evento = new Evento();
//        
////        evento.setUsername(request.getParameter("username"));
////        evento.setEmail(request.getParameter("email"));
////        evento.setSenha(request.getParameter("senha"));
////        evento.setRoles(new HashMap().put(arg0, arg1));
//       
//        getservice().save(evento);
//
//
//        return new ModelAndView("forward:/login");
//    }

	@Override
	protected EventoServicoImpl getservice() {

		return eventoservice;
	}
    
    

}
