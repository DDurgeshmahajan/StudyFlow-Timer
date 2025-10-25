import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsManager {
    private static final String SETTINGS_FILE = "settings.txt";
    private Properties properties;

    public SettingsManager() {
        properties = new Properties();
        loadSettings();
    }

    public void loadSettings() {
        try (FileInputStream input = new FileInputStream(SETTINGS_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSettings(int studyDuration, int shortBreakDuration, int longBreakDuration, int sessionsBeforeLongBreak) {
        properties.setProperty("studyDuration", String.valueOf(studyDuration));
        properties.setProperty("shortBreakDuration", String.valueOf(shortBreakDuration));
        properties.setProperty("longBreakDuration", String.valueOf(longBreakDuration));
        properties.setProperty("sessionsBeforeLongBreak", String.valueOf(sessionsBeforeLongBreak));
        try (FileOutputStream output = new FileOutputStream(SETTINGS_FILE)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getStudyDuration() {
        return Integer.parseInt(properties.getProperty("studyDuration", "25"));
    }

    public int getShortBreakDuration() {
        return Integer.parseInt(properties.getProperty("shortBreakDuration", "5"));
    }

    public int getLongBreakDuration() {
        return Integer.parseInt(properties.getProperty("longBreakDuration", "15"));
    }

    public int getSessionsBeforeLongBreak() {
        return Integer.parseInt(properties.getProperty("sessionsBeforeLongBreak", "4"));
    }
}