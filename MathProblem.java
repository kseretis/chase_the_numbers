import java.util.*;
import java.util.stream.Collectors;
import greenfoot.*;

public class MathProblem extends Actor{
    private static MathProblem instance = null;
    private static List<MathModel> problems = new ArrayList<>();
    private static MathModel currentMathProblem;
    private static int mathProblemCounter;

    /**
     * Act - do whatever the Math wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    private MathProblem(){
        generateMathProblems();
        mathProblemCounter = 0;
        currentMathProblem = problems.get(mathProblemCounter);
    }

    public static MathProblem getInstance(){
        if(instance == null)
            instance = new MathProblem();
        return instance;
    }
    
    public static MathModel getLevelMathProblem(){
        return problems.get(mathProblemCounter);
    }
    
    public void setMathProblemImg(){
        setImage(new GreenfootImage(getLevelMathProblem().getProblem() + " = ?", 50, Color.BLACK, Color.WHITE));
    }

    public static void generateMathProblems(){
        for(int i=1; i<=2; i++) //FIXME
            problems.add(generateMathProblem(i));
    }

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
    
    private static void castModel(MathModel model){
        /*model.setProblem("4 + 3");
        model.setSolution(7);
        int[] answers = {2, 3, 4, 5, 7};
        for(int answer: answers)
            model.addAnswer(answer);
        model.setTrophyAnswers();*/
    }
    
    private static void addAnswers(int[] answers, MathModel model){
        for(int answer: answers)
            model.addAnswer(answer);
        model.setTrophyAnswers();
    }
    
    public static void updateMathProblem(){
        mathProblemCounter++;
        currentMathProblem = problems.get(mathProblemCounter);
    }
}
