package com.br.app.exercise1;

import java.util.ArrayList;

public class Evaluator {

    private int maximumValue;
    public static final String VISUAL = "VISUAL";
    public static final String NUTS = "NUTS";
    public static final String SPACE = " ";
    private Evaluator (){}
    public Evaluator (int maximumValue){
        this.maximumValue = maximumValue;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    public String getMeaningfulNumberDescription(int number){
        StringBuffer stringBuffer = new StringBuffer();
        if((Multiples.isMultipleOf3(number) == false && Multiples.isMultipleOf5(number) == false)){
            return String.valueOf(number);
        }
        if (Multiples.isMultipleOf3(number)){
            stringBuffer.append(VISUAL).append(SPACE);
        }
        if(Multiples.isMultipleOf5(number)){
            stringBuffer.append(NUTS);
        }
        return stringBuffer.toString();
    }

    public ArrayList<String> getNumberDescriptionUntilMaximumValue(){
        ArrayList<String> list = new ArrayList<String>();
        for( int index = 1; index < maximumValue; index ++){
            list.add(getMeaningfulNumberDescription(index));
        }
        return list;
    }

}
