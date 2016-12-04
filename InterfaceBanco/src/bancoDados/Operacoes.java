package bancoDados;

import javax.persistence.EntityManager;

public class Operacoes<T> implements IOperacoes<T> {
	private EntityManager em;

	public Operacoes() {
		super();
	}

	public Operacoes(EntityManager em) {
		this.em = em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void adicionarOuAtualizar(T o) {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	@Override
	public void remover(T o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}
}
