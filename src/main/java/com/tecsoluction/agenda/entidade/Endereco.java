package com.tecsoluction.agenda.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tecsoluction.agenda.framework.BaseEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ENDERECO")
public class Endereco extends BaseEntity implements Serializable {



    /**
	 * 
	 */
	private static final long serialVersionUID = -4628040518670753575L;

	@Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private String cep;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "pontoreferencia")
    private String pontoreferencia;

    @Column(name = "uf")
    private String uf;

    @OneToOne(mappedBy = "endereco")
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;
    
    private String latitude;
    
    private String longetude;


    public Endereco() {

    }

    public Endereco(Paciente cliente) {

        this.paciente = cliente;
    }


//    @PrePersist
//    public void prePersist() {
//       
//    	if (cliente != null) {
//        	this.setCliente(cliente);
////        	cliente.setEndereco(this);
//        	
//        	System.out.println("cliente diferente de null : " + cliente);
//        	
////        }else{
////        	
////        	cliente = new Cliente();
////        	this.setCliente(cliente);
////        	cliente.setEndereco(this);
////        	
////        	System.out.println("cliente igual a null : " + cliente);
//
//        	
//        }
//        
//        
//    }


//    @Override
//    public String toString() {
//        return logradouro.toUpperCase();
//    }
//    
//    @Override
//    public int hashCode() {
//    	// TODO Auto-generated method stub
//    	return super.hashCode();
//    }
    
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return logradouro +", Nº "+ numero+","+ bairro +","+ cidade;
    }

}
