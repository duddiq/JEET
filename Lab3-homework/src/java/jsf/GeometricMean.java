/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.faces.bean.ManagedBean;

import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
/**
 *
 * @author student
 */
@ManagedBean(name="GeometricMean")
public class GeometricMean {
    private final String xmlFile = "/home/student/Desktop/Lab3-homework/web/results.xml";
    private int number = 5; //default number of random parameters
    private double mean;

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getMean() {
        return mean;
    }

    public void setNumber(int number) throws Exception {
        this.number = number;
        Random rand = new Random(); //instance of random class
        double[] data = new double[number];
        
        for (int i = 0; i < number; i++) {
            data[i] = rand.nextDouble()*10;
            System.out.println(data[i]);
        }
        this.mean = geometricMean(data);
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        
        Element root = document.getDocumentElement();

        Collection<Wynik> results = new ArrayList<Wynik>();
        results.add(new Wynik(this.mean));

        for (Wynik wynik : results) {
            Element newWynik = document.createElement("wynik");

            Element result = document.createElement("result");
            result.appendChild(document.createTextNode(Double.toString(wynik.getMean())));
            newWynik.appendChild(result);
            
            root.appendChild(newWynik);
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }

    public int getNumber() {
        return number;
    }
    
    public static double geometricMean(double[] data) {
	double sum = data[0];

	for (int i = 1; i < data.length; i++) {
		sum *= data[i]; 
	}
	return Math.pow(sum, 1.0 / data.length); 
    }
    
    public static double calculateGeometricMean(int number) {
        Random rand = new Random(); //instance of random class
        double[] data = new double[5];
        for (int i = 0; i < number; i++) {
            data[i] = rand.nextDouble();
        }
        return geometricMean(data);
    }
    
    public GeometricMean() {}
    
    private static class Wynik {
        double mean;
        
        public double getMean() {
            return this.mean;
        }
        
        public Wynik(double mean) {
            this.mean = mean;
        }
    }
}
