package chstore.ch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import chstore.ch.entidade.Jogador;

/**
 * 
 * @author gessyca.lm
 */
@Transactional
public class JogadorJPA {

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

    public List<Jogador> buscarTodos() {
	String jpql = "select j from Jogador j order by j.nome";
	return em.createQuery(jpql, Jogador.class).getResultList();
    }

    public Jogador buscarJogadorPorId(int id) {
	return em.find(Jogador.class, id);
    }
}
