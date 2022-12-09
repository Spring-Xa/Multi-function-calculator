package com.sxwl.view;

import com.sun.awt.AWTUtilities;
import com.sun.deploy.util.StringUtils;
import com.sxwl.controller.WindowDrag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.*;


/**
 * @author Spring-Xa
 */
public class Set {
    public JTextField tf1,tf2,out1;
    public JButton jb1,jb2,jb3;
    /**
     * ��ť�¼�
     * ����һ���б�ȥ��ȡ�ı�����������ݣ�ʹ��split���������Ϊһ���б�
     * ����浽��ϣ�����棬ʹ��retainAll����ȥ����set1��set2��û�е�Ԫ��
     * �ٽ����Ϊһ���ַ��������ý���ı����ֵ
     */
    public class Jiaoji implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String [] s1 = (tf1.getText()).split("");
            String [] s2 = (tf2.getText()).split("");
            HashSet<String> set1 = new HashSet<>(Arrays.asList(s1));
            HashSet<String> set2 = new HashSet<>(Arrays.asList(s2));
            set1.retainAll(set2);
            String a = StringUtils.join(set1,",");
            out1.setText(a);
        }
    }
    public class Bingji implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String [] s1 = (tf1.getText()).split("");
            String [] s2 = (tf2.getText()).split("");
            HashSet<String> set1 = new HashSet<>(Arrays.asList(s1));
            HashSet<String> set2 = new HashSet<>(Arrays.asList(s2));
            set1.addAll(set2);
            String a = StringUtils.join(set1,",");
            out1.setText(a);
        }
    }
    public class Chaji implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String [] s1 = (tf1.getText()).split("");
            String [] s2 = (tf2.getText()).split("");
            HashSet<String> set1 = new HashSet<>(Arrays.asList(s1));
            HashSet<String> set2 = new HashSet<>(Arrays.asList(s2));
            set1.removeAll(set2);
            String a = StringUtils.join(set1,",");
            out1.setText(a);
        }
    }
    public static class BackOpen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Open();
            frame.dispose();
        }
    }
    public static JFrame frame = new JFrame();
    public Set(){

        WindowDrag windowdrag = new WindowDrag(frame);
        frame.setTitle("�๦�ܼ�����");
        //���ڵĴ�С
        frame.setSize(600, 420);
        //���ܷŴ���С
        frame.setResizable(false);
        //�򿪺���ֵ�λ��
        frame.setLocationRelativeTo(null);
        //�����ɫ
        frame.getContentPane().setBackground(new  Color(235, 237, 238));
        //����رպ�رս���
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //ȥ������
        frame.setUndecorated(true);
        AWTUtilities.setWindowShape(frame,
                new RoundRectangle2D.Double(0.0D, 0.0D, frame.getWidth(),
                        frame.getHeight(), 30.0D, 30.0D));

        //����塰��������
        JPanel top = new JPanel();
        top.setLayout(null);
        top.setBounds(0 ,0 ,800, 50);
        top.setBackground(new Color(255, 255, 255));
        top.addMouseListener(windowdrag);
        top.addMouseMotionListener(windowdrag);

        //����
        JLabel label = new JLabel("���ϼ�����");
        label.setBounds(20,15,240,25);
        label.setFont(new Font("����",Font.BOLD, 20));
        label.setForeground(Color.black);
        top.add(label);

        //���ذ�ť
        JButton back = new JButton("����");
        back.setBounds(500,15,100,25);
        back.setFont(new Font("����",Font.BOLD, 20));
        back.setOpaque(false);
        back.setBackground(new  Color(225, 237, 238));
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        top.add(back);
        BackOpen bo = new BackOpen();
        back.addActionListener(bo);
        back.setFocusPainted(false);
        //�����
        JPanel down = new JPanel();
        down.setLayout(null);
        down.setBounds(0 ,100 ,800, 110);
        down.setBackground(new  Color(235, 237, 238));

        //��������
        JLabel jl1,jl2,jl3;
        jl1 = new JLabel("����A");
        jl2 = new JLabel("����B");
        jl1.setBounds(25,100,100,50);
        jl2.setBounds(25,160,100,50);
        jl1.setFont(new Font("����",Font.BOLD, 14));
        jl2.setFont(new Font("����",Font.BOLD, 14));
        jl1.setForeground(Color.black);
        jl2.setForeground(Color.black);
        down.add(jl1);
        down.add(jl2);

        //�����
        tf1 = new JTextField();
        tf1.setBounds(75, 100, 500, 50);
        tf2 = new JTextField();
        tf2.setBounds(75, 160, 500, 50);
        tf1.setFont(new Font("����",Font.ITALIC,20));
        tf2.setFont(new Font("����",Font.ITALIC,20));
        down.add(tf1);
        down.add(tf2);

        //���㰴ť
        jb1= new JButton("����");
        jb2= new JButton("����");
        jb3= new JButton("�");
        jb1.setBounds(80,220,150,60);
        jb2.setBounds(250,220,150,60);
        jb3.setBounds(420,220,150,60);
        jb1.setBackground(new  Color(248, 248, 248));
        jb2.setBackground(new  Color(248, 248, 248));
        jb3.setBackground(new  Color(248, 248, 248));
        jb1.setForeground(Color.black);
        jb2.setForeground(Color.black);
        jb3.setForeground(Color.black);
        jb1.setFont(new Font("����",Font.BOLD, 20));
        jb2.setFont(new Font("����",Font.BOLD, 20));
        jb3.setFont(new Font("����",Font.BOLD, 20));
        Jiaoji count1 = new Jiaoji();
        Bingji count2 = new Bingji();
        Chaji count3 = new Chaji();
        jb1.addActionListener(count1);
        jb2.addActionListener(count2);
        jb3.addActionListener(count3);
        jb1.setBorderPainted(false);
        jb1.setFocusPainted(false);
        jb2.setBorderPainted(false);
        jb2.setFocusPainted(false);
        jb3.setBorderPainted(false);
        jb3.setFocusPainted(false);
        down.add(jb1);
        down.add(jb2);
        down.add(jb3);

        //����������
        jl3 = new JLabel("���");
        jl3.setBounds(30,310,100,50);
        jl3.setFont(new Font("����",Font.BOLD, 14));
        jl3.setForeground(Color.black);
        down.add(jl3);
        //�����������
        out1 = new JTextField();
        out1.setBounds(75, 310, 500, 50);
        out1.setFont(new Font("����",Font.ITALIC,20));
        down.add(out1);

        frame.add(top);
        frame.add(down);
        //�Ƿ�������ʾ
        frame.setVisible(true);
    }
}
