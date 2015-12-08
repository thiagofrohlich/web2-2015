<<<<<<< HEAD
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

import br.ufpr.cruel.domain.dao.IngredienteDao;
import br.ufpr.cruel.model.Ingrediente;
import br.ufpr.cruel.service.transformer.IngredienteTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/Ingrediente")
public class IngredienteService {

	private IngredienteDao dao = new IngredienteDao();
	private Transformer<Ingrediente, br.ufpr.cruel.domain.Ingrediente> transformer = new IngredienteTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ingrediente> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Ingrediente> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Ingrediente findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/nome/{nome}")
	public List<Ingrediente> findByNome(@PathParam("nome") String nome) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Ingrediente> result = dao.findByNome("%"+nome+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Ingrediente model) {
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Ingrediente model) {
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.Ingrediente find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.Ingrediente tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.Ingrediente ingrediente = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(ingrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.Ingrediente ingrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(ingrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.Ingrediente ingrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.update(ingrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

}
=======
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

import br.ufpr.cruel.domain.dao.IngredienteDao;
import br.ufpr.cruel.model.Ingrediente;
import br.ufpr.cruel.service.transformer.IngredienteTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/Ingrediente")
public class IngredienteService {

	private IngredienteDao dao = new IngredienteDao();
	private Transformer<Ingrediente, br.ufpr.cruel.domain.Ingrediente> transformer = new IngredienteTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ingrediente> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Ingrediente> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Ingrediente findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/nome/{nome}")
	public List<Ingrediente> findByNome(@PathParam("nome") String nome) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Ingrediente> result = dao.findByNome("%"+nome+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/descricao/{descricao}")
	public List<Ingrediente> findByDescricao(@PathParam("descricao") String descricao) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Ingrediente> result = dao.findByDescricao("%"+descricao+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Ingrediente model) {
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Ingrediente model) {
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.Ingrediente find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.Ingrediente tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.Ingrediente ingrediente = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(ingrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.Ingrediente ingrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(ingrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.Ingrediente ingrediente) {
		dao.openCurrentSessionwithTransaction();
		dao.update(ingrediente);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

}
>>>>>>> origin/master
