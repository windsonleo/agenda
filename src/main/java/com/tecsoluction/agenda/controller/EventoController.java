package com.tecsoluction.agenda.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.tecsoluction.agenda.entidade.Atividade;
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
	 
	 
	 private List<Evento> eventos;
	 
	
	
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
    	
    	eventos = getservice().findAll();

        Evento evento = new Evento();
//        evento.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        evento = ususervice.findByUsername(evento.getUsername());

                
//        model.addAttribute("eventoAtt", evento);
//        model.addAttribute("generos", generos);
        model.addAttribute("evento", evento);
        model.addAttribute("eventos", eventos);

        

    }
    
    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ModelAndView Adicionar(HttpServletRequest request,@ModelAttribute Evento model) {

    	
    	Calendar calendar = Calendar.getInstance();//cria o obj calendar e atribui a hora e data do sistema
    	Date data = calendar.getTime();//transforma o obj calendar em obj Date

    	SimpleDateFormat sddia = new SimpleDateFormat("yyyy-MM-dd");//cria um obj de formatação de data
    	SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");//cria um obj de formatação de hora
    	
    	String dia = sddia.format(data);//gera a string final formatada no estilo "dd-MM-yyyy"
    	String hora = sdhora.format(data);//gera a string final formatada no estilo "HH:mm:ss"
    	
    	
    	model.setStart(dia+"T"+hora);
    	model.setEnd(dia+"T"+hora);
    	
    	if(model.getBackgroundColor() == null && model.getBorderColor()==null){
    	
    	model.setBackgroundColor("#f39c12");
    	model.setBorderColor("#f39c12");
    	
    	
    	}
    	
    	System.out.println("Dia:" + dia + hora);
    	
    	System.out.println("Hora:" + hora);

    	
    	getservice().save(model);

        return new ModelAndView("redirect:/evento/cadastro");    }
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
