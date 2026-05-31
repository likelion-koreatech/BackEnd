package phh.mission10.dto;

public class MemberResponse {

    public Long id;
    public String name;
    public String major;
    public int generation;
    public String part;
    public String roleName;
    public String studentId;
    public String position;

    public static MemberResponse from(Long id, String name, String major, int generation, String part, String roleName, String studentId, String position) {
        MemberResponse response = new MemberResponse();

        response.id = id;
        response.name = name;
        response.major = major;
        response.generation = generation;
        response.part = part;
        response.roleName = roleName;
        response.studentId = studentId;
        response.position = position;

        return response;
    }
}
