package chstore.ch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import chstore.ch.entidade.Jogador;
import chstore.ch.entidade.Torneio;

/**
 * 
 * @author gessyca.lm
 */
@Transactional
public class GenericoJPA {

    @PersistenceContext(unitName = "ch")
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
	this.em = em;
    }

    public <T> void salvar(T t) {
	em.persist(t);
    }

    public <T> void atualizar(T t) {
	em.merge(t);
    }

    public <T> void remover(T t) {
	em.remove(em.merge(t));
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
}
