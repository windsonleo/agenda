package com.tecsoluction.agenda.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
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

import com.tecsoluction.agenda.entidade.Endereco;
import com.tecsoluction.agenda.entidade.Evolucao;
import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.framework.AbstractController;
import com.tecsoluction.agenda.framework.AbstractEditor;
import com.tecsoluction.agenda.servico.EnderecoServicoImpl;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;
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
	 
	 private EnderecoServicoImpl enderecoservico;
	 
	 private UsuarioServicoImpl usuarioServico;
	
	
    public PacienteController(PacienteServicoImpl usuimpl,EnderecoServicoImpl end,UsuarioServicoImpl usuarioser) {
		super("paciente");
	
		this.ususervice = usuimpl;
		this.enderecoservico = end;
		this.usuarioServico = usuarioser;
		
	}


    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Paciente.class, new AbstractEditor<Paciente>(this.ususervice) {
        });

    }
	
    @ModelAttribute
    public void addAttributes(Model model) {

    	
    	logger.info("Welcome add atribute Paciente Controller !" + paciente);
    	
//    	List<Role> roles = roleservico.findAll();
    	
//    	Genero[] generos = Genero.values();
    	
    	tipo = TipoTerapia.values();
    	
    	planossaude = PlanoSaude.values();
    	
    
    		
    		paciente = new Paciente();
    		
    	
    	

//        paciente = new Paciente();
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
        
        Evolucao evolucao = new Evolucao();
        
        Date datanow = new Date();

        profilepaciente.addObject("paciente", paciente);
        profilepaciente.addObject("datanow", datanow);
        profilepaciente.addObject("evolucao", evolucao);

        return profilepaciente;
    }
    
    
    @RequestMapping(value = "/addevolucao", method = RequestMethod.POST)
    public ModelAndView AddEvolucaoPaciente(HttpServletRequest request) {

        UUID idf = UUID.fromString(request.getParameter("id"));

        ModelAndView profilepaciente = new ModelAndView("/private/paciente/perfil");

        this.paciente = getservice().findOne(idf);
        
	   	 Usuario usuario;
	 	
	   	 String mail =SecurityContextHolder.getContext().getAuthentication().getName();
	        
	   	 usuario = usuarioServico.findByEmail(mail);
        
        Evolucao evolucao = new Evolucao();
        
        evolucao.setUsuario(usuario);
        evolucao.setData(new Date());
        evolucao.setDescricao(request.getParameter("descricao"));
        
        paciente.addEvolucao(evolucao);
        
        getservice().edit(paciente);
        
        
        
        Date datanow = new Date();

        profilepaciente.addObject("paciente", paciente);
        profilepaciente.addObject("datanow", datanow);
        profilepaciente.addObject("evolucao", new Evolucao());

        return profilepaciente;
    }
    
    
    @RequestMapping(value = "/removeEvolucao", method = RequestMethod.GET)
    public ModelAndView rEMOVEEvolucaoPaciente(HttpServletRequest request) {

        UUID idf = UUID.fromString(request.getParameter("id"));
    	
    	String idff = request.getParameter("idevolucao");

        ModelAndView profilepaciente = new ModelAndView("/private/paciente/perfil");

        this.paciente = getservice().findOne(idf);
        
//	   	 Usuario usuario;
//	 	
//	   	 String mail =SecurityContextHolder.getContext().getAuthentication().getName();
//	        
//	   	 usuario = usuarioServico.findByEmail(mail);
//        
//        Evolucao evolucao = new Evolucao();
//        
//        evolucao.setUsuario(usuario);
//        evolucao.setData(new Date());
//        evolucao.setDescricao(request.getParameter("descricao"));
        
        int index = Integer.valueOf(idff);
        
        paciente.removeEvolucao(index);
        
        logger.info("Welcome Remove Evolucao Paciente Controller index: !" + idff);
        
        getservice().edit(paciente);
        
        
        
        Date datanow = new Date();

//        profilepaciente.addObject("paciente", paciente);
//        profilepaciente.addObject("datanow", datanow);
//        profilepaciente.addObject("evolucao", new Evolucao());

        return new ModelAndView("redirect:/paciente/perfil?id=" + paciente.getId());
    }
    
    
    
//    
//    
//    
//    
//    
    @RequestMapping(value = "/addendereco", method = RequestMethod.GET)
    public ModelAndView AddEndereco(HttpServletRequest request, Model model) {
       
    	logger.info("Welcome Add eNDEREECO PACIENTE !");
    	
    	 UUID id = UUID.fromString(request.getParameter("id"));
    	 
    	 Usuario usuario;
    	
    	 String mail =SecurityContextHolder.getContext().getAuthentication().getName();
         
    	 usuario = usuarioServico.findByEmail(mail);
    	 
    	 this.paciente = getservice().findOne(id);
    	 
    	 if(paciente.getEndereco() == null){
    	 
    	 Endereco endereco = new Endereco();
    	 paciente.setEndereco(endereco);
    	 
    	 }
    	 
//    	 if(request.getParameter("id") == null){
//    		 
//    		 ModelAndView cadastroenderecoerro = new ModelAndView("/public/error/erro");
//    		 cadastroenderecoerro.addObject("erro", "Id Paciente Nulo");
//    		 cadastroenderecoerro.addObject("usuarioAtt", usuario);
//    		 
//    		 
//    		 logger.info("if add endereco paciente!");
//    		 
//    		 return cadastroenderecoerro;
//    		 
//    	 }else {
//
//         this.paciente = getservice().findOne(id);
//
//        ModelAndView cadastroendereco = new ModelAndView("/private/endereco/cadastro/cadastroendereco");
//        
//        cadastroendereco.addObject("paciente", paciente);
//        cadastroendereco.addObject("acao", "add");
//        cadastroendereco.addObject("usuarioAtt", usuario);
//        
//        logger.info("else add endereco paciente!");
//        
//
//
//        return cadastroendereco;
//        
//    	 }
    	 
    	 
       ModelAndView cadastroendereco = new ModelAndView("/private/endereco/cadastro/cadastroendereco");
       
       
       
       cadastroendereco.addObject("paciente", paciente);
       cadastroendereco.addObject("acao", "add");
       cadastroendereco.addObject("endereco", paciente.getEndereco());
       
//       logger.info("else add endereco paciente!");
       


       return cadastroendereco; 
    	 
    	 
    }
    
    
    @RequestMapping(value = "addendereco", method = RequestMethod.POST)
    public ModelAndView addEnderecoPaciente(HttpServletRequest request, Model model) {


    	 UUID id = UUID.fromString(request.getParameter("id"));

         Endereco endereco = new Endereco();

         endereco.setLogradouro(request.getParameter("logradouro"));
         endereco.setNumero(request.getParameter("numero"));
         endereco.setBairro(request.getParameter("bairro"));
         endereco.setCidade(request.getParameter("cidade"));
         endereco.setUf(request.getParameter("uf"));
         endereco.setCep(request.getParameter("cep"));
         endereco.setPontoreferencia(request.getParameter("pontoreferencia"));
         endereco.setComplemento(request.getParameter("complemento"));
         endereco.setAtivo(true);

//   		String datanascimento = request.getParameter("datanascimento");

//   		SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
//   		
//   		Date data = null;
//   		
//   		try {
//   			data = df.parse(datanascimento);
//   		} catch (ParseException e) {
//   			// TODO Auto-generated catch block
//   			e.printStackTrace();
//   		}

         endereco = enderecoservico.save(endereco);


         this.paciente = getservice().findOne(id);


//   			cliente.setNome(request.getParameter("nome"));
//   			cliente.setTelefone(request.getParameter("telefone"));
////   			cliente.setDatanascimento(data);
//   			cliente.setEmail(request.getParameter("email"));
//   			cliente.setFoto(request.getParameter("foto"));
//   			cliente.setGenero(request.getParameter("genero"));
//   			cliente.setativo(true);

         paciente.setEndereco(endereco);


        getservice().edit(paciente);
        
//         endereco.setCliente(cliente);
         
//         enderecoService.edit(endereco);

   	ModelAndView cadastroendereco= new ModelAndView("/private/endereco/cadastro/cadastroendereco");
//   		
//   		
   	cadastroendereco.addObject("paciente",paciente);
   	cadastroendereco.addObject("endereco",endereco);
   	cadastroendereco.addObject("acao", "editar");


//         return new ModelAndView("redirect:/paciente/addendereco?id=" + paciente.getId());
   	
   	return cadastroendereco;
     }
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
    	
    	
    	logger.info("Welcome salvar foto paciente Paciente Controller !");
    	
//    	Paciente paciente = new Paciente();
    	
//    	paciente = pacienter;

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
//            paciente.setFoto(filename);
            
            System.out.println(" salvou file : " + filename);

        } catch (Exception e) {

            System.out.println(e);

            model.addAttribute("erros", erros + e);
            model.addAttribute("acao", "add");
            
            System.out.println(" não salvou file : " + e);

        }

//     Paciente paciente = new Paciente();
        this.paciente.setFoto(filename);
        
       return new ModelAndView("redirect:/paciente/cadastro").addObject("paciente", paciente);

    }

	@Override
	protected PacienteServicoImpl getservice() {

		return ususervice;
	}
    
    

}
