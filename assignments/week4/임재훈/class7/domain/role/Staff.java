package class7.domain.role;

import class7.dto.LionUpdateRequest;
import class7.dto.StaffCreateRequest;
import class7.dto.StaffUpdateRequest;

public class Staff extends Role{
    private String position;

    public Staff(StaffCreateRequest request) {
        super(request.getName(), request.getMajor(), request.getGeneration(), request.getPart());
        this.position = request.getPosition();
    }

    public Staff(String name, StaffUpdateRequest request){
        super(name, request.getMajor(), request.getGeneration(), request.getPart());
        this.position = request.getPosition();
    }

    @Override
    public String getRoleName(){
        return "STAFF";
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
