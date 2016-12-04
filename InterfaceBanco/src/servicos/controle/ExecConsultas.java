package servicos.controle;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bancoDados.Consultas;
import bancoDados.IOperacoes;
import bancoDados.Operacoes;
import entidades.EntCliente;
import entidades.EntCompra;
import entidades.EntFabricante;
import entidades.EntPeca;
import servicos.entidades.Cliente;
import servicos.entidades.Compra;
import servicos.entidades.Fabricante;
import servicos.entidades.Peca;

/**
 * Classe responsavel por executar as consultas e entregar o resultado no
 * formato das entidades utilizadas pelo webservices
 */
public class ExecConsultas {
	private EntityManagerFactory emf;
	private EntityManager em;

	public ExecConsultas() {
		emf = Persistence.createEntityManagerFactory("dbclientes");
		em = emf.createEntityManager();
	}

	public void cadastrarCliente(Cliente c) {
		EntCliente e = webBanco(c);
		IOperacoes<EntCliente> op = new Operacoes<>(em);
		op.adicionarOuAtualizar(e);
	}

	public void removerCliente(int idCliente) {
		EntCliente cli = obterCliente(idCliente);
		IOperacoes<EntCliente> op = new Operacoes<>(em);
		op.remover(cli);
	}

	public List<Cliente> listarClientes() {
		TypedQuery<EntCliente> consulta = em.createQuery(Consultas.LIST_CLIENTES_QUERY, EntCliente.class);
		List<Cliente> resultado = new ArrayList<>();
		for (EntCliente e : consulta.getResultList()) {
			resultado.add(bancoWeb(e));
		}
		return resultado;
	}

	public List<Fabricante> listarFabricantes() {
		TypedQuery<EntFabricante> consulta = em.createQuery(Consultas.LIST_FABRICANTES_QUERY, EntFabricante.class);
		List<Fabricante> resultado = new ArrayList<>();
		for (EntFabricante e : consulta.getResultList()) {
			resultado.add(bancoWeb(e));
		}
		return resultado;
	}

	public Fabricante obterFabricante(int idFabricante) {
		EntFabricante consulta = em.createQuery(Consultas.GET_FABRICANTES_ID_QUERY, EntFabricante.class)
				.setParameter(Consultas.GET_FABRICANTES_ID_PARAM, idFabricante).getSingleResult();
		return bancoWeb(consulta);
	}

	public EntCliente obterCliente(int idCliente) {
		EntCliente consulta = em.createQuery(Consultas.GET_CLIENTE_ID_QUERY, EntCliente.class)
				.setParameter(Consultas.GET_CLIENTE_ID_PARAM, idCliente).getSingleResult();
		return consulta;
	}

	private static Cliente bancoWeb(EntCliente e) {
		Cliente c = new Cliente(e.getNome(), e.getCpf());
		c.setIdCliente(e.getIdCliente());
		return c;
	}

	private static Fabricante bancoWeb(EntFabricante e) {
		return new Fabricante(e.getNome(), e.getCnpj());
	}

	private static Compra bancoWeb(EntCompra e) {
		return new Compra(e.getIdCompra(), e.getCliente().getIdCliente(), e.getPeca().getIdPeca(), e.getQuantidade(),
				e.getData(), e.getValor());
	}

	private static EntCliente webBanco(Cliente c) {
		EntCliente e = new EntCliente();
		e.setNome(c.getNome());
		e.setCpf(e.getCpf());
		return e;
	}

	public List<Compra> obterCompras(int idCliente) {
		List<EntCompra> consulta = em.createQuery(Consultas.GET_COMPRAS_CLIENTE_QUERY, EntCompra.class)
				.setParameter(Consultas.GET_COMRPAS_CLIENTE_PARAM, idCliente).getResultList();
		List<Compra> resultado = new ArrayList<>();
		for (EntCompra e : consulta) {
			resultado.add(bancoWeb(e));
		}
		return resultado;
	}

	public List<Peca> listarPecas() {
		TypedQuery<EntPeca> consulta = em.createQuery(Consultas.LIST_PECAS_QUERY, EntPeca.class);
		List<Peca> resultado = new ArrayList<>();
		for (EntPeca e : consulta.getResultList()) {
			resultado.add(bancoWeb(e));
		}
		return resultado;
	}

	private static Peca bancoWeb(EntPeca e) {
		return new Peca(e.getIdPeca(), e.getFabricante().getIdFabricante(), e.getValorUnitario(), e.getDescricao(),
				e.getImagem());
	}

	public String encerrar() {
		if (em != null)
			em.close();
		if (emf != null)
			emf.close();

		return "Logout efetuado.";
	}

}
