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

import br.ufpr.cruel.domain.dao.AtendimentoDao;
import br.ufpr.cruel.model.Atendimento;
import br.ufpr.cruel.model.TipoCliente;
import br.ufpr.cruel.service.transformer.AtendimentoTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/Atendimento")
public class AtendimentoService {

	private AtendimentoDao dao = new AtendimentoDao();
	private Transformer<Atendimento, br.ufpr.cruel.domain.Atendimento> transformer = new AtendimentoTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Atendimento> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Atendimento> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Atendimento findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tipoCliente/{tipoCliente}")
	public List<Atendimento> findByTipoCliente(@PathParam("nome") TipoCliente tipoCliente) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Atendimento> result = dao.findByTipoCliente(resolveTipoCliente(tipoCliente));
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/data/{data}")
	public List<Atendimento> findByData(@PathParam("cpf") Date data) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Atendimento> result = dao.findByData(data);
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/between/{dataInicio}/{dataFim}")
	public List<Atendimento> findBetweenData(@PathParam("dataInicio") Date dataInicio, @PathParam("dataFim") Date dataFim) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Atendimento> result = dao.findBetweenData(dataInicio, dataFim);
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Atendimento model) {
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Atendimento model) {
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.Atendimento find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.Atendimento tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.Atendimento atendimento = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(atendimento);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.Atendimento atendimento) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(atendimento);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.Atendimento atendimento) {
		dao.openCurrentSessionwithTransaction();
		dao.update(atendimento);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private br.ufpr.cruel.domain.TipoCliente resolveTipoCliente(TipoCliente tipoCliente) {
		br.ufpr.cruel.domain.TipoCliente domain = new br.ufpr.cruel.domain.TipoCliente();
		domain.setId(tipoCliente.getId());
		return domain;
	}

}
