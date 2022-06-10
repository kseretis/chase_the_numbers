import java.util.*;
import greenfoot.*;
import java.lang.*;

/**
 * A class based on Singleton pattern, created for math problem that is appearing
 * at the top right of the screen
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 05/06/2022
 */
public class MathProblem extends Actor{
    private static MathProblem instance = null;
    private static List<MathModel> problems = new ArrayList<>();
    private static MathModel currentMathProblem;
    private static int mathProblemCounter;
    private static final Color lettersColor = new Color(0, 90, 43);
    /**
     * Constructor for objects of class MathProblem
     */
    private MathProblem(){
        generateMathProblems();
        restartMathProblem();
    }
    // act
    public void act(){
        setImage(new GreenfootImage(getLevelMathProblem().getProblem() + " = ?", 32, Color.WHITE, lettersColor));
    }
    // Generates for the very first time the math problems
    private void generateMathProblems(){
        for(int i=1; i<=Level.MAXIMUM_LEVEL; i++) 
            problems.add(generateMathProblem(i));
    }
    // Generates problems based on level
    private MathModel generateMathProblem(int level){
        MathModel model = new MathModel(level);
        HashSet<Integer> answers = new HashSet<>();
        switch (level){
            case 1:
                model.setProblem("4 + 3");
                model.setSolution(7);
                break;
            case 2:
                model.setProblem("19 - 11");
                model.setSolution(8);
                break;
            case 3:
                model.setProblem("18 - 7 + 3");
                model.setSolution(14);
                break;
            case 4:
                model.setProblem("2 * 6");
                model.setSolution(12);
                break;
            case 5:
                model.setProblem("10 / 5");
                model.setSolution(2);
                break;
            case 6:
                model.setProblem("10 / 2");
                model.setSolution(5);
                break;
            case 7:
                model.setProblem("(2 * 4) + 5");
                model.setSolution(13);
                break;
            case 8:
                model.setProblem("19 - 22 + 4");
                model.setSolution(1);
                break;
            case 9:
                model.setProblem("12 / (20 - 17)");
                model.setSolution(4);
                break;
            case 10:
                model.setProblem("1 + 2 * 4");
                model.setSolution(9);
                break;
        }
        answers.add(model.getSolution());
        model.setAnswers(getRandomAnswers(answers));
        model.setNumbers();
        return model;
    }
    // Returns a set with integers with random numbers in a standard range
    private HashSet<Integer> getRandomAnswers(HashSet<Integer> answers){
        while(answers.size() < MathModel.MAXIMUM_ANSWERS){
            answers.add(Greenfoot.getRandomNumber(MathModel.ANSWER_RANGE) + 1); 
        }
        return answers;
    }
    /**********************************************
     * Static Section
     **********************************************/
    // Instance of the math problem
    public static MathProblem getInstance(){
        if(instance == null)
            instance = new MathProblem();
        return instance;
    }
    // Returns the current math problem
    public static MathModel getLevelMathProblem(){
        return currentMathProblem;
    }
    // Updates the current math problem and also the counter 
    public static void updateMathProblem(){
        mathProblemCounter++;
        try {
            currentMathProblem = problems.get(mathProblemCounter);
        }catch(Exception e){
            currentMathProblem = null;
        }
    }
    // Restart math problem
    public static void restartMathProblem(){
        mathProblemCounter = 0;
        currentMathProblem = problems.get(mathProblemCounter);
    }
}
