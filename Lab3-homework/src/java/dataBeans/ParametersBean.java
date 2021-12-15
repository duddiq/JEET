/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBeans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author student
 */
public class ParametersBean implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String numberOfParameters;
    
    private PropertyChangeSupport propertySupport;
    
    public ParametersBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getNumberOfParameters() {
        return numberOfParameters;
    }
    
    public void setNumberOfParameters(String value) {
        String oldValue = numberOfParameters;
        numberOfParameters = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, numberOfParameters);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
