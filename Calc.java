/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.calc;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Георгий
 */
public class Calc {
    public ArrayList<Character> expression;                                     // list for symbols
    public String fileName;                                                     // input file name

    /**
     * @param fileName
     */
    public Calc(String fileName){
        this.expression = new ArrayList();
        this.fileName = fileName;
    }

    /**
     *  invoke all methods
     */
    public void calculation(){
        ReaderWriter readWriter = new ReaderWriter();
        readWriter.getExpression(expression, fileName);
        
        Check check = new Check(expression);
        if(check.fullCheck()){
            String expressionString = convertToString();
            Object answer = getResult(expressionString);
            readWriter.writer(expression, answer);
        }else{
            readWriter.writer(expression, null);
        }
    }
    
    /*
    * calculate answer with help js
    */
    private Object getResult(String expressionString){
        Object eval = new Object();
         try {
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");

            engine.put("expression", expressionString);
            eval = engine.eval("function calc(p) {"
                    + " var answer = eval(p); "
                    + " answer = Math.round(answer * 10000) / 10000;"
                    + " if(isFinite(answer))"
                    + "     return answer;"
                    + " else"
                    + "     return null"
                    + "}" +
                        "calc(expression)");
        } catch (ScriptException ex) {
            Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eval;
    }
    
    /*
    * expression convert to string
    */
    private String convertToString(){
        String expressionString = "";
        for(char symbol : expression){
            expressionString += symbol;
        }
        return expressionString;
    }

    public static void main(String[] args) {
        Calc calc = new Calc("C:\\tmp\\expression.txt");
        calc.calculation();
    }
    
}
