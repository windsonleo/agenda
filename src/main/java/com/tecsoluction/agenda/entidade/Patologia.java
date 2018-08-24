package com.tecsoluction.agenda.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tecsoluction.agenda.framework.BaseEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "PATOLOGIA")
//@XmlRootElement(name = "garcon")
public class Patologia extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    @Column(name = "nome")
//    @NotBlank(message = "Nome do Banco obrigatorio")
    private String nome;
    
    
    @JsonIgnore
    @ManyToMany(mappedBy = "patologias")
    private Set<Paciente> pacientes;
    

//    @NotBlank(message = "Numero do Banco  obrigatorio")
//    @Column(name = "start")
//    private String start;

//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @NotBlank(message = "Numero do Banco  obrigatorio")
//    @Column(name = "endd")
//    private String end;
    
//    @Enumerated(EnumType.STRING)
//    private StatusAtividade status;
    
    
    
//    @Column(name = "backgroundColor")
//    private String backgroundColor;
//    
//    
//    @Column(name = "borderColor")
//    private String borderColor;
//    
//    @Column(name = "url")
//    private String url;
    
    
	
    public Patologia() {
		// TODO Auto-generated constructor stub
	}
    
    



    @Override
    public String toString() {
        return nome.toUpperCase();
    }





	public Patologia(UUID idd, boolean atv,String nome) {
		super();
		this.id = idd;
		this.ativo = atv;
		this.nome = nome;

	}

}
