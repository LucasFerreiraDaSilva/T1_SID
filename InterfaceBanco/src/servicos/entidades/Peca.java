package servicos.entidades;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Peca {
	private int idPeca, idFabricante;
	private float valorUnitario;
	private String descricao, imagem;

	public Peca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Peca(int idPeca, int idFabricante, float valorUnitario, String descricao, String imagem) {
		super();
		this.idPeca = idPeca;
		this.idFabricante = idFabricante;
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

	public int getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
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
		result = prime * result + idFabricante;
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
		Peca other = (Peca) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idFabricante != other.idFabricante)
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

	@Override
	public String toString() {
		return "Peca [idPeca=" + idPeca + ", idFabricante=" + idFabricante + ", valorUnitario=" + valorUnitario
				+ ", descricao=" + descricao + ", imagem=" + imagem + "]";
	}

}
