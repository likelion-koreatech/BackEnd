package com.example.demo.role;


public class Lion extends Member {
    private int Stu_Num;
    public Lion(String name,String major,int rltn,String part,int Stu_Num){

        super(name, major, rltn, part);
        this.Stu_Num = Stu_Num;
    }
    @Override
    public String getRole() {
        return "아기사자";
    }

    @Override
    public String getExtraInfo() {
        return "🆔 학번: " + Stu_Num;
    }
}