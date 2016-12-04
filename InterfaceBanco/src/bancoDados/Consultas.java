package bancoDados;

public class Consultas {

	public static final String LIST_CLIENTES_QUERY = "select c from Cliente c";
	public static final String LIST_FABRICANTES_QUERY = "select f from Fabricante f";
	public static final String LIST_PECAS_QUERY = "select p from Peca p";

	public static final String GET_FABRICANTES_ID_PARAM = "idFabric";
	public static final String GET_FABRICANTES_ID_QUERY = "select f from Fabricante f where f.idFabricante = :"
			+ GET_FABRICANTES_ID_PARAM;
	public static final String GET_FABRICANTES_ID_LABEL = "Fabricante.obterFabricantePorId";

	public static final String GET_COMRPAS_CLIENTE_PARAM = "idCli";
	public static final String GET_COMPRAS_CLIENTE_QUERY = "select c from Compra c where c.cliente.idCliente = :"
			+ GET_COMRPAS_CLIENTE_PARAM;
	public static final String GET_COMPRAS_CLIENTE_LABEL = "Compra.obterComprasCliente";

	public static final String GET_CLIENTE_ID_PARAM = "idCli";
	public static final String GET_CLIENTE_ID_QUERY = "select c from Cliente c where c.idCliente = :"
			+ GET_CLIENTE_ID_PARAM;


}
