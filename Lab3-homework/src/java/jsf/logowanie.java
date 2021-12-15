/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

//import javax.faces.bean.ManagedBean;

/**
 *
 * @author student
 */
//@ManagedBean(name="logowanie")
public class logowanie {
    private String nazwa = "";
    private String hasło = "";
    
    public String getNazwa() {
        return nazwa;    
    }
    
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;    
    }
    
    public String getHasło() {
        return hasło;    
    }
    
    public void setHasło(String hasło) {
        this.hasło = hasło;    
    }
    
    public Boolean sprawdź() {
        try {
            if (nazwa.equals("student") && hasło.equals("wcy"))
                return true;
            else 
                return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Boolean logout() {
        this.nazwa = null;
        this.hasło = null;
        return true;
    }
    
    public logowanie() {}
}