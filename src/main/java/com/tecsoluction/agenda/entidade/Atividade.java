package com.tecsoluction.agenda.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tecsoluction.agenda.framework.BaseEntity;
import com.tecsoluction.agenda.util.StatusAtividade;
import com.tecsoluction.agenda.util.UtilsDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "ATIVIDADE")
//@XmlRootElement(name = "garcon")
public class Atividade extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    @Column(name = "descricao")
//    @NotBlank(message = "Nome do Banco obrigatorio")
    private String descricao;
    
//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="datainicio")
//    @NotBlank(message = "Numero do Banco  obrigatorio")
    private Date datainicio;

//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="datafim")
//    @NotBlank(message = "Numero do Banco  obrigatorio")
    private Date datafim;
    
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern ="HH:mm")
    @Column(name="hora")
    private Date hora;
    
    @Enumerated(EnumType.STRING)
    private StatusAtividade status;
    
    @JsonIgnore
    @ManyToOne(targetEntity=Usuario.class,fetch=FetchType.EAGER)
    private Usuario usuario;
    
    
	
    public Atividade() {
		// TODO Auto-generated constructor stub
	}



    @Override
    public String toString() {
        return descricao.toUpperCase();
    }
    
    
    
    public int DiasTotais() {
		
		
		UtilsDate utildate = new UtilsDate();
		
		
		
		
		return utildate.toQtdDiasEntreDatas(getDatainicio(), getDatafim());
	}
	
	
	
	public int DiasRestantes() {
		

		UtilsDate utildate = new UtilsDate();
		
		Date datahoje = new Date();
		
		System.out.println("data classe Atividade , Method: DiasRestantes" + datahoje);
		
		
		
		
		return utildate.toQtdDiasEntreDatas(datahoje, getDatafim());
		
	}
	
	
	
	public long HorasRestantes() {
		

		UtilsDate utildate = new UtilsDate();
		
		Date horaagora = new Date();
		
		long hora = horaagora.getTime();
				
		System.out.println("hora classe Atividade , Method: HorasRestantes" + hora);

		
		
		return utildate.toQtdHorasDataAtual(hora, getHora());
		
	}
	
	

}
