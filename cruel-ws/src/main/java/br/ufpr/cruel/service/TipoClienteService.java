package br.ufpr.cruel.service;

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

import br.ufpr.cruel.domain.dao.TipoClienteDao;
import br.ufpr.cruel.model.TipoCliente;
import br.ufpr.cruel.service.transformer.TipoClienteTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/TipoCliente")
public class TipoClienteService {

	private TipoClienteDao dao = new TipoClienteDao();
	private Transformer<TipoCliente, br.ufpr.cruel.domain.TipoCliente> transformer = new TipoClienteTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoCliente> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.TipoCliente> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public TipoCliente findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/descricao/{descricao}")
	public List<TipoCliente> findByDescricao(@PathParam("descricao") String descricao) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.TipoCliente> result = dao.findByDescricao("%"+descricao+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(TipoCliente model) {
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(TipoCliente model) {
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.TipoCliente find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.TipoCliente tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.TipoCliente tipoCliente = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(tipoCliente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.TipoCliente tipoCliente) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(tipoCliente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.TipoCliente tipoCliente) {
		dao.openCurrentSessionwithTransaction();
		dao.update(tipoCliente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

}
