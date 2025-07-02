package com.tap.TFLAssessmenr.Entity;

public class Questions {
    
    private String title;
    private int id;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private char answer;
    private int evaluationCriteria;

    public Questions()
    {
        
        this.id = 0;
        this.title = null;
        this.option1 = null;
        this.option2 = null;
        this.option3 =null;
        this.option4 = null;
        this.answer = ' ';
        this.evaluationCriteria = 0;

    }
    
}
