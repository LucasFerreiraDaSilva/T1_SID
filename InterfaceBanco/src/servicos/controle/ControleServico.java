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
import javax.ws.rs.core.MediaType;

import bancoDados.IOperacoes;
import bancoDados.Operacoes;
import entidades.EntCliente;
import servicos.entidades.Cliente;
import servicos.entidades.Compra;
import servicos.entidades.Fabricante;
import servicos.entidades.Peca;

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
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
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
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/listarcliente")
	public List<Cliente> listarClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		return listaClientes;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/cliente")
	public Cliente getClientes() {
		Cliente cliente = new Cliente("Joao da Silva", "12345678901");
		return cliente;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/compra")
	public Compra getCompra() {
		Cliente cliente = new Cliente("Joao da Silva", "12345678901");
		Fabricante f = new Fabricante("Bosch","1111111");
		Peca p = new Peca(f, 200, "uma peca", "http://link-pra-imagem-opcional");
		Compra c = new Compra(cliente, p, 2, "10/12/2016", 450.50);
		return c;
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/listaclientes")	
	public List<Cliente> listaClientes() {
		List<Cliente> l = new ArrayList<>();
		Cliente c1 = new Cliente("Jose","232323");
		Cliente c2 = new Cliente("joao","34234");
		Cliente c3 = new Cliente("ewewew","43958345");
		l.add(c1);
		l.add(c2);
		l.add(c3);
		return l;
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
