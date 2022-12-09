package com.sxwl.view;

import com.sun.awt.AWTUtilities;
import com.sxwl.controller.WindowDrag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

/**
 * @author Spring-Xa
 */
public class Scale {
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
     * �����¼�
     */
    class Listener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(tf1.getText().trim());
            out1.setText(binary(num1));
        }
    }
    class Listener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num1=Integer.parseInt(tf1.getText().trim());
            out1.setText(octal(num1));
        }
    }
    class Listener3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num1=Integer.parseInt(tf1.getText().trim());
            out1.setText(hexadecimal(num1));
        }
    }
    /**
     * ������
     * ����һ��StringBuilder���洢����
     */
    public String binary(int num){
        StringBuilder binaryNum= new StringBuilder();
        //���Ʒ�Χ
        int [] arr=new int[32];
        //��������β�Ϊ0����ƴ�Ӻ�0����
        if(num==0) {
            return binaryNum+"0";
        } else{
            // �������num == 30����
            //  v = 0,a[31] = 0,num = 15;
            //  v = 1,a[30] = 1,num = 7;
            //  v = 1,a[29] = 1,num = 3;
            //  v = 1,a[28] = 1,num = 1;
            //  v = 1,a[27] = 1,num = 0;
            //  v = 0,a[26] = 0;
            //  ����
            for(int  i=31;i>=0;i--)
            {
                int v = num & 1;
                arr[i]=v;
                num=num>>1;
                //num = 0
            }
            //����arr[i]��ֵ���j��ֵ
            //��arr[i] == 0 �� arr[i + 1] != 0 ʱ
            // j ���� i + 1
            int j = 0;
            for (int i = 0; i < 32; i++) {
                if (arr[i] == 0 && arr[i + 1] != 0) {
                    j = i + 1;
                    break;
                }
            }
            //ʹ��append������binaryNum�е�ĩβ����arr[i]������
            for(int i=j;i<32;i++ )
            {
                binaryNum.append(arr[i]);
            }
            return binaryNum.toString();
        }
    }

    /**
     * �˽���
     */
    public String octal(int num){
        StringBuilder octalNum= new StringBuilder("0");
        int [] arr=new int[11];
        int  v,j=0;
        if(num==0) {
            return octalNum+"0";
        } else{
            for(int  i=10;i>=0;i--)
            {
                v=num&7;
                arr[i]=v;
                num=num>>3;
            }
            for (int i = 0; i < 11; i++) {
                if (arr[i] == 0 && arr[i + 1] != 0) {
                    j = i + 1;
                    break;
                }
            }
            for(int i=j;i<11;i++ )
            {
                octalNum.append(arr[i]);
            }
            return octalNum.toString();
        }
    }
    /**
     * ʮ������
     */
    public String hexadecimal(int num){
        StringBuilder hexadecimalNum= new StringBuilder("0x");
        char [] str={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int [] arr=new int[8];
        int  v,j=0;
        if(num==0) {
            return hexadecimalNum+"0";
        } else
        {
            for(int  i=7;i>=0;i--)
            {
                v=num&15;
                arr[i]=v;
                num=num>>4;
            }
            for (int i = 0; i < 8; i++) {
                if (arr[i] == 0 && arr[i + 1] != 0) {
                    j = i + 1;
                    break;
                }
            }
            for(int i=j;i<8;i++ )
            {
                hexadecimalNum.append(str[arr[i]]);
            }
            return hexadecimalNum.toString();
        }
    }
    public static JFrame frame = new JFrame();
    public Scale(){

        WindowDrag windowdrag = new WindowDrag(frame);
        frame.setTitle("�๦�ܼ�����");
        //���ڵĴ�С
        frame.setSize(600, 330);
        //���ܷŴ���С
        frame.setResizable(false);
        //�򿪺���ֵ�λ��
        frame.setLocationRelativeTo(null);
        //�����ɫ
        frame.getContentPane().setBackground(Color.white);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Scientific.class.getResource("/com/sun/javafx/scene/web/skin/OrderedListNumbers_16x16_JFX.png")));
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
        top.setBounds(0 ,0 ,600, 50);
        top.setBackground(new Color(255, 255, 255));
        top.addMouseListener(windowdrag);
        top.addMouseMotionListener(windowdrag);
        //����
        JLabel label = new JLabel("����ʮת������");
        label.setBounds(20,15,240,25);
        label.setFont(new Font("����",Font.BOLD, 20));
        label.setForeground(Color.black);
        top.add(label);

        //���ذ�ť
        JButton back = new JButton("����");
        back.setBounds(500,15,100,25);
        back.setFont(new Font("����",Font.BOLD, 20));
        back.setOpaque(false);
        back.setBackground(Color.white);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        top.add(back);
        BackOpen bo = new BackOpen();
        back.addActionListener(bo);

        //�����
        JPanel down = new JPanel();
        down.setLayout(null);
        down.setBounds(0 ,100 ,600, 110);
        down.setBackground(new  Color(235, 237, 238));

        //��������
        JLabel jl1,jl3;
        jl1 = new JLabel("ʮ������");
        jl1.setBounds(10,100,100,50);
        jl1.setFont(new Font("����",Font.BOLD, 14));
        jl1.setForeground(Color.black);
        down.add(jl1);
        //�����
        tf1 = new JTextField();
        tf1.setBounds(75, 100, 500, 50);
        tf1.setFont(new Font("����",Font.ITALIC,20));
        down.add(tf1);
        //���㰴ť
        jb1= new JButton("������");
        jb2= new JButton("�˽���");
        jb3= new JButton("ʮ������");
        jb1.setBounds(80,235,150,60);
        jb2.setBounds(250,235,150,60);
        jb3.setBounds(420,235,150,60);
        jb1.setBackground(new  Color(248, 248, 248));
        jb2.setBackground(new  Color(248, 248, 248));
        jb3.setBackground(new  Color(248, 248, 248));
        jb1.setForeground(Color.black);
        jb2.setForeground(Color.black);
        jb3.setForeground(Color.black);
        jb1.setFont(new Font("����",Font.BOLD, 20));
        jb2.setFont(new Font("����",Font.BOLD, 20));
        jb3.setFont(new Font("����",Font.BOLD, 20));
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

        //����������
        jl3 = new JLabel("���");
        jl3.setBounds(30,175,100,50);
        jl3.setFont(new Font("����",Font.BOLD, 14));
        jl3.setForeground(Color.black);
        down.add(jl3);
        //�����������
        out1 = new JTextField();
        out1.setBounds(75, 175, 500, 50);
        out1.setFont(new Font("����",Font.ITALIC,20));
        down.add(out1);

        frame.add(top);
        frame.add(down);
        //�Ƿ�������ʾ
        frame.setVisible(true);
    }
}
