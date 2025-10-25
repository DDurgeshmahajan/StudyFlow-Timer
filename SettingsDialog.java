import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog extends JDialog {
    private JTextField studyDurationField;
    private JTextField shortBreakDurationField;
    private JTextField longBreakDurationField;
    private JTextField sessionsBeforeLongBreakField;
    private SettingsManager settingsManager;

    public SettingsDialog(JFrame parent) {
        super(parent, "Settings", true);
        settingsManager = new SettingsManager();
        initializeUI();
        pack();
        setLocationRelativeTo(parent);
    }

    private void initializeUI() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Study Duration (minutes):"));
        studyDurationField = new JTextField(String.valueOf(settingsManager.getStudyDuration()));
        add(studyDurationField);

        add(new JLabel("Short Break Duration (minutes):"));
        shortBreakDurationField = new JTextField(String.valueOf(settingsManager.getShortBreakDuration()));
        add(shortBreakDurationField);

        add(new JLabel("Long Break Duration (minutes):"));
        longBreakDurationField = new JTextField(String.valueOf(settingsManager.getLongBreakDuration()));
        add(longBreakDurationField);

        add(new JLabel("Sessions Before Long Break:"));
        sessionsBeforeLongBreakField = new JTextField(String.valueOf(settingsManager.getSessionsBeforeLongBreak()));
        add(sessionsBeforeLongBreakField);

        JButton saveButton = new JButton("Save Settings");
        saveButton.addActionListener(e -> {
            try {
                int studyDuration = Integer.parseInt(studyDurationField.getText().trim());
                int shortBreakDuration = Integer.parseInt(shortBreakDurationField.getText().trim());
                int longBreakDuration = Integer.parseInt(longBreakDurationField.getText().trim());
                int sessionsBeforeLongBreak = Integer.parseInt(sessionsBeforeLongBreakField.getText().trim());

                if (studyDuration > 0 && shortBreakDuration > 0 && longBreakDuration > 0 && sessionsBeforeLongBreak > 0) {
                    settingsManager.saveSettings(studyDuration, shortBreakDuration, longBreakDuration, sessionsBeforeLongBreak);
                    JOptionPane.showMessageDialog(this, "Settings saved successfully!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "All durations must be positive integers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(saveButton);
    }
}