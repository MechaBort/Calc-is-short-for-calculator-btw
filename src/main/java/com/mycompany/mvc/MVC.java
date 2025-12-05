package com.mycompany.mvc;

public class MVC {

    public static void main(String args[]) {
    
 
        float num = 1.5f;
        
        String s = Integer.toBinaryString(Float.floatToIntBits(num));
        System.out.println(s);
        System.out.println(Float.floatToRawIntBits(num));
        
        ViewCalculator view = new ViewCalculator();
        ModelCalculator model = new ModelCalculator(view);

        ControllerCalculator controller = new 
            ControllerCalculator(view, model);
       
    }
}
