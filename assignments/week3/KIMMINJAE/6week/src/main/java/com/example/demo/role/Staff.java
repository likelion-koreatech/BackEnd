package com.example.demo.role;

public class Staff extends Member {
    private String wlrcor;
    public Staff(String name,String major,int rltn,String part,String wlrcor){
        super(name, major, rltn, part);
        this.wlrcor = wlrcor;
    }
    @Override
    public String getRole() {
        return "운영진";
    }

    @Override
    public String getExtraInfo() {
        return "⭐ 직책: " + wlrcor;
    }

}