package com.sxwl.view;

import com.sun.awt.AWTUtilities;
import com.sxwl.controller.WindowDrag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import static java.lang.Integer.valueOf;

/**
 * @author Spring-Xa
 */
public class AntiScale {
    public JTextField tf1,out1;
    public JButton jb1,jb2,jb3;
    public static class BackOpen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Open();
            frame.dispose();
        }
    }
    /**
     * 二进制转十进制
     */
    public static String binaryToDecimal(String number) {
        return scaletoDecimal(number, 2);
    }
    /**
     * 八进制转十进制
     */
    public static String octaltoDecimal(String number) {
        return scaletoDecimal(number, 8);
    }
    /**
     * 十六进制转十进制
     */
    public static String hexadecimalToDecimal(String number) {
        return scaletoDecimal(number, 16);
    }
    public static String scaletoDecimal(String number, int scale) {
        //验证输入的数据
        checkNumber(number);
        //将其变为一个列表
        String[] ch = number.split("");
        //获取列表长度
        int chLength = ch.length;
        //定义一个变量存储计算后的值
        int total = 0;
        //把String类型的ch变为Integer型，再乘与scale的chLength - 1 - i次方
        for (int i = 0; i < chLength; i++) {
            total += Integer.parseInt(ch[i]) * Math.pow(scale, chLength - 1 - i);
        }
        return String.valueOf(total);
    }
    /**
     * 使用正则表达式对输入内容进行验证
     * 若为空或者不是正整数的话，抛出非法参数异常
     */
    public static void checkNumber(String number) {
        String regexp = "^\\d+$";
        if (null == number || !number.matches(regexp)) {
            throw new IllegalArgumentException("输入的不是数字");
        }
    }


    /**
     * 监听事件
     */
    class Listener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(valueOf(tf1.getText()).toString());
            out1.setText(binaryToDecimal(String.valueOf(num1)));
        }
    }
    class Listener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num2 = Integer.parseInt(valueOf(tf1.getText()).toString());
            out1.setText(octaltoDecimal(String.valueOf(num2)));
        }
    }
    class Listener3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String num3 = valueOf(tf1.getText()).toString();
            out1.setText(hexadecimalToDecimal(num3));
        }
    }
    public static JFrame frame = new JFrame();
    public AntiScale(){

        WindowDrag windowdrag = new WindowDrag(frame);
        frame.setTitle("多功能计算器");
        //窗口的大小
        frame.setSize(600, 330);
        //不能放大缩小
        frame.setResizable(false);
        //打开后出现的位置
        frame.setLocationRelativeTo(null);
        //添加颜色
        frame.getContentPane().setBackground(Color.white);
        //点击关闭后关闭进程
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //去掉修饰
        frame.setUndecorated(true);
        AWTUtilities.setWindowShape(frame,
                new RoundRectangle2D.Double(0.0D, 0.0D, frame.getWidth(),
                        frame.getHeight(), 30.0D, 30.0D));

        //上面板“标题栏”
        JPanel top = new JPanel();
        top.setLayout(null);
        top.setBounds(0 ,0 ,600, 50);
        top.setBackground(new Color(255, 255, 255));
        top.addMouseListener(windowdrag);
        top.addMouseMotionListener(windowdrag);
        //标题
        JLabel label = new JLabel("进制转十计算器");
        label.setBounds(20,15,240,25);
        label.setFont(new Font("楷体",Font.BOLD, 20));
        label.setForeground(Color.black);
        top.add(label);

        //返回按钮
        JButton back = new JButton("返回");
        back.setBounds(500,15,100,25);
        back.setFont(new Font("楷体",Font.BOLD, 20));
        back.setOpaque(false);
        back.setBackground(Color.white);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        top.add(back);
        BackOpen bo = new BackOpen();
        back.addActionListener(bo);

        //下面板
        JPanel down = new JPanel();
        down.setLayout(null);
        down.setBounds(0 ,100 ,600, 80);
        down.setBackground(new  Color(235, 237, 238));

        //输入框标题
        JLabel jl1,jl3;
        jl1 = new JLabel("数字");
        jl1.setBounds(30,100,100,50);
        jl1.setFont(new Font("宋体",Font.BOLD, 14));
        jl1.setForeground(Color.black);
        down.add(jl1);
        //输入框
        tf1 = new JTextField();
        tf1.setBounds(75, 100, 500, 50);
        tf1.setFont(new Font("楷体",Font.ITALIC,20));
        down.add(tf1);
        //计算按钮
        jb1= new JButton("二转十");
        jb2= new JButton("八转十");
        jb3= new JButton("十六转十");
        jb1.setBounds(75,235,150,60);
        jb2.setBounds(235,235,150,60);
        jb3.setBounds(395,235,150,60);
        jb1.setBackground(new  Color(248, 248, 248));
        jb2.setBackground(new  Color(248, 248, 248));
        jb3.setBackground(new  Color(248, 248, 248));
        jb1.setForeground(Color.black);
        jb2.setForeground(Color.black);
        jb3.setForeground(Color.black);
        jb1.setFont(new Font("黑体",Font.BOLD, 20));
        jb2.setFont(new Font("黑体",Font.BOLD, 20));
        jb3.setFont(new Font("黑体",Font.BOLD, 20));
        jb1.setBorderPainted(false);
        jb2.setBorderPainted(false);
        jb3.setBorderPainted(false);
        Listener1 binary = new Listener1();
        Listener2 octal = new Listener2();
        Listener3 hexadecimal = new Listener3();
        jb1.addActionListener(binary);
        jb2.addActionListener(octal);
        jb3.addActionListener(hexadecimal);
        down.add(jb1);
        down.add(jb2);
        down.add(jb3);

        //计算结果标题
        jl3 = new JLabel("结果");
        jl3.setBounds(30,175,100,50);
        jl3.setFont(new Font("宋体",Font.BOLD, 14));
        jl3.setForeground(Color.black);
        down.add(jl3);
        //计算结果输出框
        out1 = new JTextField();
        out1.setBounds(75, 175, 500, 50);
        out1.setFont(new Font("楷体",Font.ITALIC,20));
        down.add(out1);

        frame.add(top);
        frame.add(down);
        //是否正常显示
        frame.setVisible(true);
    }
}
