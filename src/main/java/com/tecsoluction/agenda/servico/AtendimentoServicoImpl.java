package com.tecsoluction.agenda.servico;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsoluction.agenda.dao.IAtendimentoDAO;
import com.tecsoluction.agenda.entidade.Atendimento;
import com.tecsoluction.agenda.framework.AbstractEntityService;


/*  criar validacaoes para que o servico as chamem caso nao haja erros execute a acao  */


@Service("atendimentoService")
@Transactional
public class AtendimentoServicoImpl extends AbstractEntityService<Atendimento> {

    @Autowired
    private IAtendimentoDAO dao;


    public AtendimentoServicoImpl() {

        super(Atendimento.class, "atendimentos");

    }

   

    @Override
    protected void validateDelete(UUID id) {
        // TODO Auto-generated method stub

    }

//	@Override
//	public List<Atendimento> findAllNew() {
//		// TODO Auto-generated method stub
//		return dao.findAllNew();
//	}



	@Override
	protected JpaRepository<Atendimento, UUID> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}



	@Override
	protected void validateSave(Atendimento post) {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected String getIdEntity(Atendimento entity) {
		// TODO Auto-generated method stub
		return entity.getId().toString();
	}



	@Override
	protected void validateEdit(Atendimento post) {
		// TODO Auto-generated method stub
		
	}
	
	


}
