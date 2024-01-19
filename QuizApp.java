import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOptionIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        for (Question question : questions) {
            displayQuestion(question);
            int selectedOption = getUserChoice();
            if (question.isCorrect(selectedOption)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect!\n");
            }
        }
        displayResult();
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt() - 1;
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<Question> quizQuestions = new ArrayList<>();
       List<String> options1 = List.of("5", "6", "7", "8");
        Question question1 = new Question("What is 4 + 4?", options1, 3);
        quizQuestions.add(question1);
        
        List<String> options2 = List.of("Dog", "Cat", "Horse", "Elephant");
        Question question2 = new Question("Which animal is known as 'man's best friend'?", options2, 0);
        quizQuestions.add(question2);

        List<String> options3 = List.of("Tokyo", "Seoul", "Beijing", "Shanghai");
        Question question3 = new Question("Which city is the capital of Japan?", options3, 0);
        quizQuestions.add(question3);

        List<String> options4 = List.of("Mount Everest", "K2", "Matterhorn", "Kangchenjunga");
        Question question4 = new Question("Which is the tallest mountain in the world?", options4, 0);
        quizQuestions.add(question4);

        List<String> options5 = List.of("Oxygen", "Carbon Dioxide", "Nitrogen", "Helium");
        Question question5 = new Question("What is the most abundant gas in Earth's atmosphere?", options5, 2);
        quizQuestions.add(question5);
        // Add more questions...

        Quiz quiz = new Quiz(quizQuestions);
        quiz.startQuiz();
    }
}
