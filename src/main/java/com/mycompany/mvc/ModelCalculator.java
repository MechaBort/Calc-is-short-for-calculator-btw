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
        decimalPosition++;
        view.appendNum(i);
    
    }
    
    public enum CurrentNum {
        One, Two
    }
    
    CurrentNum num = CurrentNum.One;
    
    public ModelCalculator(ViewCalculator view) {
        this.view = view;
        register = new Register();
    }
    
    void add() {
        operation = '+';
        num = CurrentNum.Two;
        view.appendOperation('+');
    }

    void sub() {
        operation = '-';
        num = CurrentNum.Two;
        view.appendOperation('-');
    }

    void product() {
        operation = '*';
        num = CurrentNum.Two;
        view.appendOperation('*');
    }

    void divide() {
        operation = '/';
        num = CurrentNum.Two;
        view.appendOperation('/');
    }

    void addNum(int i) {
        if (decimalPosition != 0) {
            addDecimal(i);
            return;
        }
        
        if (num == CurrentNum.One) {
            numberOne = numberOne * 10 + i;
        } else {
            numberTwo = numberTwo * 10 + i;
        }
        view.appendNum(i);
    }

    void moveDecimal() {
        if (decimalPosition == 0) {
            decimalPosition = 1;
            view.appendDot();
        }
        // todo: UPDATE View
    }

    void clear() {
        numberOne = 0f;
        numberTwo = 0f;
        decimalPosition = 0;
        operation = ' ';
        num = CurrentNum.One;
        view.clear();
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
        register.add(save);
        num = CurrentNum.One;
        view.setResult(Float.toString(numberOne));
    }

    void binary() {
        calculate();
        String bin = Integer.toBinaryString(Float.floatToIntBits(numberOne));
        view.setResult(bin);
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
            view.setResult("Prime");
        } else {
            view.setResult("Not Prime");
        }
        
    }

    void average() {
    
        ArrayList<Float> arr = register.getNumRegister();
        
        int n = arr.size();
        float sum = 0;
        
        for (float num : arr) {
            sum += num;
        }
        
        if (n > 0) {
            sum /= n;
            view.setResult(Float.toString(sum));
        } else {
            view.setResult("No data");
        }
    }

    void data() {
        JOptionPane pane = new JOptionPane();
        ArrayList<Float> nums = register.getNumRegister();
        String msg = "Stored numbers:\n";
        for (float f : nums) {
            msg += f + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);
        
    }

    void store() {
        calculate();
        register.add(numberOne);
    }

}
