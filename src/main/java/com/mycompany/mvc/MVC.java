package com.mycompany.mvc;

import java.awt.GraphicsDevice;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MVC {

    public static void main(String args[]) {
    
 
        ViewCalculator view = new ViewCalculator();
        ModelCalculator model = new ModelCalculator();

        ControllerCalculator controller = new 
            ControllerCalculator(view, model);
       
    }
}
