package com.networkH2021.gachon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLobby extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton Rankbutton;
    private JButton Sendbutton;
    private JButton INFOButton5;
    private JButton INFOButton4;
    private JButton INFOButton;
    private JButton INFOButton3;
    private JButton INFOButton2;
    private JButton INFOButton1;
    private JButton INVITEButton;
    private JButton INVITEButton1;
    private JButton INVITEButton2;
    private JButton INVITEButton3;
    private JButton INVITEButton4;
    private JButton INVITEButton5;
    private JPanel panelLobby;

    public MainLobby(){

        setTitle("RSP Online Main Lobby");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(this.panelLobby);
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
        Rankbutton.addActionListener(new ActionListener() {//Rank버튼 눌렀을때 실행됨
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLauncher.getRank().setVisible(true);
            }
        });
    }
}
