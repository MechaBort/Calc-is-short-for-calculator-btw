package com.mycompany.mvc;

import java.awt.GraphicsDevice;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MVC {

    public static void main(String args[]) {
    
        /* Determine if the GraphicsDevice supports translucency.
        GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        //If translucent windows aren't supported, exit.
        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            System.err.println(
                "Translucency is not supported");
                System.exit(0);
        }
        
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {*/
                ViewCalculator view = new ViewCalculator();

                // Set the window to 55% opaque (45% translucent).
                //view.setOpacity(0.55f);
                ModelCalculator model = new ModelCalculator();
        
                ControllerCalculator controller = new 
                    ControllerCalculator(view, model);
        //    }
        //});
       
    }
}
