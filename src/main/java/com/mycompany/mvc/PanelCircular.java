
package com.mycompany.mvc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class PanelCircular extends JPanel {

    private int padding = 20; // margen para que el círculo no pegue con el borde

    public PanelCircular() {
        setOpaque(false); // para que se vea el círculo “limpio” sobre el fondo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width  = getWidth();
        int height = getHeight();

        // diámetro = el menor lado menos padding
        int diameter = Math.min(width, height) - 2 * padding;
        int x = (width  - diameter) / 2;
        int y = (height - diameter) / 2;

        // color de relleno del círculo
        g2.setColor(Color.WHITE);          // cámbialo si quieres otro color
        g2.fillOval(x, y, diameter, diameter);

        // borde del círculo
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3f));
        g2.drawOval(x, y, diameter, diameter);

        g2.dispose();
    }
}