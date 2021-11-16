/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trwalosc;

import org.hibernate.Session;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author student
 */
public class ShoesQuery {
    private Session session = null;
    private List<Shoes> shoesList = null;
    private Query q = null;
    
    public ShoesQuery() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public String getShoesLista () {
        try {            
            Transaction tx = session.beginTransaction();               
            q = session.createQuery("from Shoes");                      
            shoesList = (List<Shoes>) q.list();            
            session.close();            
            tx.commit();        
        } catch (HibernateException e) {}
        return getListaHTML(shoesList); 
    }
    
    private String getListaHTML(List<Shoes> lista) {
        String wiersz;        
        wiersz = ("<table><tr>");        
        wiersz = wiersz.concat("<td><b>ID</b></td>" + "<td><b>NAME</b></td>" + "<td><b>BRAND</b></td>" + "<td><b>TYPE</b></td>" + "<td><b>COLOR</b></td>" + "<td><b>IS LEATHER</b></td>" + "<td><b>HAS LACES</b></td>");
        wiersz = wiersz.concat("</tr>");
        for (Shoes s : lista) {            
            wiersz = wiersz.concat("<tr>");            
            wiersz = wiersz.concat("<td>" + s.getShoeId() + "</td>");            
            wiersz = wiersz.concat("<td>" + s.getName() + "</td>");            
            wiersz = wiersz.concat("<td>" + s.getBrand() + "</td>");
            wiersz = wiersz.concat("<td>" + s.getType() + "</td>");
            wiersz = wiersz.concat("<td>" + s.getColor() + "</td>");
            wiersz = wiersz.concat("<td>" + s.getMadeOfLeather() + "</td>");
            wiersz = wiersz.concat("<td>" + s.getHasLaces() + "</td>");
            wiersz = wiersz.concat("</tr>");        
        }        
        wiersz = wiersz.concat("</table>");
        return wiersz;    
    }
    
    public void insertShoes(Shoes s){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(s);
            tx.commit();
        
        
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    
    }
     
     
    public void updateShoes(Shoes s){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(s);
            tx.commit();
        
        
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    
    }
    
    public void deleteShoes(int id){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Shoes s= (Shoes) session.get(Shoes.class,id);
            if(s !=null){
                session.delete(s);
                System.out.println("Shoe deleted");
            }
            tx.commit();
            
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
    
    }
}
