package com.sxwl.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

/**
 * 继承监听事件接口
 * @author Spring-Xa
 * version 1.0
 */
public class Putong extends JFrame implements ActionListener,KeyListener {
    /**
     * 实现执行字符串中的运算公式的功能
     */
    static final ScriptEngine JSE = new ScriptEngineManager().getEngineByName("JavaScript");
    private final JTextField resultText;
    private double resultNum=0.0;
    public Putong() {
        //super("普通计算器");
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //去掉修饰
        setUndecorated(true);
        JPanel panel = new JPanel();
        //使用空布局
        panel.setLayout(null);
        resultText=new JTextField("0");
        resultText.setBounds(5, 58, 285, 50);
        resultText.setColumns(25);
        resultText.setHorizontalAlignment(JTextField.RIGHT);
        resultText.setEditable(false);
        resultText.setBackground(Color.white);
        resultText.setFont(new Font("楷体",Font.ITALIC,20));

        //标题
        JLabel label = new JLabel("普通计算器");
        label.setBounds(10,20,240,25);
        label.setFont(new Font("楷体",Font.BOLD, 20));
        label.setForeground(Color.black);

        panel.add(label);
        //返回按钮
        JButton back = new JButton("返回");
        back.setBounds(220,20,100,25);
        back.setFont(new Font("楷体",Font.BOLD, 20));
        back.setOpaque(false);
        back.setBackground(Color.white);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        panel.add(back);
        BackOpen bo = new BackOpen();
        back.addActionListener(bo);
        String[] keys1 = {"mc", "m+", "m-", "mr", "AC", "!", "/", "*", "7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "0", ".", "="};
        JButton[] keys2 = new JButton[keys1.length];
        for(int i = 0; i< keys1.length; i++) {
            keys2[i]=new JButton(keys1[i]);
        }
        //自定义控件位置（空布局）
        keys2[0].setBounds(5, 120, 60, 40);
        keys2[1].setBounds(80,120,60,40);
        keys2[2].setBounds(153,120,60,40);
        keys2[3].setBounds(230,120,60,40);
        keys2[4].setBounds(5,175,60,40);
        keys2[5].setBounds(80,175,60,40);
        keys2[6].setBounds(153,175,60,40);
        keys2[7].setBounds(230,175,60,40);
        keys2[8].setBounds(5,230,60,40);
        keys2[9].setBounds(80,230,60,40);
        keys2[10].setBounds(153,230,60,40);
        keys2[11].setBounds(230,230,60,40);
        keys2[12].setBounds(5,285,60,40);
        keys2[13].setBounds(80,285,60,40);
        keys2[14].setBounds(153,285,60,40);
        keys2[15].setBounds(230,285,60,40);
        keys2[16].setBounds(5,340,60,40);
        keys2[17].setBounds(80,340,60,40);
        keys2[18].setBounds(153,340,60,40);
        keys2[19].setBounds(5,395,135,40);
        keys2[20].setBounds(153,395,60,40);
        keys2[21].setBounds(230,340,60,95);
        final int a = 4;
        final int b = 8;
        final int c = 11;
        final int d = 15;
        final int e = 21;
        for(int i=0;i<a;i++) {
            //设置控件背景色
            keys2[i].setBorderPainted(false);
            keys2[i].setFocusPainted(false);
            keys2[i].setBackground(Color.black);
            keys2[i].setForeground(Color.WHITE);
            keys2[i].setFont(new Font("楷体",Font.BOLD, 18));
        }
        for(int i=a;i<b;i++) {
            keys2[i].setBorderPainted(false);
            keys2[i].setFocusPainted(false);
            keys2[i].setBackground(Color.gray);
            keys2[i].setForeground(Color.WHITE);
            keys2[i].setFont(new Font("楷体",Font.BOLD, 18));
        }
        for(int i = b;i < c;i++) {
            keys2[i].setBorderPainted(false);
            keys2[i].setFocusPainted(false);
            keys2[i].setBackground(new  Color(248, 248, 248));
            keys2[i].setForeground(Color.black);
            keys2[i].setFont(new Font("楷体",Font.BOLD, 18));
        }
        for(int i = c;i < d;i++) {
            keys2[i].setBorderPainted(false);
            keys2[i].setFocusPainted(false);
            keys2[i].setBackground(new  Color(248, 248, 248));
            keys2[i].setForeground(Color.black);
            keys2[i].setFont(new Font("楷体",Font.BOLD, 18));
        }
        for(int i = d;i < e;i++) {
            keys2[i].setBorderPainted(false);
            keys2[i].setFocusPainted(false);
            keys2[i].setBackground(new  Color(248, 248, 248));
            keys2[i].setForeground(Color.black);
            keys2[i].setFont(new Font("楷体",Font.BOLD, 18));
        }
        keys2[11].setBorderPainted(false);
        keys2[11].setFocusPainted(false);
        keys2[11].setBackground(Color.gray);
        keys2[11].setForeground(Color.WHITE);
        keys2[11].setFont(new Font("楷体",Font.BOLD, 20));
        keys2[15].setBorderPainted(false);
        keys2[15].setFocusPainted(false);
        keys2[15].setBackground(Color.gray);
        keys2[15].setForeground(Color.WHITE);
        keys2[15].setFont(new Font("楷体",Font.BOLD, 20));
        keys2[21].setBorderPainted(false);
        keys2[21].setFocusPainted(false);
        keys2[21].setBackground(Color.red);
        keys2[21].setForeground(Color.WHITE);
        keys2[21].setFont(new Font("楷体",Font.BOLD, 20));
        for(int i = 0; i< keys1.length; i++) {
            //添加监听事件
            keys2[i].addActionListener(this);
            keys2[i].addKeyListener(this);
        }
        panel.add(resultText);
        for (JButton key : keys2) {
            panel.add(key);
        }
        resultText.addKeyListener(new KeyAdapter() {
            //监听resultText
            @Override
            public void keyPressed(KeyEvent e){
                char label=e.getKeyChar();
                String k=String.valueOf(label);
                //如果按下回车键 则将结果展示
                if(label==KeyEvent.VK_ENTER) {
                    handleResult();
                }
                //否则处理该算式
                else {
                    handleEquation(k);
                }
            }});

        this.add(panel);
        this.setSize(300,450);
        this.setLocation(300,300);
        this.setResizable(false);
        this.setVisible(true);
        centered(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    /**
     * 按键监听
     */
    @Override
    public void keyPressed(KeyEvent e) {
        char label=e.getKeyChar();
        String k=String.valueOf(label);
        if(label==KeyEvent.VK_ENTER) {
            handleResult();
        }
        else {
            handleEquation(k);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //获取该按键内容
        String label=e.getActionCommand();
        String [] key = {"mc", "m+","m-","mr","=","AC","+/-","返回"};
        if(key[0].equals(label)) {
            handleMc();
        }
        else if(key[1].equals(label)) {
            handleIncrease();
        }
        else if(key[2].equals(label)) {
            handleDecrease();
        }
        else if(key[3].equals(label)) {
            handleMr();
        }
        else if(key[4].equals(label)) {
            handleResult();
        }
        else if(key[5].equals(label)) {
            zero();
        }
        else if(key[6].equals(label)) {
            handleOppositeNumber();
        }
        else {
            handleEquation(label);
        }
    }
    /**
     * mc方法
     * 将存储的数据归零
     */
    public void handleMc() {
        resultNum=0.0;
    }
    /**
     * m+方法
     * 处理m+
     */
    private void handleIncrease() {
        double a=Double.parseDouble(resultText.getText());
        if(!"0".equals(resultText.getText())) {
            resultNum+=a;
        }
    }
    /**
     * m-方法
     * 处理m-
     */
    private void handleDecrease() {
        double a=-(Double.parseDouble(resultText.getText()));
        if(!"0".equals(resultText.getText())) {
            resultNum+=a;
        }
    }
    /**
     * mr方法
     */
    public void handleMr() {
        String str=String.valueOf(resultNum);
        resultText.setText(str);
    }
    /**
     * 算式处理方法
     */
    public void handleEquation(String label) {
        if("0".equals(resultText.getText())) {
            resultText.setText(label);
        }
        else {
            resultText.setText(resultText.getText()+label);
        }
    }
    public void handleResult() {
        String text=resultText.getText();
        try {
            Object a=JSE.eval(text);
            text=String.valueOf(a);
            resultText.setText(text);
        }
        catch (ScriptException e) {
            e.printStackTrace();
            resultText.setText("算式格式不正确!");
        }
    }
    public void zero() {
        resultText.setText("0");
    }
    public void handleOppositeNumber() {
        String p = "-?[0-9]+(\\.[0-9]+)?";
        Pattern pattern = Pattern.compile(p);
        String strText = resultText.getText();
        Matcher isNum = pattern.matcher(strText);
        if(isNum.matches()) {
            int a = Integer.parseInt(strText);
            a=a*(-1);
            strText=String.valueOf(a);
            resultText.setText(strText);
        }
    }

    /**
     * 获取屏幕大小
     * 自适应居中
     */
    public void centered(Container container) {
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screenSize=toolkit.getScreenSize();
        int w=container.getWidth();
        int h=container.getHeight();
        container.setBounds((screenSize.width-w)/2, (screenSize.height-h)/2, w, h);
    }
    public class BackOpen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Open();
            dispose();
        }
    }
}
