package com.mycompany.mvc;

public class MVC {

    public static void main(String args[]) {

        ViewCalculator view = new ViewCalculator();
        ModelCalculator model = new ModelCalculator(view);

        ControllerCalculator controller = new ControllerCalculator(view, model);

    }
}
