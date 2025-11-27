package com.mycompany.mvc;


public class ModelCalculator {

    float numberOne;
    float numberTwo;
    int decimalPosition;
    char operation;
    
    public ModelCalculator() {
    
    }
    
    void add() {
        operation = '+';
    }

    void sub() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void product() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void divide() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void addNum(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        switch (operation) {
            case '+':
                
                break;
            case '-':
                
                break;
            case '*':
                    
                break;
            case '/':
                
                break;
            default:
                throw new AssertionError();
        }
    }

    void binary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void prime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void average() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void data() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void store() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
