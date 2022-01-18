/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import com.github.aelstad.keccakj.fips202.SHA3_512;
import java.security.MessageDigest;

/**
 *
 * @author student
 */
@Singleton
@Stateless
public class DataBean implements DataBeanLocal {
    
    private String hash;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    
    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for(int i = 0; i < bytes.length; i++) {
            int a = bytes[i] & 0xFF;
            hexChars[i*2] = HEX_ARRAY[a >>> 4];
            hexChars[i*2 + 1] = HEX_ARRAY[a & 0x0F];
        }
        return new String(hexChars);
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public String getHash() {
        return this.hash;
    }

    @Override
    public void calculateHash(String string) {
        MessageDigest md = new SHA3_512();
        md.update(string.getBytes());
        
        this.hash = bytesToHex(md.digest());
        
        md.reset();
    }
    
    
}
