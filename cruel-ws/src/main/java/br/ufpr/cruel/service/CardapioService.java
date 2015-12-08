package br.ufpr.cruel.service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.ufpr.cruel.domain.dao.CardapioDao;
import br.ufpr.cruel.model.Cardapio;
import br.ufpr.cruel.service.transformer.CardapioTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/Cardapio")
public class CardapioService {

	private CardapioDao dao = new CardapioDao();
	private Transformer<Cardapio, br.ufpr.cruel.domain.Cardapio> transformer = new CardapioTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cardapio> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Cardapio> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Cardapio findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/data/{data}")
	public List<Cardapio> findByData(@PathParam("data") Date data) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Cardapio> result = dao.findByData(data);
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/between/{dataInicio}/{dataFim}")
	public List<Cardapio> findByDataBetween(@PathParam("dataInicio") Date dataInicio, @PathParam("dataFim") Date dataFim) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Cardapio> result = dao.findBetweenData(dataInicio, dataFim);
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Cardapio model) {
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Cardapio model) {
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.Cardapio find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.Cardapio tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.Cardapio cardapio = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(cardapio);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.Cardapio cardapio) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(cardapio);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.Cardapio cardapio) {
		dao.openCurrentSessionwithTransaction();
		dao.update(cardapio);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

}
