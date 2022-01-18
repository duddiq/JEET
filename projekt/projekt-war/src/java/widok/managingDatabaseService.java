/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widok;

import ORM.HashDAO;
import ORM.Wcy19kc1s1DudkaProjekt;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author student
 */
@WebService(serviceName = "managingDatabaseService")
@Stateless()
public class managingDatabaseService {
    
    @WebMethod(operationName = "getHashList")
    public List<Wcy19kc1s1DudkaProjekt> print() {
        return new HashDAO().getAllHash();
    }

    @WebMethod(operationName = "insertHash")
    public Boolean insertHash(@WebParam(name = "hash") String hash) {
        new HashDAO().insertHash(new Wcy19kc1s1DudkaProjekt(hash));
        return true;
    }
    
    @WebMethod(operationName = "deleteHash")
    public Boolean deleteHash(@WebParam(name = "id") int id) {
        new HashDAO().deleteHash(id);
        return true;
    }
}
