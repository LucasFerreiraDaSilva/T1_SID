package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name = "Peca")
public class EntPeca {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPeca;
	
	@OneToOne
	@JoinColumn(name = "id_fabricante")
	private EntFabricante fabricante;
	
	private float valorUnitario;
	private String descricao, imagem;
	
	
	
	public EntPeca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EntPeca(EntFabricante fabricante, float valorUnitario, String descricao, String imagem) {
		super();
		this.fabricante = fabricante;
		this.valorUnitario = valorUnitario;
		this.descricao = descricao;
		this.imagem = imagem;
	}
	public int getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}
	public EntFabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(EntFabricante fabricante) {
		this.fabricante = fabricante;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + idPeca;
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + Float.floatToIntBits(valorUnitario);
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
		EntPeca other = (EntPeca) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (idPeca != other.idPeca)
			return false;
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (Float.floatToIntBits(valorUnitario) != Float.floatToIntBits(other.valorUnitario))
			return false;
		return true;
	}
	
	
}
