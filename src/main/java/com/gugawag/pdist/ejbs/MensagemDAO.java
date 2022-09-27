package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName="default")
    private EntityManager em;

    public void inserir(Mensagem novaMensagem){
        em.persist(novaMensagem);
    }

    public List<Mensagem> listar() {
        Query mensagensQuery = em.createQuery("SELECT mensagem FROM Mensagem mensagem");
        return mensagensQuery.getResultList();
    }

    public Mensagem pesquisarPorId(long id) {
        Query mensagemQuery = em.createQuery("SELECT mensagem FROM Mensagem mensagem WHERE mensagem.id = :id");
        mensagemQuery.setParameter("id", id);
        return (Mensagem) mensagemQuery.getSingleResult();
    }
}
