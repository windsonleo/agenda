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
import com.tecsoluction.agenda.entidade.Endereco;
import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.RoleServicoImpl;
import com.tecsoluction.agenda.servico.EnderecoServicoImpl;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;





@Controller
@RequestMapping("endereco/")
public class EnderecoController extends AbstractController<Endereco> {
	
	private static final Logger logger = LoggerFactory.getLogger(EnderecoController.class);

	
	 private final PacienteServicoImpl pacienteservico;
	 
	 private final EnderecoServicoImpl ususervice;
	 
	
	
    public EnderecoController(PacienteServicoImpl roleimpl,EnderecoServicoImpl usuimpl) {
		super("endereco");
		this.pacienteservico = roleimpl;
		this.ususervice = usuimpl;
		
	}


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Paciente.class, new AbstractEditor<Paciente>(this.pacienteservico) {
        });

    }
	
    @ModelAttribute
    public void addAttributes(Model model) {

    	
//    	List<Role> roles = roleservico.findAll();
    	
//    	Genero[] generos = Genero.values();

        Endereco endereco = new Endereco();
//        endereco.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        endereco = ususervice.findByUsername(endereco.getUsername());

                
//        model.addAttribute("enderecoAtt", endereco);
//        model.addAttribute("generos", generos);
        model.addAttribute("endereco", endereco);
//        model.addAttribute("roles", roles);

        

    }
    
//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public ModelAndView profileEndereco(HttpServletRequest request) {
//
//        UUID idf = UUID.fromString(request.getParameter("id"));
//
//        ModelAndView profileendereco = new ModelAndView("/public/profile");
//
//        Endereco endereco = getservice().findOne(idf);
//
//        profileendereco.addObject("endereco", endereco);
//
//        return profileendereco;
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
//        Endereco endereco = new Endereco();
//        
////        endereco.setUsername(request.getParameter("username"));
////        endereco.setEmail(request.getParameter("email"));
////        endereco.setSenha(request.getParameter("senha"));
////        endereco.setRoles(new HashMap().put(arg0, arg1));
//       
//        getservice().save(endereco);
//
//
//        return new ModelAndView("forward:/login");
//    }

	@Override
	protected EnderecoServicoImpl getservice() {

		return ususervice;
	}
    
    

}
