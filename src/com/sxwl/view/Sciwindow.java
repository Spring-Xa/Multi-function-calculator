package com.sxwl.view;

import java.awt.*;

/**
 * @author Spring-Xa
 */
public class Sciwindow {
    public Sciwindow(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Scientific frame = new Scientific();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
