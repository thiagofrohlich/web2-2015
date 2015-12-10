package br.ufpr.cruel.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import br.ufpr.cruel.domain.dao.PessoaDao;
import br.ufpr.cruel.model.Pessoa;
import br.ufpr.cruel.service.transformer.PessoaTransformer;
import br.ufpr.cruel.service.transformer.Transformer;

@Path("/Pessoa")
public class PessoaService {

	private PessoaDao dao = new PessoaDao();
	private Transformer<Pessoa, br.ufpr.cruel.domain.Pessoa> transformer = new PessoaTransformer();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> findAll() {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Pessoa> list = dao.findAll();
		dao.closeCurrentSession();
		
		return transformer.transformToModel(list);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Pessoa findById(@PathParam("id") Integer id) {
		return transformer.transformToModel( find(id) );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/nome/{nome}")
	public List<Pessoa> findByNome(@PathParam("nome") String nome) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Pessoa> result = dao.findByNome("%"+nome+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tipo/{tipo}")
	public List<Pessoa> findByTipo(@PathParam("tipo") String tipo) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Pessoa> result = dao.findByTipo("%"+tipo+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cpf/{cpf}")
	public List<Pessoa> findByCpf(@PathParam("cpf") String cpf) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Pessoa> result = dao.findByCpf("%"+cpf+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/crn/{crn}")
	public List<Pessoa> findByCrn(@PathParam("crn") String crn) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Pessoa> result = dao.findByCrn("%"+crn+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/email/{email}")
	public List<Pessoa> findByEmail(@PathParam("email") String email) {
		dao.openCurrentSession();
		List<br.ufpr.cruel.domain.Pessoa> result = dao.findByEmail("%"+email+"%");
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/usuario")
	public Pessoa findUser(@QueryParam("email") String email, @QueryParam("senha") String senha) throws UnsupportedEncodingException, GeneralSecurityException {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.Pessoa result = dao.findByEmailAndSenha(email, encrypt(senha));
		dao.closeCurrentSession();
		
		return transformer.transformToModel( result );
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(Pessoa model) throws UnsupportedEncodingException, GeneralSecurityException {
		model.setSenha(encrypt(model.getSenha()));
		persistDb( transformer.transformToDomain(model) );
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Pessoa model) throws UnsupportedEncodingException, GeneralSecurityException {
		model.setSenha(encrypt(model.getSenha()));
		updateDb( transformer.transformToDomain(model) );
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		deleteDb(id);
	}
	
	private br.ufpr.cruel.domain.Pessoa find(Integer id) {
		dao.openCurrentSession();
		br.ufpr.cruel.domain.Pessoa tipo = dao.findById(id);
		dao.closeCurrentSession();
		return tipo;
	}
	
	private void deleteDb(Integer id) {
		br.ufpr.cruel.domain.Pessoa pessoa = find(id);
		dao.openCurrentSessionwithTransaction();
		dao.delete(pessoa);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private void persistDb(br.ufpr.cruel.domain.Pessoa pessoa) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(pessoa);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}
	
	private void updateDb(br.ufpr.cruel.domain.Pessoa pessoa) {
		dao.openCurrentSessionwithTransaction();
		dao.update(pessoa);
		dao.getCurrentSession().flush();
		dao.getCurrentSession().clear();
		dao.getCurrentTransaction().commit();
		dao.closeCurrentSession();
	}

	private static String encrypt(String passwordToHash) throws GeneralSecurityException, UnsupportedEncodingException {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
}
