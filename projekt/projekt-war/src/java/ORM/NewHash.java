/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORM;

/**
 *
 * @author student
 */
public class NewHash {
    protected String input;
    protected String hash;
    
    public NewHash(String input, String hash) {
        this.input = input;
        this.hash = hash;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getInput() {
        return input;
    }

    public String getHash() {
        return hash;
    }
    
    public NewHash() {}
    
    
}
