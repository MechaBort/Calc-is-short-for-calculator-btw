package com.mycompany.mvc;

import java.awt.GraphicsDevice;
import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class ControllerCalculator implements ActionListener {

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
        
        view.btnAdd.addActionListener(this);
    }

    private void showView() {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                GraphicsEnvironment ge = 
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getDefaultScreenDevice();
                final boolean isTranslucencySupported = 
                    gd.isWindowTranslucencySupported(TRANSLUCENT);

                //If shaped windows aren't supported, exit.
                if (!gd.isWindowTranslucencySupported(PERPIXEL_TRANSPARENT)) {
                    System.err.println("Shaped windows are not supported");
                    System.exit(0);
                }

                //If translucent windows aren't supported, 
                //create an opaque window.
                if (!isTranslucencySupported) {
                    System.out.println(
                        "Translucency is not supported, creating an opaque window");
                }
                // Set the window to 70% translucency, if supported.
                if (isTranslucencySupported) {
                    view.setOpacity(1f);
                }

                // Display the window.
                view.setVisible(true);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(view.btnAdd)) {
            
        } else if (e.getSource().equals(view.btnAdd)) {
        
        } else if (e.getSource().equals(view.btnSub)) {
        
        } else if (e.getSource().equals(view.btnProduct)) {
            
        } else if (e.getSource().equals(view.btnDivision)) {
        
        } else if (e.getSource().equals(view.btnOne)) {}
    }

}