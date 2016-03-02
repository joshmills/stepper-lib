package jmills.co.stepperlib.model;

/**
 * Created by joshmills on 02/03/16.
 */
public abstract class Step {

    private int stepNumber;
    private String title;

    public Step(String title) {
        this.title = title;
    }

    protected void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public abstract StepFragment getFragment();

    public String getTitle() {
        return title;
    }

}