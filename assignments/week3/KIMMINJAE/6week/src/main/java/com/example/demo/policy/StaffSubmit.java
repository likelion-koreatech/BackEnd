package com.example.demo.policy;

public class StaffSubmit implements SubmitPolicy {
    @Override
    public boolean canSubmit(){
        return false;
    }
}
