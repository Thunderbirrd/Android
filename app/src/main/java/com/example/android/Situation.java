package com.example.android;

public class Situation {
    Situation[] direction;
    String subject,text;
    int dK, dW,dR;
    public Situation (String subject, String text, int variants, int dk,int dw,int dr) {
        this.subject=subject;
        this.text=text;
        dK=dk;
        dW =dw;
        dR=dr;
        direction=new Situation[variants];
    }
}
