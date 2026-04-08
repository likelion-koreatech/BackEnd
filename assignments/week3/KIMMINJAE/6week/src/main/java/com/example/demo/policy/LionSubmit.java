package com.example.demo.policy;

public class LionSubmit implements SubmitPolicy {
    @Override
    public boolean canSubmit(){
        return true;
    }
}
