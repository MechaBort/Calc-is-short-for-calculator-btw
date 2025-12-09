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
    boolean justCalculated;
    boolean hasStartedSecondNumber;

    public void addDecimal(int i) {

        if (num == CurrentNum.One) {
            numberOne = (float) (numberOne + (i * Math.pow(10, -decimalPosition)));
        } else {
            numberTwo = (float) (numberTwo + (i * Math.pow(10, -decimalPosition)));
            hasStartedSecondNumber = true;
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
        if (num == CurrentNum.Two) {
            if (hasStartedSecondNumber) {
                calculate();
                justCalculated = false;
            } else {
                return;
            }
        }
        operation = '+';
        num = CurrentNum.Two;
        resetCalculation();
        view.appendOperation('+');
    }

    void sub() {
        if (num == CurrentNum.Two) {
            if (hasStartedSecondNumber) {
                calculate();
                justCalculated = false;
            } else {
                return;
            }
        }
        operation = '-';
        num = CurrentNum.Two;
        resetCalculation();
        view.appendOperation('-');
    }

    void product() {
        if (num == CurrentNum.Two) {
            if (hasStartedSecondNumber) {
                calculate();
                justCalculated = false;
            } else {
                return;
            }
        }
        operation = '*';
        num = CurrentNum.Two;
        resetCalculation();
        view.appendOperation('*');
    }

    void divide() {
        if (num == CurrentNum.Two) {
            if (hasStartedSecondNumber) {
                calculate();
                justCalculated = false;
            } else {
                return;
            }
        }
        operation = '/';
        num = CurrentNum.Two;
        resetCalculation();
        view.appendOperation('/');
    }

    void addNum(int i) {
        if (justCalculated) {
            clear();
            justCalculated = false;
        }

        if (decimalPosition != 0) {
            addDecimal(i);
            return;
        }

        if (num == CurrentNum.One) {
            numberOne = numberOne * 10 + i;
        } else {
            numberTwo = numberTwo * 10 + i;
            hasStartedSecondNumber = true;
        }
        view.appendNum(i);
    }

    void moveDecimal() {
        if (decimalPosition == 0) {
            decimalPosition = 1;
            view.appendDot();
        }
    }

    void clear() {
        numberOne = 0f;
        numberTwo = 0f;
        operation = ' ';
        num = CurrentNum.One;
        resetCalculation();
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
                if (numberTwo == 0) {
                    view.setResult("Error: /0");
                    return;
                }
                numberOne /= numberTwo;
                numberTwo = 0;
                break;
            default:
                return;
        }

        operation = ' ';
        decimalPosition = 0;
        save += Float.toString(numberOne);
        register.add(save);
        num = CurrentNum.One;
        justCalculated = true;
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

    void resetCalculation() {
        decimalPosition = 0;
        justCalculated = false;
        hasStartedSecondNumber = false;
    }

}
