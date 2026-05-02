package phh.mission7.dto;

import phh.mission7.domain.role.Staff;

public class StaffCreateRequest {

    public String name;
    public String major;
    public int generation;
    public String part;
    public String position;

    public Staff newStaff() {
        return new Staff(name, major, generation, part, position);
    }

}
