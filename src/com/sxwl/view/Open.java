package com.sxwl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Spring-Xa
 */
public class Open {
    public static JFrame open = new JFrame();
    public Open() {
        //窗口的大小
        open.setSize(600, 560);
        //不能放大缩小
        open.setResizable(false);
        //打开后出现的位置
        open.setLocationRelativeTo(null);
        //添加颜色
        open.getContentPane().setBackground(new  Color(235, 237, 238));
        open.setIconImage(Toolkit.getDefaultToolkit().getImage(Scientific.class.getResource("/com/sun/javafx/scene/web/skin/OrderedListNumbers_16x16_JFX.png")));
        //点击关闭后关闭进程
        open.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0 ,0 ,600, 560);
        panel.setBackground(new  Color(235, 237, 238));
        //按钮
        JButton jbs = new JButton("集合计算器");
        JButton jbpu = new JButton("普通计算器");
        JButton jbkx = new JButton("科学计算器");
        JButton jbjz1 = new JButton("进制十转计算器");
        JButton jbjz2 = new JButton("进制转十计算器");
        jbs.setBounds(200,280,200,60);
        jbs.setBackground(new  Color(248, 248, 248));
        jbs.setForeground(Color.black);
        jbs.setFont(new Font("黑体",Font.BOLD, 20));
        jbs.setBorderPainted(false);
        jbs.setFocusPainted(false);
        jbpu.setBounds(200,420,200,60);
        jbpu.setBackground(new  Color(248, 248, 248));
        jbpu.setForeground(Color.black);
        jbpu.setFont(new Font("黑体",Font.BOLD, 20));
        jbpu.setBorderPainted(false);
        jbpu.setFocusPainted(false);
        jbjz1.setBounds(200,140,200,60);
        jbjz1.setBackground(new  Color(248, 248, 248));
        jbjz1.setForeground(Color.black);
        jbjz1.setFont(new Font("黑体",Font.BOLD, 20));
        jbjz1.setBorderPainted(false);
        jbjz1.setFocusPainted(false);
        jbjz2.setBounds(200,210,200,60);
        jbjz2.setBackground(new  Color(248, 248, 248));
        jbjz2.setForeground(Color.black);
        jbjz2.setFont(new Font("黑体",Font.BOLD, 20));
        jbjz2.setBorderPainted(false);
        jbjz2.setFocusPainted(false);
        jbkx.setBounds(200,350,200,60);
        jbkx.setBackground(new  Color(248, 248, 248));
        jbkx.setForeground(Color.black);
        jbkx.setFont(new Font("黑体",Font.BOLD, 20));
        jbkx.setBorderPainted(false);
        jbkx.setFocusPainted(false);
        //标题
        JLabel label = new JLabel("多功能计算器", SwingConstants.CENTER);
        label.setBounds(180,80,240,40);
        label.setFont(new Font("楷体",Font.BOLD, 28));
        label.setForeground(Color.BLACK);
        panel.add(label);
        //添加事件
        Setcount set = new Setcount();
        jbs.addActionListener(set);
        Pucount pucount = new Pucount();
        jbpu.addActionListener(pucount);
        Base base = new Base();
        jbjz1.addActionListener(base);
        AnBase anbase = new AnBase();
        jbjz2.addActionListener(anbase);
        Scikx sci = new Scikx();
        jbkx.addActionListener(sci);
        panel.add(jbs);
        panel.add(jbpu);
        panel.add(jbjz1);
        panel.add(jbjz2);
        panel.add(jbkx);
        open.add(panel);
        //是否正常显示
        open.setVisible(true);
    }

    //按钮事件
    public static class Setcount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Set();
            open.dispose();
        }
    }
    public static class Pucount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Putong();
            open.dispose();
        }
    }
    public static class Base implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Scale();
            open.dispose();
        }
    }
    public static class AnBase implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AntiScale();
            open.dispose();
        }
    }
    public static class Scikx implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Sciwindow();
            open.dispose();
        }
    }
}
