package br.edu.ifsul.cc.lpoo.academia_danca.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import br.edu.ifsul.cc.lpoo.academia_danca.model.Modalidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;




/**
 *
 * @author Mili
 */
public class PersistenciaJPA implements InterfacePersistencia{
    
     EntityManagerFactory factory; //fabrica de gerenciadores de entidades
     EntityManager entity; //gerenciador de entidades JPA
    
    public PersistenciaJPA(){
        //parametro: é o nome da unidade de persistencia
        factory = Persistence.createEntityManagerFactory("pu_academia_danca");
        entity = factory.createEntityManager();    // estabelece a conexão com o banco de dados e executa a estratégia de geração
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close(); 
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
       
        return entity.find(c, id);//encontra um determinado registro              
    }

    @Override
    public void persist(Object o) throws Exception {
        
        entity.getTransaction().begin();// abrir a transacao.
        entity.persist(o); //realiza o insert ou update.
        entity.getTransaction().commit(); //comita a transacao (comando sql)                
    }

    @Override
    public void remover(Object o) throws Exception {
        
        entity.getTransaction().begin();// abrir a transacao.
        entity.remove(o); //realiza o delete
        entity.getTransaction().commit(); //comita a transacao (comando sql)                
    }
    
    public List<Modalidade> getModalidades() {
        return entity.createNamedQuery("Modalidade.orderbyid").getResultList();
    }
    
    public Modalidade buscarPorDescricao(String descricao) {
        try {
            return entity.createQuery("SELECT m FROM Modalidade m WHERE m.descricao = :descricao", Modalidade.class)
                    .setParameter("descricao", descricao)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Se não encontrar nenhuma modalidade com a descrição fornecida
        }
    }
    
}
