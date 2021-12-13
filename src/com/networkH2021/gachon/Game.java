package com.networkH2021.gachon;

import com.networkH2021.gachon.client.ChatClientApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game extends JFrame{

    ImageIcon[] imgIcons = {
            new ImageIcon("IMG/kawi.jpg"),
            new ImageIcon("IMG/bawi.jpg"),
            new ImageIcon("IMG/bo.jpg")
    };

    SelectPanel select = new SelectPanel();
    ResultDisplay result = new ResultDisplay();
    ChatPanel chat = new ChatPanel();

    public Game() {
        super("RSC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(result,"Center");
        add(select, "South");
        add(chat, "East");

        setSize(900,600);
        setVisible(true);
    }

    class SelectPanel extends JPanel{
        JButton[] btnButtons = new JButton[3];

        public SelectPanel() {
            setBackground(Color.gray);

            for(int i=0; i<imgIcons.length; i++) {
                btnButtons[i] = new JButton(imgIcons[i]);
                this.add(btnButtons[i]);

                btnButtons[i].addActionListener(new EventHandler());
            }
        }
    }

    class ResultDisplay extends JPanel{
        JLabel userJLabel = new JLabel("user1");
        JLabel comJLabel = new JLabel("user2");
        JLabel resultJLabel = new JLabel("winner");

        public ResultDisplay() {
            setBackground(Color.white);
            add(userJLabel);
            add(resultJLabel);
            add(comJLabel);
        }
        public void output(Icon img,Icon comImage, String res ) {
            userJLabel.setIcon(img);
            userJLabel.setHorizontalTextPosition(JLabel.LEFT);
            comJLabel.setIcon(comImage);
            resultJLabel.setText(res);
            result.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        }
    }

    class ChatPanel extends JPanel {

        public ChatPanel() {

        }
    }

        class EventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Object 타입임으로 타입변환을 해야한다.
            JButton btnSrc = (JButton)e.getSource();
            int selCom = (int)(Math.random()*3); // 0:가위  1:바위, 2:보
            String res = "";

            if(btnSrc.getIcon() == imgIcons[0] && selCom == 2 ||
                    btnSrc.getIcon() == imgIcons[1] && selCom == 0 ||
                    btnSrc.getIcon() == imgIcons[2] && selCom == 1 )
                res = "USER1 WIN!";
            else if(btnSrc.getIcon() == imgIcons[0] && selCom == 0 ||
                    btnSrc.getIcon() == imgIcons[1] && selCom == 1 ||
                    btnSrc.getIcon() == imgIcons[2] && selCom == 2 )
                res = "DRAW!!";
            else
                res = "USER1 LOSE";
            result.output(btnSrc.getIcon(), imgIcons[selCom], res);
        }

    }


}