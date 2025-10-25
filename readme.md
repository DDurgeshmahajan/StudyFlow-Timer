```markdown
# Customizable Study Timer

## Short Description
The **Customizable Study Timer** is a Java application designed to help you manage your study sessions more effectively. Whether you're a student, a professional, or anyone looking to boost productivity, this timer allows you to set custom durations for study periods, short breaks, and long breaks. It also provides a user-friendly interface with options to start, pause, reset, and skip phases.

## Features
- **Customizable Durations:** Set your own study, short break, and long break durations.
- **Session Management:** Track your study sessions and automatically switch between phases.
- **User Interface:** A simple and intuitive graphical user interface (GUI) for easy control.
- **Settings Dialog:** Save and load your preferred settings.
- **Alerts:** Be notified when the phase changes with a beep and a dialog message.

## Usage Instructions
1. **Clone or Download the Repository:**
   - Clone the repository using Git:
     ```sh
     git clone https://github.com/DDurgeshmahajan/Customizable-Study-Timer.git
     ```
   - Or, download the project as a ZIP file and extract it.

2. **Set Up the Project:**
   - Ensure you have Java installed on your system. You can check by running:
     ```sh
     java -version
     ```
   - If Java is not installed, download and install it from the official website.

3. **Run the Application:**
   - Navigate to the project directory:
     ```sh
     cd Customizable-Study-Timer
     ```
   - Compile the Java files:
     ```sh
     javac Main.java StudyTimerLogic.java TimerPanel.java SettingsManager.java SettingsDialog.java
     ```
   - Run the application:
     ```sh
     java Main
     ```

4. **Using the Timer:**
   - **Start Timer:** Click the "Start" button to begin your study session.
   - **Pause/Resume Timer:** Click "Pause" to pause the timer and "Resume" to continue.
   - **Reset Timer:** Click "Reset" to restart the timer from the beginning.
   - **Skip Phase:** Click "Skip" to move to the next phase immediately.
   - **Settings:** Click "File" > "Settings" to open the settings dialog and customize your timer durations.

## Dependencies
- **Java Development Kit (JDK) 8 or higher:** Required to compile and run the Java application.

## Example/Preview
- **Initial View:**
  - The timer displays the study duration, current phase, and session count.
- **After Starting:**
  - The timer starts counting down, and the phase label updates accordingly.
- **Phase Change:**
  - When the study duration ends, a beep sound is played, and a dialog message notifies you of the phase change.

## Contact / Author
- **Name:** Durgesh Mahajan
- **Email:** ashamahajan955@gmail.com

If you have any questions, suggestions, or feedback, feel free to reach out!

## Credits
This project was created by Durgesh Mahajan. Special thanks to the open-source community for their contributions and support.
```

### Additional Notes
- **Feedback:** Your feedback is highly appreciated and will help improve the project.
- **Contribution:** If you would like to contribute to the project, please fork the repository and submit a pull request.
- **License:** This project is licensed under the MIT License. See the `LICENSE` file for more details.