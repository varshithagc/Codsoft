package quiz;
import java.util.Scanner;
public class QuizApplication {
    private static final int QUESTION_TIME_LIMIT_SECONDS = 10;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
                String[] questions = {
            "Which is the capital city of Karnataka?",
            "Who is the author of 'Romeo and Juliet'?",
            "What is the name of India's National Bird?"
        };
        String[][] options = {
            {"A) Bengaluru", "B) Mysore", "C) Mangalore"},
            {"A) William Shakespeare", "B) Jane Austen", "C) Charles Dickens"},
            {"A) Eagle", "B) Peacock", "C) Parrota"}
        };
        char[] answers = {'A', 'A', 'B'};
        int score = 0;
        int correctAnswers = 0;
        int incorrectAnswers = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            Timer timer = new Timer(QUESTION_TIME_LIMIT_SECONDS);
            Thread timerThread = new Thread(timer);
            timerThread.start();
            System.out.print("Your answer: ");
            String userInput = scanner.nextLine().toUpperCase();
            timer.stopTimer();
            if (userInput.length() > 0 && userInput.charAt(0) == answers[i]) {
                System.out.println("Correct!");
                score++;
                correctAnswers++;
            } else {
                System.out.println("Incorrect! The correct answer is " + answers[i]);
                incorrectAnswers++;
            }
            System.out.println();
        }
        System.out.println("Quiz completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Incorrect Answers: " + incorrectAnswers);
        scanner.close();
    }
    static class Timer implements Runnable {
        private int timeLimitSeconds;
        private boolean running;
        Timer(int timeLimitSeconds) {
            this.timeLimitSeconds = timeLimitSeconds;
            this.running = true;
        }
        @Override
        public void run() {
            for (int i = 0; i < timeLimitSeconds; i++) {
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                if (!running) {
                    return;
                }
            }
            System.out.println("\nTime's up!");
            scanner.nextLine(); 
            System.exit(0); 
        }
        void stopTimer() {
            running = false;
        }
    }
}
