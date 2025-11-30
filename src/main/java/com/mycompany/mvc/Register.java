package com.mycompany.mvc;

import java.util.ArrayList;

public class Register {

    static String ARCHIVO_REGISTRO = "registro.bn";
    
    ArrayList<String> register;
    ArrayList<Float> numRegister;
    
    public Register() {
        register = new ArrayList<>();
        numRegister = new ArrayList<>();
    }
    
    public void add(float num) {
        if (numRegister.size() > 9) {
            remove();
        }
        
        numRegister.add(num);
        updateFile();
    }
    
    public void add(String entry) {
        if (register.size() > 9) {
            remove();
        }
        
        register.add(entry);
        updateFile();
    }
    
    public void remove() {
        register.removeFirst();
    }
    
    void updateFile() {
        FileManager.writeObject(register, ARCHIVO_REGISTRO);
        FileManager.writeObject(numRegister, ARCHIVO_REGISTRO);
    }

    ArrayList<Float> getNumRegister() {
        return numRegister;
    }
}
