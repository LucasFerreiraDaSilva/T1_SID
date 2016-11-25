package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Compra")
public class EntCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompra;

	@OneToOne
	@JoinColumn(name = "id_cliente")
	private EntCliente cliente;
	
	@OneToOne
	@JoinColumn(name = "id_peca")
	private EntPeca peca;
	private int quantidade;
	private String data;
	private float valor;
	
	

	public EntCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntCompra(EntCliente cliente, EntPeca peca, int quantidade, String data, float valor) {
		super();
		this.cliente = cliente;
		this.peca = peca;
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
	public EntCliente getCliente() {
		return cliente;
	}
	public void setCliente(EntCliente cliente) {
		this.cliente = cliente;
	}
	public EntPeca getPeca() {
		return peca;
	}
	public void setPeca(EntPeca peca) {
		this.peca = peca;
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + idCompra;
		result = prime * result + ((peca == null) ? 0 : peca.hashCode());
		result = prime * result + quantidade;
		result = prime * result + Float.floatToIntBits(valor);
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
		EntCompra other = (EntCompra) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idCompra != other.idCompra)
			return false;
		if (peca == null) {
			if (other.peca != null)
				return false;
		} else if (!peca.equals(other.peca))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", cliente=" + cliente + ", peca=" + peca + ", quantidade=" + quantidade
				+ ", data=" + data + ", valor=" + valor + "]";
	}
}
