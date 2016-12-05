package bancoDados;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.EntCliente;

public class Main {
	static EntityManagerFactory emf;
	//static EntityManagerFactory emf2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		emf = Persistence.createEntityManagerFactory( "cliente" );
		//emf2 = Persistence.createEntityManagerFactory( "pecas" );
		//entityManagerFactory = Persistence.createEntityManagerFactory( "pecas" );
		//entityManagerFactory.close();

		EntityManager em = emf.createEntityManager();
		
		IOperacoes<EntCliente> operations = new Operacoes<>(em);
		operations.adicionarOuAtualizar(new EntCliente("Mizeravi", "2222"));
		operations.adicionarOuAtualizar(new EntCliente("Mizeravi2", "232222"));
		em.close();
		emf.close();
	}

}
