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
        view.btnFive.addActionListener(this);
        view.btnZero.addActionListener(this);
        view.btnThree.addActionListener(this);
        view.btnEight.addActionListener(this);
        view.btnFour.addActionListener(this);
        view.btnOne.addActionListener(this);
        view.btnData.addActionListener(this);
        view.btnTwo.addActionListener(this);
        view.btnSeven.addActionListener(this);
        view.btnSix.addActionListener(this);
        view.btnNine.addActionListener(this);
        view.btnDivision.addActionListener(this);
        view.btnAvg.addActionListener(this);
        view.btnSub.addActionListener(this);
        view.btnProduct.addActionListener(this);
        view.btnClear.addActionListener(this);
        view.btnEqual.addActionListener(this);
        view.btnBinary.addActionListener(this);
        view.btnPrime.addActionListener(this);
        view.btnStore.addActionListener(this);
        view.btnDecimal.addActionListener(this);
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
            model.add();
        } else if (e.getSource().equals(view.btnSub)) {
            model.sub();
        } else if (e.getSource().equals(view.btnProduct)) {
            model.product();
        } else if (e.getSource().equals(view.btnDivision)) {
            model.divide();
        } else if (e.getSource().equals(view.btnOne)) {
            model.addNum(1);
        } else if (e.getSource().equals(view.btnTwo)) {
            model.addNum(2);
        } else if (e.getSource().equals(view.btnThree)) {
            model.addNum(3);
        } else if (e.getSource().equals(view.btnFour)) {
            model.addNum(4);
        } else if (e.getSource().equals(view.btnFive)) {
            model.addNum(5);
        } else if (e.getSource().equals(view.btnSix)) {
            model.addNum(6);
        } else if (e.getSource().equals(view.btnSeven)) {
            model.addNum(7);
        } else if (e.getSource().equals(view.btnEight)) {
            model.addNum(8);
        } else if (e.getSource().equals(view.btnNine)) {
            model.addNum(9);
        } else if (e.getSource().equals(view.btnZero)) {
            model.addNum(0);
        } else if (e.getSource().equals(view.btnDecimal)) {
            model.moveDecimal();
        } else if (e.getSource().equals(view.btnClear)) {
            model.clear();
        } else if (e.getSource().equals(view.btnEqual)) {
            model.calculate();
        } else if (e.getSource().equals(view.btnBinary)) {
            model.binary();
        } else if (e.getSource().equals(view.btnPrime)) {
            model.prime();
        } else if (e.getSource().equals(view.btnAvg)) {
            model.average();
        } else if (e.getSource().equals(view.btnData)) {
            model.data();
        } else if (e.getSource().equals(view.btnStore)) {
            model.store();
        }
    }

}