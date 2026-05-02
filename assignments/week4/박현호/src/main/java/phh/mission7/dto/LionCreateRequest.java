package phh.mission7.dto;

import phh.mission7.domain.role.Lion;

public class LionCreateRequest {

    public String name;
    public String major;
    public int generation;
    public String part;
    public String studentId;

    public Lion newLion() {
        return new Lion(name, major, generation, part, studentId);
    }
}
