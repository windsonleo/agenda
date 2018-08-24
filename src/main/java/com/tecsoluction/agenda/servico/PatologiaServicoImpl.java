package com.tecsoluction.agenda.servico;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsoluction.agenda.dao.IPatologiaDAO;
import com.tecsoluction.agenda.entidade.Patologia;
import com.tecsoluction.agenda.framework.AbstractEntityService;


/*  criar validacaoes para que o servico as chamem caso nao haja erros execute a acao  */


@Service("patologiaService")
@Transactional
public class PatologiaServicoImpl extends AbstractEntityService<Patologia> {

    @Autowired
    private IPatologiaDAO dao;


    public PatologiaServicoImpl() {

        super(Patologia.class, "patologias");

    }

   

    @Override
    protected void validateDelete(UUID id) {
        // TODO Auto-generated method stub

    }

//	@Override
//	public List<Patologia> findAllNew() {
//		// TODO Auto-generated method stub
//		return dao.findAllNew();
//	}



	@Override
	protected JpaRepository<Patologia, UUID> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}



	@Override
	protected void validateSave(Patologia post) {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected String getIdEntity(Patologia entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected void validateEdit(Patologia post) {
		// TODO Auto-generated method stub
		
	}
	
	


}
