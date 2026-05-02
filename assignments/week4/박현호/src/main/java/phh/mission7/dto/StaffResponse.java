package phh.mission7.dto;

public class StaffResponse {

    public String name;
    public String major;
    public int generation;
    public String part;
    public String roleName;
    public String position;

    public static StaffResponse from(String name, String major, int generation, String part, String roleName, String position) {
        StaffResponse staffResponse = new StaffResponse();
        staffResponse.name = name;
        staffResponse.major = major;
        staffResponse.generation = generation;
        staffResponse.part = part;
        staffResponse.roleName = roleName;
        staffResponse.position = position;
        return staffResponse;
    }
}
