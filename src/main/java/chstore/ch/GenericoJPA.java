package chstore.ch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import chstore.ch.entidade.Jogador;
import chstore.ch.entidade.Torneio;

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

	public List<Torneio> buscarTodosTorneios() {
		String jpql = "select t from Torneio t";
		return em.createQuery(jpql, Torneio.class).getResultList();
	}

	public List<Jogador> buscarJogadoresOrdemPontuacao() {
		String jpql = "select j from Jogador j order by j.pontuacao desc";
		return em.createQuery(jpql, Jogador.class).getResultList();
	}

	public Torneio ultimoTorneioSalvo() {
		String jpql = "select t from Torneio t order by t.id desc";
		List<Torneio> list = em.createQuery(jpql, Torneio.class)
				.getResultList();

		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public Jogador buscarJogadorPorId(int id) {
		return em.find(Jogador.class, id);
	}

	public Torneio buscarTorneioPorId(int id) {
		return em.find(Torneio.class, id);
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
