import java.util.Timer;
import java.util.TimerTask;

public class StudyTimerLogic {
    public static final String STUDY = "STUDY";
    public static final String SHORT_BREAK = "SHORT_BREAK";
    public static final String LONG_BREAK = "LONG_BREAK";

    private Timer timer;
    private TimerTask timerTask;
    private int studyDuration;
    private int shortBreakDuration;
    private int longBreakDuration;
    private int sessionsBeforeLongBreak;
    private int currentSession;
    private boolean isRunning;
    private String currentPhase;
    private int remainingTime;
    private ActionListener actionListener;

    public StudyTimerLogic(int studyDuration, int shortBreakDuration, int longBreakDuration, int sessionsBeforeLongBreak) {
        this.studyDuration = studyDuration;
        this.shortBreakDuration = shortBreakDuration;
        this.longBreakDuration = longBreakDuration;
        this.sessionsBeforeLongBreak = sessionsBeforeLongBreak;
        this.currentSession = 0;
        this.isRunning = false;
        this.currentPhase = STUDY;
        this.remainingTime = studyDuration * 60;
        this.timer = new Timer();
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (remainingTime > 0) {
                        remainingTime--;
                        if (actionListener != null) {
                            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "TICK"));
                        }
                    } else {
                        nextPhase();
                    }
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        }
    }

    public void pause() {
        if (isRunning) {
            timer.cancel();
            timer = new Timer();
            isRunning = false;
        }
    }

    public void resume() {
        if (!isRunning) {
            start();
        }
    }

    public void reset() {
        pause();
        currentSession = 0;
        currentPhase = STUDY;
        remainingTime = studyDuration * 60;
        if (actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "RESET"));
        }
    }

    public void skip() {
        nextPhase();
    }

    private void nextPhase() {
        if (currentPhase.equals(STUDY)) {
            currentSession++;
            if (currentSession == sessionsBeforeLongBreak) {
                currentPhase = LONG_BREAK;
                remainingTime = longBreakDuration * 60;
                currentSession = 0;
            } else {
                currentPhase = SHORT_BREAK;
                remainingTime = shortBreakDuration * 60;
            }
        } else {
            currentPhase = STUDY;
            remainingTime = studyDuration * 60;
        }
        if (actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "NEXT_PHASE"));
        }
    }

    public String getCurrentPhase() {
        return currentPhase;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getCurrentSession() {
        return currentSession;
    }

    public int getSessionsBeforeLongBreak() {
        return sessionsBeforeLongBreak;
    }
}