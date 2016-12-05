package servicos.entidades;

public class Compra {
	private int idCompra, idCliente, idPeca;
	private int quantidade;
	private String data;
	private double valor;

	public Compra(int idCompra, int idCliente, int idPeca, int quantidade, String data, double valor) {
		super();
		this.idCompra = idCompra;
		this.idCliente = idCliente;
		this.idPeca = idPeca;
		this.quantidade = quantidade;
		this.data = data;
		this.valor = valor;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + idCliente;
		result = prime * result + idCompra;
		result = prime * result + idPeca;
		result = prime * result + quantidade;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (idCompra != other.idCompra)
			return false;
		if (idPeca != other.idPeca)
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", idCliente=" + idCliente + ", idPeca=" + idPeca + ", quantidade="
				+ quantidade + ", data=" + data + ", valor=" + valor + "]";
	}

}
