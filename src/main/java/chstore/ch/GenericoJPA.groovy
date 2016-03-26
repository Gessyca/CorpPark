package chstore.ch;

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

import chstore.ch.entidade.Jogador
import chstore.ch.entidade.Veiculo

@Transactional
public class GenericoJPA {

	@PersistenceContext(unitName = "ch")
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public <T> T salvar(T t) {
		em.persist(t);
		em.flush();
		return t;
	}

	public <T> void atualizar(T t) {
		em.merge(t);
	}

	public <T> void remover(int id, Class<T> klass) {
		em.remove(em.find(klass, id));
	}

	public List<Jogador> buscarTodosJogadores() {
		String jpql = "select j from Jogador j order by j.nome";
		return em.createQuery(jpql, Jogador.class).getResultList();
	}

	public List<Veiculo> buscarTodosVeiculos() {
		String jpql = "select j from Veiculo j order by j.tipo";
		return em.createQuery(jpql, Veiculo.class).getResultList();
	}

	public Jogador buscarJogadorPorId(int id) {
		return em.find(Jogador.class, id);
	}

	public Jogador buscarJogadorPorNome(String nome) {
		String jpql = "select j from Jogador j where j.nome like ?1";
		List<Jogador> list = em.createQuery(jpql, Jogador.class)
				.setParameter(1, nome).getResultList();

		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
