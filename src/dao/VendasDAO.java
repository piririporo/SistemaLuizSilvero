/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LgsVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class VendasDAO extends AbstractDAO{

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
        Criteria criteria = session.createCriteria(LgsVendas.class);
        criteria.add(Restrictions.eq("lgs_id_vendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
public Object listClientes(String nomeDoCliente) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(LgsVendas.class);
    Criteria clienteCrit = criteria.createCriteria("lgsClientes");
    clienteCrit.add(Restrictions.like("nome", "%" + nomeDoCliente + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();      
    return lista;
}
    
   public Object listUsuarios(String nomeDoUsuario) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(LgsVendas.class);
    Criteria usuarioCrit = criteria.createCriteria("lgsUsuario"); 
    usuarioCrit.add(Restrictions.like("lgsNome", "%" + nomeDoUsuario + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();      
    return lista;
}
    public Object listTotal(double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LgsVendas.class);
        criteria.add(Restrictions.ge("lgsTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    } 
  public Object listUsuCliTotal(String nomeDoCliente, String nomeDoUsuario, double total) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(LgsVendas.class);
    Criteria clienteCrit = criteria.createCriteria("lgsClientes");
    clienteCrit.add(Restrictions.like("lgsNome", "%" + nomeDoCliente + "%"));
    Criteria usuarioCrit = criteria.createCriteria("lgsUsuario");
    usuarioCrit.add(Restrictions.like("lgsNome", "%" + nomeDoUsuario + "%"));
    criteria.add(Restrictions.ge("lgsTotal", total));
    List lista = criteria.list();
    session.getTransaction().commit();      
    return lista;
}

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LgsVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        VendasDAO produtosDAO = new VendasDAO();
        produtosDAO.listAll();
    }
}
