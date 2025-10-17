package controller;

import view.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller2D {
    private final Panel panel;


    public Controller2D(Panel panel) {
        this.panel = panel;

        initListeners();
    }

    private void initListeners() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {


            }

        });
    }

    private void drawScene() {
        panel.getRaster().clear();

        panel.repaint();
    }
}
