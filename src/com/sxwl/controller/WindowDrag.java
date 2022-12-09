package com.sxwl.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author Spring-Xa
 */
public class WindowDrag extends MouseAdapter implements MouseMotionListener {
    private final Point origin;
    private final JFrame frame;
    public WindowDrag(JFrame frame){
        origin = new Point();
        this.frame = frame;
    }
    /**
     * ���������¼λ���¼�
     */
    @Override
    public void mousePressed(MouseEvent e) {
        origin.x = e.getX();
        origin.y = e.getY();
    }
    /**
     * ����϶�
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Point location = frame.getLocation();
        //������λ��+��굱ǰ��λ��-�����ʱ��λ��
        frame.setLocation(location.x+e.getX()-origin.x, location.y+e.getY()-origin.y);
    }
}
