import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerPanel extends JPanel {
    private StudyTimerLogic timer;
    private JLabel timerLabel;
    private JLabel phaseLabel;
    private JLabel sessionLabel;
    private JButton startButton;
    private JButton pauseResumeButton;
    private JButton resetButton;
    private JButton skipButton;

    public TimerPanel() {
        timer = new StudyTimerLogic(25, 5, 15, 4);
        timer.setActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("TICK")) {
                    updateTimerDisplay();
                } else if (e.getActionCommand().equals("NEXT_PHASE")) {
                    updatePhaseDisplay();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(TimerPanel.this, "Phase changed to: " + timer.getCurrentPhase());
                } else if (e.getActionCommand().equals("RESET")) {
                    updateTimerDisplay();
                    updatePhaseDisplay();
                }
            }
        });

        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(5, 1));

        timerLabel = new JLabel(formatTime(timer.getRemainingTime()), SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(timerLabel);

        phaseLabel = new JLabel(timer.getCurrentPhase(), SwingConstants.CENTER);
        phaseLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(phaseLabel);

        sessionLabel = new JLabel("Session 0/4", SwingConstants.CENTER);
        sessionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(sessionLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startButton = new JButton("Start");
        startButton.addActionListener(e -> timer.start());
        buttonPanel.add(startButton);

        pauseResumeButton = new JButton("Pause");
        pauseResumeButton.addActionListener(e -> {
            if (pauseResumeButton.getText().equals("Pause")) {
                timer.pause();
                pauseResumeButton.setText("Resume");
            } else {
                timer.resume();
                pauseResumeButton.setText("Pause");
            }
        });
        buttonPanel.add(pauseResumeButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> timer.reset());
        buttonPanel.add(resetButton);

        skipButton = new JButton("Skip");
        skipButton.addActionListener(e -> timer.skip());
        buttonPanel.add(skipButton);

        add(buttonPanel);
    }

    private void updateTimerDisplay() {
        timerLabel.setText(formatTime(timer.getRemainingTime()));
    }

    private void updatePhaseDisplay() {
        phaseLabel.setText(timer.getCurrentPhase());
        sessionLabel.setText("Session " + timer.getCurrentSession() + "/" + timer.getSessionsBeforeLongBreak());
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}