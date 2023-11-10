/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package case_study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author Kowkie
 */
public class Create implements ActionListener, Runnable{
    public int lvl = 0,score = 0;
    private static final String  BACK = "Back";
    private static final String  EXIT = "Exit";
    private int  counter;
    private JFrame  frame;
    private JPanel  panel;
    private GridBagConstraints cons;
    private int[] mine = {};
   

    @Override // java.awt.event.ActionListener
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        switch (actionCommand) {
            case BACK:
                break;
            case EXIT:
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(frame,
                                              actionCommand,
                                              "Unhandled",
                                              JOptionPane.WARNING_MESSAGE);
        }
        
            
    }

    @Override // java.lang.Runnable
    public void run() {
        JOptionPane.showMessageDialog(null,String.valueOf(lvl));
        createGui();
     
        Checker chk = new Checker();
        mine = chk.CheckMines(lvl);
        while(counter != 36)
        {
            addButton();
        }
        
    }

    private void addButton() {
        JButton button = new JButton("");
//        String.valueOf(++counter)
        ++counter;
        Dimension size = new Dimension(50, 50);
        button.setMaximumSize(size);
        button.setMinimumSize(size);
        button.setPreferredSize(size);
        
        for(int x=0;x< mine.length;x++){
             JOptionPane.showMessageDialog(null,mine[x]);
            if(counter == mine[x])
            {
                 button.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JOptionPane.showMessageDialog(null,"Bomba!!");
                         button.setEnabled(false);
                         
                     }
                 });
                 break;
                 
            }else{
                button.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        button.setEnabled(false);
                        score +=1;
//                        JOptionPane.showMessageDialog(null,score);
                     }
                 });
            }
    }
        
        cons = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();
        JPanel gridbag = new JPanel( gb);
               gridbag.setSize(size);
        cons.fill = GridBagConstraints.BOTH;
        gb.setConstraints(frame, cons);
         gridbag.add(button);
        panel.add(gridbag);
        panel.revalidate();
    }

    private JButton createButton(String text, int mnemonic, String tooltip) {
        JButton button = new JButton(text);
        button.setMnemonic(mnemonic);
        button.setToolTipText(tooltip);
        button.addActionListener((ActionListener) this);
        return button;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(createButton(BACK, KeyEvent.VK_B, "Add button to panel"));
        buttonsPanel.add(createButton(EXIT, KeyEvent.VK_X, "Exit the application"));
        return buttonsPanel;
    }

    private void createGui() {
        frame = new JFrame("Minesweeper");
        frame.setMaximumSize(new Dimension(500,500));
        frame.setMinimumSize(new Dimension(500,500));
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createPanel(), BorderLayout.CENTER);
         frame.add(createButtonsPanel(), BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JPanel createPanel() {
        panel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
//       GridLayout mgr = new GridLayout(6,6);
//       mgr.setHgap(0);
//       mgr.setVgap(0);
        GridLayout gb = new GridLayout(6,6);
        gb.setHgap(0);
        gb.setVgap(0);
        
        panel.setLayout(gb);
        panel.setSize(new Dimension(300,300));
        panel.setBorder(blackline);
        return panel;
    }
}
