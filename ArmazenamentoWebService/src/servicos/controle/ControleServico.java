package servicos.controle;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import bancoDados.IOperacoes;
import bancoDados.Operacoes;
import entidades.EntCliente;
import servicos.entidades.Cliente;

@Path("/servicos")
public class ControleServico {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ControleServico() {
	}
	
	@GET
	@Produces("text/plain")
	@Path("/iniciar")
	public String iniciar() {
		emf = Persistence.createEntityManagerFactory( "cliente" );
		em = emf.createEntityManager();
		return "Iniciado";
	}

	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarcliente")
	public boolean cadastrarCliente(Cliente c) {
		EntCliente e = new EntCliente();
		e.setNome(c.getNome());
		e.setCpf(e.getCpf());
		
		IOperacoes<EntCliente> op = new Operacoes<>(em);
		op.adicionarOuAtualizar(e);
		return true;
	}
	
	@GET
	@Produces("application/json; charset=UFT-8")
	@Path("/listarcliente")
	public List<Cliente> listarClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		return listaClientes;
	}
	
	@GET
	@Produces("application/json; charset=UFT-8")
	@Path("/cliente")
	public Cliente getClientes() {
		Cliente cliente = new Cliente("teste", "testecpf");
		return cliente;
	}
	
	@GET
	@Produces("text/plain")
	@Path("/encerrar")
	public String encerrar() {
		if(em!=null)
			em.close();
		if(emf!=null)
			emf.close();
		
		return "Logout efetuado.";
	}
}
