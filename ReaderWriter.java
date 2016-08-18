/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.calc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Георгий
 */
public class ReaderWriter {

    /**
     *
     * @param fileName
     * @return
     */
    public ArrayList<Character> getExpression(String fileName){
        ArrayList<Character> expression = new ArrayList();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            int symbol;
            while ((symbol = bufferedReader.read()) != -1) {
                 expression.add((char) symbol);
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return expression;
    }
    
    /**
     *
     * @param expression
     * @param answer
     */
    public void writer(ArrayList<Character> expression, float answer){
        for(Character symbol: expression){
            System.out.print(symbol);
        }
        System.out.println(" = " + answer);
        
    }
}
