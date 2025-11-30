package com.mycompany.mvc;

import java.util.ArrayList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.OceanTheme;


public class ModelCalculator {

    float numberOne;
    float numberTwo;
    int decimalPosition;
    char operation;
    Register register;
    ViewCalculator view;

    public void addDecimal(int i) {
        
        if (num == CurrentNum.One) {
            numberOne = (float) (numberOne + (i * Math.pow(10, -decimalPosition)));
        } else {
            numberTwo = (float) (numberTwo + (i * Math.pow(10, -decimalPosition)));
        }
    
    }
    
    public enum CurrentNum {
        One, Two
    }
    
    CurrentNum num = CurrentNum.One;
    
    public ModelCalculator(ViewCalculator view) {
        this.view = view;
    }
    
    void add() {
        operation = '+';
    }

    void sub() {
        operation = '-';
    }

    void product() {
        operation = '*';
    }

    void divide() {
        operation = '/';
    }

    void addNum(int i) {
        if (decimalPosition != 0) {
            addDecimal(i);
            return;
        }
        
        if (num == CurrentNum.One) {
            numberOne = numberOne * 10 + i;
        } else {
            numberTwo = numberTwo * 10 + 1;
        }
    }

    void moveDecimal() {
        if (decimalPosition == 0) {
            decimalPosition = 1;
        }
        // todo: UPDATE View
    }

    void clear() {
        numberOne = 0f;
        numberTwo = 0f;
        decimalPosition = 0;
        operation = ' ';
    }

    void calculate() {
        String save = Float.toString(numberOne) + operation + Float.toString(numberTwo) + '=';
        
        switch (operation) {
            case '+':
                numberOne += numberTwo;
                numberTwo = 0;
                break;
            case '-':
                numberOne -= numberTwo;
                numberTwo = 0;
                break;
            case '*':
                numberOne *= numberTwo;
                numberTwo = 0;
                break;
            case '/':
                if (numberTwo == 0) {return;}
                numberOne /= numberTwo;
                numberTwo = 0;
                break;
            default:
                return;
        }
        
        operation = ' ';
        save += Float.toString(numberOne);
    }

    void binary() {
        calculate();
        Integer.toBinaryString(Float.floatToIntBits(numberOne)); 
    }

    boolean isPrime() {
        calculate();
        double square = Math.sqrt(numberOne);
        for (int n = 2; n <= square; n++) {
            if (numberOne % n == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    void prime() {
        
        if (isPrime()) {
        
        } else {
        
        }
        
    }

    void average() {
    
        ArrayList<Float> arr = register.getNumRegister();
        
        int n = arr.size();
        float sum = 0;
        
        for (float num : arr) {
            sum += num;
        }
        
        sum /= n;
    }

    void data() {
        JOptionPane pane = new JOptionPane();
        
        // show the register.register in the Pane
        
    }

    void store() {
        calculate();
        register.add(numberOne);
    }

}
