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
     * 鼠标点击并记录位置事件
     */
    @Override
    public void mousePressed(MouseEvent e) {
        origin.x = e.getX();
        origin.y = e.getY();
    }
    /**
     * 鼠标拖动
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Point location = frame.getLocation();
        //本来的位置+鼠标当前的位置-鼠标点击时的位置
        frame.setLocation(location.x+e.getX()-origin.x, location.y+e.getY()-origin.y);
    }
}
