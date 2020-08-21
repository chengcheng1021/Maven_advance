package com.cc.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestPanel {

    public static void main(String[] args) {
        Frame frame = new Frame("中秋节快乐");//新建一个窗体
        Panel panel = new Panel(null);//面板
        frame.setLayout(null);//设置窗体布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(Color.WHITE);

        panel.setBounds(50,50,300,300);
        panel.setBackground(Color.GREEN);

        frame.add(panel);
        frame.setVisible(true);

        //监听事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
