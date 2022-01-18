/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import javax.ejb.Local;

/**
 *
 * @author student
 */
@Local
public interface DataBeanLocal {

    String getHash();

    void calculateHash(String string);
    
}
