package com.tecsoluction.agenda.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@XmlRootElement(name = "garcon")
@EqualsAndHashCode
public class Evolucao implements Serializable {


    private static final long serialVersionUID = 1L;
    
    private UUID id;

    @Column(name = "descricao")
//    @NotBlank(message = "Nome do Banco obrigatorio")
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @NotBlank(message = "Numero do Banco  obrigatorio")
    private Date data;

    private Usuario usuario;
    
    
	
    public Evolucao() {
		// TODO Auto-generated constructor stub
	}



    @Override
    public String toString() {
        return descricao.toUpperCase();
    }

}
