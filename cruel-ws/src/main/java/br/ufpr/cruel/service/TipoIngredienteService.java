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

import br.ufpr.cruel.domain.dao.TipoIngredienteDao;
import br.ufpr.cruel.model.TipoIngrediente;
import br.ufpr.cruel.service.transformer.TipoIngredienteTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/TipoIngrediente")
public class TipoIngredienteService {

	private TipoIngredienteDao dao = new TipoIngredienteDao();
	private Transformer<TipoIngrediente, br.ufpr.cruel.domain.TipoIngrediente> transformer = new TipoIngredienteTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoIngrediente> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.TipoIngrediente> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public TipoIngrediente findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/nome/{nome}")
	public List<TipoIngrediente> findByNome(@PathParam("nome") String nome) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.TipoIngrediente> result = dao.findByNome("%"+nome+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(TipoIngrediente model) {
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(TipoIngrediente model) {
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.TipoIngrediente find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.TipoIngrediente tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.TipoIngrediente tipoIngrediente = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(tipoIngrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.TipoIngrediente tipoIngrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(tipoIngrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.TipoIngrediente tipoIngrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.update(tipoIngrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

}
