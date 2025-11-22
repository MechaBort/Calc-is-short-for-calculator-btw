package com.mycompany.mvc;


public class ControllerCalculator {

    private ViewCalculator view;
    private ModelCalculator model;

    public ControllerCalculator(ViewCalculator view, ModelCalculator model) {
        
        this.view = view;
        this.model = model;
        
        init();
        showView();
    }

    private void init() {
        // initialize action listeners
    }

    private void showView() {
        view.setVisible(true);
    }

}
