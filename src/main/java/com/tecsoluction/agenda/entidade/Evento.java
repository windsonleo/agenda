package com.tecsoluction.agenda.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.tecsoluction.agenda.framework.BaseEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "EVENTO")
//@XmlRootElement(name = "garcon")
public class Evento extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    @Column(name = "titulo")
//    @NotBlank(message = "Nome do Banco obrigatorio")
    private String titulo;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @NotBlank(message = "Numero do Banco  obrigatorio")
    private Date datainicio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @NotBlank(message = "Numero do Banco  obrigatorio")
    private Date datafim;
    
//    @Enumerated(EnumType.STRING)
//    private StatusAtividade status;
    
    private String backgroundcolor;
    
    
	
    public Evento() {
		// TODO Auto-generated constructor stub
	}



    @Override
    public String toString() {
        return titulo.toUpperCase();
    }

}
