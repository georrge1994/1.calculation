/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.calc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Георгий
 */
public class Calc {
    public ArrayList<Character> expression;
    public String fileName;


    /**
     * @param fileName
     */
    public Calc(String fileName){
        this.expression = new ArrayList();
        this.fileName = fileName;
    }

    /**
     *
     */
    public void calculation(){
        ReaderWriter readWriter = new ReaderWriter();
        readWriter.getExpression(expression, fileName);
        
        Check check = new Check(expression);
        if(check.fullCheck()){
            
            readWriter.writer(expression, 0);
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Calc calc = new Calc("C:\\tmp\\expression.txt");
        calc.calculation();
    }
    
}
