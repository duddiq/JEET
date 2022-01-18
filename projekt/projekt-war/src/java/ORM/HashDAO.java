/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM;

import org.hibernate.Session;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author student
 */
public class HashDAO {
    private Session session = null;
    private Query q = null;
    
    public HashDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        //this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insertHash(Wcy19kc1s1DudkaProjekt h){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(h);
            tx.commit();
        
        
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void deleteHash(int id){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Wcy19kc1s1DudkaProjekt h = (Wcy19kc1s1DudkaProjekt) session.get(Wcy19kc1s1DudkaProjekt.class, id);
            if(h !=null){
                session.delete(h);
                System.out.println("Hash deleted");
            }
            tx.commit();
            
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<Wcy19kc1s1DudkaProjekt> getAllHash() {
        List<Wcy19kc1s1DudkaProjekt> listOfHash = null;
        try {            
            Transaction tx = session.beginTransaction();
            
            q = session.createQuery("from Wcy19kc1s1DudkaProjekt");                      
            listOfHash = (List<Wcy19kc1s1DudkaProjekt>) q.list(); 
            
            session.close();            
            tx.commit();        
        } catch (HibernateException e) {}
        return listOfHash;
    }
    
    private String getListaHTML(List<Wcy19kc1s1DudkaProjekt> lista) {
        String wiersz;        
        wiersz = ("<table><tr>");        
        wiersz = wiersz.concat("<td><b>ID</b></td>" + "<td><b>HASH</b></td>");
        wiersz = wiersz.concat("</tr>");
        for (Wcy19kc1s1DudkaProjekt h : lista) {            
            wiersz = wiersz.concat("<tr>");            
            wiersz = wiersz.concat("<td>" + h.getId() + "</td>");            
            wiersz = wiersz.concat("<td>" + h.getHash() + "</td>");            
            wiersz = wiersz.concat("</tr>");        
        }        
        wiersz = wiersz.concat("</table>");
        return wiersz;
    }
    
    public String getHashHTML() {
        return getListaHTML(getAllHash());
    }
}
