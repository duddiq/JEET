/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author student
 */
@WebService(serviceName = "generateHashService")
@Stateless()
public class generateHashService {

    @EJB
    private DataBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getHash")
    public String getHash() {
        return ejbRef.getHash();
    }

    @WebMethod(operationName = "calculateHash")
    public String calculateHash(@WebParam(name = "string") String string) {
        ejbRef.calculateHash(string);
        return ejbRef.getHash();
    }
    
}
