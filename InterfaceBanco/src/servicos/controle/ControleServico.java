package servicos.controle;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import servicos.entidades.Cliente;
import servicos.entidades.Compra;
import servicos.entidades.Fabricante;
import servicos.entidades.Peca;

@Path("/servicos")
public class ControleServico {
	private ExecConsultas exec;

	public ControleServico() {
		exec = new ExecConsultas();
	}

	@GET
	@Produces("text/plain")
	@Path("/iniciar")
	public String iniciar() {
		if(exec == null)
			exec = new ExecConsultas();
		return "Iniciado";
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/cadastrarcliente")
	public void cadastrarCliente(Cliente c) {
		exec.cadastrarCliente(c);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/listarclientes")
	public List<Cliente> listarClientes() {
		return exec.listarClientes();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/listarfabricantes")
	public List<Fabricante> listarFabricantes() {
		return exec.listarFabricantes();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/listarpecas")
	public List<Peca> listarPecas() {
		return exec.listarPecas();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/obterfabricante/{idfabricante}")
	public Fabricante obterFabricante(@PathParam("idfabricante") int idFabricante) {
		return exec.obterFabricante(idFabricante);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/obtercompras/{idcliente}")
	public List<Compra> obterCompras(@PathParam("idcliente") int idCliente) {
		return exec.obterCompras(idCliente);
	}

	@GET
	@Produces("text/plain")
	@Path("/encerrar")
	public String encerrar() {
		return exec.encerrar();
	}
}
