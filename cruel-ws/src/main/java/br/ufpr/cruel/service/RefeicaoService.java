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

import br.ufpr.cruel.domain.dao.RefeicaoDao;
import br.ufpr.cruel.model.Refeicao;
import br.ufpr.cruel.service.transformer.RefeicaoTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/Refeicao")
public class RefeicaoService {

	private RefeicaoDao dao = new RefeicaoDao();
	private Transformer<Refeicao, br.ufpr.cruel.domain.Refeicao> transformer = new RefeicaoTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Refeicao> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Refeicao> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Refeicao findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tipoRefeicao/{tipoRefeicao}")
	public List<Refeicao> findByTipoRefeicao(@PathParam("tipoRefeicao") String tipoRefeicao) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Refeicao> result = dao.findByTipoRefeicao("%"+tipoRefeicao+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Refeicao model) {
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Refeicao model) {
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.Refeicao find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.Refeicao tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.Refeicao refeicao = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(refeicao);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.Refeicao refeicao) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(refeicao);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.Refeicao refeicao) {
		dao.openCurrentSessionwithTransaction();
		dao.update(refeicao);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

}
