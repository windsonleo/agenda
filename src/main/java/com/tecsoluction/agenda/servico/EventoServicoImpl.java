package com.tecsoluction.agenda.servico;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsoluction.agenda.dao.IEventoDAO;
import com.tecsoluction.agenda.entidade.Evento;
import com.tecsoluction.agenda.framework.AbstractEntityService;


/*  criar validacaoes para que o servico as chamem caso nao haja erros execute a acao  */


@Service("eventoService")
@Transactional
public class EventoServicoImpl extends AbstractEntityService<Evento> {

    @Autowired
    private IEventoDAO dao;


    public EventoServicoImpl() {

        super(Evento.class, "eventos");

    }

   

    @Override
    protected void validateDelete(UUID id) {
        // TODO Auto-generated method stub

    }

//	@Override
//	public List<Evento> findAllNew() {
//		// TODO Auto-generated method stub
//		return dao.findAllNew();
//	}



	@Override
	protected JpaRepository<Evento, UUID> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}



	@Override
	protected void validateSave(Evento post) {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected String getIdEntity(Evento entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected void validateEdit(Evento post) {
		// TODO Auto-generated method stub
		
	}
	
	


}
