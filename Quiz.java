// This class represents the quiz system
// Based on quiz flowchart from system design

import java.util.Scanner;

public class Quiz {

    private int score;
    private int totalQuestions;

    public Quiz(){
        score = 0;
        totalQuestions = 5;
    }

    // starts the quiz
    public void startQuiz(){
        Scanner input = new Scanner(System.in);

        String[] questions = {
                "What should you do if you think your drink has been spiked?",
                "Which of these can be a warning sign?",
                "Should you leave your drink unattended?",
                "Who should you tell if you feel unsafe?",
                "What should you do if someone appears unwell?"};

        String[][] options = {

                {
                        "a) Tell someone you trust",
                        "b) Ignore it",
                        "c) Do nothing"
                },
                {
                        "a) Feeling unusually unwell",
                        "b) Feeling completely normal",
                        "c) Nothing",
                },
                {
                        "a) Yes",
                        "b) Sometimes",
                        "c) No",
                },
                {
                        "a) A trusted person or staff member",
                        "b) Nobody",
                        "c) Ignore it",
                },
                {
                        "a) Leave them alone",
                        "b) Get appropriate help",
                        "c) Ignore them",
                }
        };
        String[] correctAnswers = {
                "a",
                "a",
                "c",
                "a",
                "b",
        };

        score =0;
        System.out.println("\n=================================");
        System.out.println("         AWARENESS QUIZ      ");
        System.out.println("====================================");

        for (int i = 0; i< totalQuestions; i++) {
            System.out.println("\nQuestion" + (i + 1));
            System.out.println(questions[i]);

            for (int j = 0; j < options[i].length; j++) {

                System.out.println(options[i][j]);
            }

            String answer;

            // validate users answer
            while (true) {
                System.out.println("Your Answer: ");

                answer = input.nextLine().toLowerCase();

                if (answer.equals("a") || answer.equals("b") || answer.equals("c")) {
                    break;
                }

                System.out.println("Invalid answer. Please enter a, b or c.");
            }

            if (answer.equals(correctAnswers[i])) {
                score++;
                System.out.println("Correct!");

            } else {
                System.out.println("Incorrect.");
            }
        }

        showResult();
    }

    public void showResult() {

        double percentage = (score / (double) totalQuestions) * 100;

        System.out.println("\n==================================");
        System.out.println("               QUIZ RESULT            ");
        System.out.println("====================================");

        System.out.println("Score: " + score + "/" + totalQuestions);

        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 60) {
            System.out.println("Good work! You have a good understanding.");

        } else {
            System.out.println("You may want to review the awareness resources.");
        }
    }

    public int getScore(){
        return score;
    }
}



