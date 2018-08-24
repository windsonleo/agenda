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
import com.tecsoluction.agenda.entidade.Patologia;
import com.tecsoluction.agenda.entidade.Patologia;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.PatologiaServicoImpl;





@Controller
@RequestMapping("patologia/")
public class PatologiaController extends AbstractController<Patologia> {
	
	private static final Logger logger = LoggerFactory.getLogger(PatologiaController.class);

	
//	 private final RoleServicoImpl roleservico;
	 
	 private final PatologiaServicoImpl patologiaservice;
	 
	 
	 private List<Patologia> patologias;
	 
	
	
    public PatologiaController(PatologiaServicoImpl usuimpl) {
		super("patologia");
//		this.roleservico = roleimpl;
		this.patologiaservice = usuimpl;
		
	}


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Patologia.class, new AbstractEditor<Patologia>(this.patologiaservice) {
        });

    }
	
    @ModelAttribute
    public void addAttributes(Model model) {

    	
//    	List<Role> roles = roleservico.findAll();
    	
//    	Genero[] generos = Genero.values();
    	
    	patologias = getservice().findAll();

        Patologia patologia = new Patologia();
//        patologia.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        patologia = ususervice.findByUsername(patologia.getUsername());

                
//        model.addAttribute("patologiaAtt", patologia);
//        model.addAttribute("generos", generos);
        model.addAttribute("patologia", patologia);
        model.addAttribute("patologias", patologias);

        

    }
    
    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ModelAndView Adicionar(HttpServletRequest request,@ModelAttribute Patologia model) {

//        UUID idf = UUID.fromString(request.getParameter("id"));
//
//        ModelAndView profilepatologia = new ModelAndView("/public/profile");
//
//        Patologia patologia = getservice().findOne(idf);
//
//        profilepatologia.addObject("patologia", patologia);
    	
//    	Date datini = new Date();
//    	
//    	Date datfim = new Date();
//    	
//		Date datini2 = null;
//	  	Date datfim2 = null;
//    	
//    	DateFormat datformat = new SimpleDateFormat("yyyy-MM-dd");
//    	
//    	String dataini = datformat.format(datini);
//
//    	String datafim = datformat.format(datfim);
//    	
//    	
//    	try {
//    		
//			 datini2 = datformat.parse(dataini);
//		  	 datfim2 = datformat.parse(datafim);
//		  	
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
//    	Calendar calendar = Calendar.getInstance();//cria o obj calendar e atribui a hora e data do sistema
//    	Date data = calendar.getTime();//transforma o obj calendar em obj Date
//
//    	SimpleDateFormat sddia = new SimpleDateFormat("yyyy-MM-dd");//cria um obj de formatação de data
//    	SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");//cria um obj de formatação de hora
//    	
//    	String dia = sddia.format(data);//gera a string final formatada no estilo "dd-MM-yyyy"
//    	String hora = sdhora.format(data);//gera a string final formatada no estilo "HH:mm:ss"
    	
//    	
//    	model.setStart(dia+"T"+hora);
//    	model.setEnd(dia+"T"+hora);
//    	
//    	if(model.getBackgroundColor() == null && model.getBorderColor()==null){
//    	
//    	model.setBackgroundColor("#f39c12");
//    	model.setBorderColor("#f39c12");
    	
    	
//    	}
    	
//    	System.out.println("Dia:" + dia + hora);
//    	
//    	System.out.println("Hora:" + hora);
//
//    	
//    	getservice().save(model);

        return new ModelAndView("redirect:/patologia/cadastro");    }
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
//        Patologia patologia = new Patologia();
//        
////        patologia.setUsername(request.getParameter("username"));
////        patologia.setEmail(request.getParameter("email"));
////        patologia.setSenha(request.getParameter("senha"));
////        patologia.setRoles(new HashMap().put(arg0, arg1));
//       
//        getservice().save(patologia);
//
//
//        return new ModelAndView("forward:/login");
//    }

	@Override
	protected PatologiaServicoImpl getservice() {

		return patologiaservice;
	}
    
    

}
