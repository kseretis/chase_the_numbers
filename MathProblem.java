import java.util.*;
import greenfoot.*;
/**
 * A class based on Singleton pattern, created for math problem that is appearing
 * at the top right of the screen
 * 
 * @author Seretis Kleanthis 
 * @version 1
 * @date 05/06/2022
 */
public class MathProblem extends Actor{
    private static MathProblem instance = null;
    private static List<MathModel> problems = new ArrayList<>();
    private static MathModel currentMathProblem;
    private static int mathProblemCounter;
    //act
    public void act(){
        setImage(new GreenfootImage(getLevelMathProblem().getProblem() + " = ?", 50, Color.BLACK, Color.WHITE));
    }
    // Constructor
    private MathProblem(){
        generateMathProblems();
        mathProblemCounter = 0;
        currentMathProblem = problems.get(mathProblemCounter);
    }
    /**
     * Static section
     */
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
    // Generates for the very first time the math problems
    private static void generateMathProblems(){
        for(int i=1; i<=2; i++) //FIXME
            problems.add(generateMathProblem(i));
    }
    // Generates problems based on level
    private static MathModel generateMathProblem(int level){
        MathModel model = new MathModel(level);
        int[] answers;
        switch (level){
            case 1:
                model.setProblem("4 + 3");
                model.setSolution(7);
                answers = new int[]{2, 3, 4, 5, 7};
                addAnswers(answers, model);
                break;
            case 2:
                model.setProblem("19 - 11");
                model.setSolution(8);
                answers = new int[]{5, 11, 8, 4, 13};
                addAnswers(answers, model);
                break;
            case 3:
            case 4:
            case 5:
        }
        return model;
    }
    // Adds answer as trophy instances to the model
    private static void addAnswers(int[] answers, MathModel model){
        for(int answer: answers)
            model.addAnswer(answer);
        model.setTrophyAnswers();
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
}
