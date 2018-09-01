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
import com.tecsoluction.agenda.util.StatusAtendimento;
import com.tecsoluction.agenda.util.StatusAtividade;
import com.tecsoluction.agenda.util.UtilsDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "ATENDIMENTO")
//@XmlRootElement(name = "garcon")
public class Atendimento extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="data")
    private Date data;

    
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern ="HH:mm")
    @Column(name="hora")
    private Date hora;
    
    
    @Enumerated(EnumType.STRING)
    private StatusAtendimento status;
    
    @Column(name="isassinado")
    private boolean assinado= false;
    
    @ManyToOne(targetEntity=Paciente.class)
    private Paciente paciente;
    
    
    @JsonIgnore
    @ManyToOne(targetEntity=Usuario.class,fetch=FetchType.EAGER)
    private Usuario usuario;
    
    
	
    public Atendimento() {
		// TODO Auto-generated constructor stub
	}



    @Override
    public String toString() {
        return paciente.getNome();
    }
    
    
	

}
