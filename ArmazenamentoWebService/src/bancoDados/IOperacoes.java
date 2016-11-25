package bancoDados;

/**Interface parametrizada para as operacoes do banco: adicionar, remover, atualizar*/
public interface IOperacoes<T> {
	
	/**Adiciona ou atualiza item no banco*/
	public void adicionarOuAtualizar(T o);

	/**Remove item do banco*/
	public void remover(T o);
	
}
