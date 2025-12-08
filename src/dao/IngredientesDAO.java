/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LgsIngredientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class IngredientesDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LgsIngredientes.class);
        criteria.add(Restrictions.eq("lgs_id_ingredientes", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LgsIngredientes.class);
        criteria.add(Restrictions.like("lgsNome", "%"+nome+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    } 
    
    public Object listQuantidade(int quant) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LgsIngredientes.class);
        criteria.add(Restrictions.ge("lgsQuantidadeEstoque", quant));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
  public Object listNomeQuant(String nome, int quant) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LgsIngredientes.class);
        criteria.add(Restrictions.like("lgsNome", "%"+nome+"%"));
        criteria.add(Restrictions.ge("lgsQuantidadeEstoque", quant));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
  }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LgsIngredientes.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        IngredientesDAO produtosDAO = new IngredientesDAO();
        produtosDAO.listAll();
    }
}
