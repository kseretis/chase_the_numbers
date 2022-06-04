import java.util.ArrayList;
import java.util.List;
import greenfoot.*;

public class MathProblem extends Actor{
    private static MathProblem instance = null;
    private static List<MathModel> problems = new ArrayList<>();

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
    }

    public static MathProblem getInstance(){
        if(instance == null)
            instance = new MathProblem();
        return instance;
    }

    public String getLevelMathProblem(){
        return problems.get(Level.getLevel()).getProblem();
    }
    
    public void setMathProblemImg(){
        setImage(new GreenfootImage(getLevelMathProblem() + " = ?", 50, Color.BLACK, Color.WHITE));
    }

    public static void generateMathProblems(){
        for(int i=1; i<=10; i++)
            problems.add(generateMathProblem(i));
    }

    private static MathModel generateMathProblem(int level){
        MathModel model = new MathModel(level);
        int[] answers;
        switch (level){
            case 1:
                model.setProblem("4 + 3");
                model.setSolution(7);
                answers = new int[]{2, 3, 4, 5, 7, 8};
                model.setAnswers(answers);
            case 2:
                model.setProblem("19 - 11");
                model.setSolution(8);
                answers = new int[]{5, 7, 11, 8, 4, 13};
                model.setAnswers(answers);
            case 3:
            case 4:
            case 5:
        }
        return model;
    }
}
