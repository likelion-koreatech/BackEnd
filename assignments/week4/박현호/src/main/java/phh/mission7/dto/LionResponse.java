package phh.mission7.dto;

public class LionResponse {

    public String name;
    public String major;
    public int generation;
    public String part;
    public String roleName;
    public String studentId;

    public static LionResponse from(String name, String major, int generation, String part, String roleName, String studentId) {
        LionResponse lionResponse = new LionResponse();

        lionResponse.name = name;
        lionResponse.major = major;
        lionResponse.generation = generation;
        lionResponse.part = part;
        lionResponse.roleName = roleName;
        lionResponse.studentId = studentId;

        return lionResponse;
    }
}
