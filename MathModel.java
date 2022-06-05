import java.util.*;

public class MathModel {
    private int level;
    private String problem;
    private int solution;
    //private int[] answers;
    private List<Integer> answers = new ArrayList<>();
    private List<Trophy> trophyAnswers = new ArrayList<>();

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
    
    public List<Trophy> getTrophyAnswers(){
        return trophyAnswers;
    }
    
    public void setTrophyAnswers(){
        for(int num: answers){
            trophyAnswers.add(new Trophy(this, num));
        }
    }
    
    public Trophy getTrophyAnswer(int index){
        return trophyAnswers.get(index);
    }

}
