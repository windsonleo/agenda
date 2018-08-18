package com.tecsoluction.agenda.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;
import com.tecsoluction.agenda.util.PlanoSaude;
import com.tecsoluction.agenda.util.TipoTerapia;





@Controller
@RequestMapping("paciente/")
public class PacienteController extends AbstractController<Paciente> {
	
	private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

		 
	 private final PacienteServicoImpl ususervice;
	 
	 private TipoTerapia[] tipo;
	 
	 private PlanoSaude[] planossaude;
	 
	 private Paciente paciente;
	
	
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
    	
    	tipo = TipoTerapia.values();
    	
    	planossaude = PlanoSaude.values();
    	
    	

        Paciente paciente = new Paciente();
//        paciente.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//        paciente = ususervice.findByUsername(paciente.getUsername());

                
//        model.addAttribute("pacienteAtt", paciente);
        model.addAttribute("tiposterapia", tipo);
        model.addAttribute("paciente", paciente);
        model.addAttribute("planossaude", planossaude);

        

    }
    
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ModelAndView profilePaciente(HttpServletRequest request) {

        UUID idf = UUID.fromString(request.getParameter("id"));

        ModelAndView profilepaciente = new ModelAndView("/private/paciente/perfil");

        Paciente paciente = getservice().findOne(idf);

        profilepaciente.addObject("paciente", paciente);

        return profilepaciente;
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
    
    // verificar tmanho do arquivo e se o arquivo ja existe
    @RequestMapping(value = "salvarfotopaciente", method = RequestMethod.POST)
    public ModelAndView SalvarFotoPaciente(@RequestParam ("file") MultipartFile file, HttpSession session, HttpServletRequest request,
                             Model model,@ModelAttribute Paciente pacienter) {

        String sucesso = "Sucesso ao salvar foto";
        
        String erros = "Falha ao salvar foto";
        
//        ModelAndView cadastro = new ModelAndView("/private/produto/cadastro/cadastroproduto");

        String path = session.getServletContext().getRealPath("/WEB-INF/classes/static/img/paciente/");
        
        String filename = file.getOriginalFilename();
        
//        String caminho = path + "\\" + filename;
        
        String caminho = path  + filename;
        


        System.out.println(" path = "  + path );

        System.out.println(" caminho" + caminho);
//        
//        System.out.println("request D" + d);

        try {

            byte barr[] = file.getBytes();

            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(caminho));
            bout.write(barr);
            bout.flush();
            bout.close();

            model.addAttribute("sucesso", sucesso);
            model.addAttribute("filename", filename);
            model.addAttribute("acao", "add");
            pacienter.setFoto(filename);
            
            System.out.println(" salvou file : " + filename);

        } catch (Exception e) {

            System.out.println(e);

            model.addAttribute("erros", erros + e);
            model.addAttribute("acao", "add");
            
            System.out.println(" não salvou file : " + e);

        }

     
//        paciente.setFoto(filename);
        
       return new ModelAndView("redirect:/paciente/cadastro").addObject("paciente", pacienter);

    }

	@Override
	protected PacienteServicoImpl getservice() {

		return ususervice;
	}
    
    

}
