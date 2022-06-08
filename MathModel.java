import java.util.*;
/**
 * A class that has been created to represent the math model of the game
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 24/4/2022
 */
public class MathModel {
    private int level;
    private String problem;
    private int solution;
    private List<Integer> answers = new ArrayList<>();
    private List<Number> numbers = new ArrayList<>();
    
    /**
     * Constructor for objects of class MathModel
     */
    public MathModel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answerss) {
        this.answers = answers;
    }
    
    public void addAnswer(int number){
        answers.add(number);
    }
    
    public List<Number> getNumbers(){
        return numbers;
    }
    
    public void setNumbers(){
        for(int num: answers){
            numbers.add(new Number(this, num));
        }
    }
}
