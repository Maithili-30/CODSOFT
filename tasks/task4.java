import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizProgram {
    private static Map<String, String[]> questions;
    private static int score = 0;

    public static void main(String[] args) {
        initializeQuestions();
        presentQuestions();
        displayResult();
    }

    private static void initializeQuestions() {
        questions = new HashMap<>();
        questions.put("What is the capital of France?", new String[]{"A. Paris", "B. London", "C. Berlin", "D. Rome"});
        questions.put("What is the largest planet in the solar system?", new String[]{"A. Mars", "B. Jupiter", "C. Venus", "D. Saturn"});
        // Add more questions and options
    }

    private static void presentQuestions() {
        for (Map.Entry<String, String[]> entry : questions.entrySet()) {
            String question = entry.getKey();
            String[] options = entry.getValue();

            System.out.println(question);
            for (String option : options) {
                System.out.println(option);
            }

            startTimer(10); // 10 seconds to answer each question

            String userAnswer = getUserInput();
            checkAnswer(entry, userAnswer);
        }
    }

    private static void startTimer(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("Time's up!");
                timer.cancel();
            }
        }, seconds * 1000);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your answer (Enter the option letter): ");
        return scanner.nextLine().toUpperCase();
    }

    private static void checkAnswer(Map.Entry<String, String[]> entry, String userAnswer) {
        String[] options = entry.getValue();
        String correctAnswer = options[0].substring(0, 1);
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
    }

    private static void displayResult() {
        System.out.println("Your final score is: " + score + "/" + questions.size());
    }
}
