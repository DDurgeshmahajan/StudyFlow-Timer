/*
Author: Durgesh Mahajan
Date: <current date>
Project: Customizable Study Timer
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Customizable Study Timer");
            TimerPanel timerPanel = new TimerPanel();
            frame.add(timerPanel, BorderLayout.CENTER);

            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            JMenuItem settingsItem = new JMenuItem("Settings");
            settingsItem.addActionListener(e -> {
                SettingsDialog settingsDialog = new SettingsDialog(frame);
                settingsDialog.setVisible(true);
            });
            fileMenu.add(settingsItem);
            menuBar.add(fileMenu);
            frame.setJMenuBar(menuBar);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}