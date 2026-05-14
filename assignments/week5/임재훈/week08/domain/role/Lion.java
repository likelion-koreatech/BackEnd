package week08.domain.role;

import week08.dto.LionCreateRequest;
import week08.dto.LionUpdateRequest;

public class Lion extends Role{
    private String studentId; // Lion에만 존재하는 studentId

    public Lion(LionCreateRequest request) {
        super(request.getName(), request.getMajor(), request.getGeneration(), request.getPart());
        this.studentId = request.getStudentId();
    }

    public Lion(String name, LionUpdateRequest request){
        super(name, request.getMajor(), request.getGeneration(), request.getPart());
        this.studentId = request.getStudentId();
    }

    @Override
    public String getRoleName(){
        return "LION";
    }

    // studentId 게터와 세터
    public String getStudentId(){
        return this.studentId;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
}
