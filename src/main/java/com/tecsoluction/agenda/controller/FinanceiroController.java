package com.tecsoluction.agenda.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tecsoluction.agenda.entidade.Atividade;
import com.tecsoluction.agenda.entidade.Evento;
import com.tecsoluction.agenda.entidade.Paciente;
import com.tecsoluction.agenda.entidade.Patologia;
import com.tecsoluction.agenda.entidade.Usuario;
import com.tecsoluction.agenda.servico.AtividadeServicoImpl;
import com.tecsoluction.agenda.servico.EventoServicoImpl;
import com.tecsoluction.agenda.servico.PacienteServicoImpl;
import com.tecsoluction.agenda.servico.PatologiaServicoImpl;
import com.tecsoluction.agenda.servico.UsuarioServicoImpl;
import com.tecsoluction.agenda.util.StatusAtividade;
import com.tecsoluction.agenda.util.StatusTratamento;


@Controller
@RequestMapping("financeiro/")
public class FinanceiroController {
	
    private static final Logger logger = LoggerFactory.getLogger(FinanceiroController.class);
    
	@Autowired
	private  UsuarioServicoImpl usuarioService = new UsuarioServicoImpl();
	
	@Autowired
	private  AtividadeServicoImpl atividadeService = new AtividadeServicoImpl();
	
	@Autowired
	private EventoServicoImpl eventoService = new EventoServicoImpl();
	
	
	@Autowired
	private  PacienteServicoImpl pacienteService = new PacienteServicoImpl();
	
	@Autowired
	private  PatologiaServicoImpl patologiaService = new PatologiaServicoImpl();
	
    @Autowired 
    private JavaMailSender mailSender;
    
    private StatusAtividade status[];
    
//    private StatusTratamento statustratamento[];
    
	
    private List<Atividade> atividades = new ArrayList<Atividade>();
    
    private List<Evento> eventos = new ArrayList<Evento>();
    
    
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    
    private List<Paciente> pacientes = new ArrayList<Paciente>();
    
    private List<Patologia> patologias = new ArrayList<Patologia>();
    
    private List<Paciente> pacientesAlta = new ArrayList<Paciente>();
    
    private List<Paciente> pacientesInternados = new ArrayList<Paciente>();
    
    
    
    
    
    private int qtdatividade;
 
    private int qtdusuarios;
    
    private int qtdpacientes;
    
    private int qtdpacientesaltas;
    
    private int qtdpacientesinternados;

	
	  @ModelAttribute
	    public void addAttributes(Model model) {
		  
		  atividades = atividadeService.findAll();
		  
		  usuarios = usuarioService.findAll();
		  
		  pacientes = pacienteService.findAll();
		  
		  eventos = eventoService.findAll();
		  
		  patologias = patologiaService.findAll();
		  
		  
		  
		  qtdatividade = atividades.size();
		  
		  qtdusuarios = usuarios.size();
		  
		  qtdpacientes = pacientes.size();
		  
		  qtdpacientesaltas = VerificarAltas(pacientes);
		  
		  qtdpacientesinternados = VerificarInternacoes(pacientes);
		  
		  
//		  	List<Produto> produtos = produtoService.findAll();
//
//	        List<Categoria> categorias = categoriaService.findAll();
	        
//
	        model.addAttribute("atividades", atividades);
	        model.addAttribute("usuarios", usuarios);
	        model.addAttribute("pacientes", pacientes);
	        model.addAttribute("qtdatividade", qtdatividade);
	        model.addAttribute("qtdusuarios", qtdusuarios);
	        model.addAttribute("qtdpacientes", qtdpacientes);
	        model.addAttribute("eventos", eventos);
	        model.addAttribute("patologias", patologias);
	        model.addAttribute("qtdpacientesaltas", qtdpacientesaltas);
	        model.addAttribute("qtdpacientesinternados", qtdpacientesinternados);

	        
	        
	        
	        
//	        model.addAttribute("produtos", produtos);


	    }
	
	
	
    private int VerificarAltas(List<Paciente> pacientes2) {
		
    	
    	pacientesAlta = new ArrayList<Paciente>();
    	
    	qtdpacientesaltas = 0;

    	for (Paciente paciente : pacientes2) {
    		
    		
    		if(paciente.isAlta()){
    			
    			pacientesAlta.add(paciente);
    			qtdpacientesaltas = qtdpacientesaltas + 1;
    			
    			
    		}
    		
			
		}
    	
    	
    	
    	
		return qtdpacientesaltas;
	}
    
    
    private int VerificarInternacoes(List<Paciente> pacientes2) {
		
    	
    	pacientesInternados = new ArrayList<Paciente>();
    	
    	qtdpacientesinternados = 0;

    	for (Paciente paciente : pacientes2) {
    		
    		
    		if(paciente.isInternacao()){
    			
    			pacientesInternados.add(paciente);
    			qtdpacientesinternados = qtdpacientesinternados + 1;
    			
    			
    		}
    		
			
		}
    	
    	
    	
    	
		return qtdpacientesinternados;
	}



	@RequestMapping(value = "/movimentacao", method = RequestMethod.GET)
    public ModelAndView Home(Locale locale, Model model) {
       
    	
    	
    	logger.info("Welcome Home /home! The client locale is {}.", locale);

        ModelAndView home = new ModelAndView("/private/financeiro/movimentacao/movimentacaofinanceiro");
        
        
//         Atividade atividade = new Atividade();
//         
//         status = StatusAtividade.values();
//         
//         
//         
//         home.addObject("atividade", atividade);
//         home.addObject("status", status);
//         home.addObject("statustratamento", statustratamento);



        return home;
    }
    



}
