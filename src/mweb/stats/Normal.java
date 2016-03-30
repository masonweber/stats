/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mweb.stats;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Mason
 */
public class Normal {
    //class vars
    private double mean, variance, stdDev;
    //constructor
    public Normal(Set s) {
        mean = mean(s);
        System.out.println(mean);
        variance = variance(s);
        stdDev = standardDeviation(s);
        
    }
    //methods
    private double mean(Set s) {
        Iterator iterator = s.iterator();
        double sum = 0.0;
        while (iterator.hasNext()) {
            double d = (Double) iterator.next();
            sum += d;
        }
        double result = sum / Double.valueOf(s.size());
        
        return result;
    }
    
    private double variance(Set s) {
        //take mean
        //sum (x-u)^2
        Iterator iterator = s.iterator();
        double sum = 0.0;
        while (iterator.hasNext()) {
            double d = (Double) iterator.next();
            sum += (mean - d);
        }
        sum = Math.pow(sum, 2);
        
        //divide by n-1
        Double result = sum / (Double.valueOf(s.size() - 1));
        return result;
    }
    
    private double standardDeviation(Set s) {
        //square root of variance;
        Double result = Math.sqrt(variance);
        return result;
    }
}
