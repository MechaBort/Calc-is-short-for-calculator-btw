package com.mycompany.mvc;

import java.util.ArrayList;

public class Register {

    static String ARCHIVO_REGISTRO = "registro.bn";
    static String NUM_ARCHIVO_REGISTRO = "num_registro.bn";

    ArrayList<String> register;
    ArrayList<Float> numRegister;

    public Register() {

        // read the current files
        register = (ArrayList<String>) FileManager.readObject(ARCHIVO_REGISTRO);
        if (register == null)
            register = new ArrayList<>();

        numRegister = (ArrayList<Float>) FileManager.readObject(NUM_ARCHIVO_REGISTRO);
        if (numRegister == null)
            numRegister = new ArrayList<>();
    }

    public void add(float num) {
        if (numRegister.size() > 9) {
            numRegister.removeFirst();
        }

        numRegister.add(num);
        updateFile();
    }

    public void add(String entry) {
        if (register.size() > 9) {
            register.removeFirst();
        }

        register.add(entry);
        updateFile();
    }

    void updateFile() {
        FileManager.writeObject(register, ARCHIVO_REGISTRO);
        FileManager.writeObject(numRegister, NUM_ARCHIVO_REGISTRO);
    }

    ArrayList<Float> getNumRegister() {
        return numRegister;
    }
}
