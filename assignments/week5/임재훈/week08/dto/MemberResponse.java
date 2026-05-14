package week08.dto;

import week08.domain.Member;

public class MemberResponse {

    private Long id;
    private String name;
    private String major;
    private String part;
    private int generation;
    private String roleName;
    private String studentId;
    private String position;

    public static MemberResponse from(Member member) {
        MemberResponse response = new MemberResponse();
        response.id = member.getId();
        response.name = member.getName();
        response.major = member.getMajor();
        response.part = member.getPart();
        response.generation = member.getGeneration();
        response.roleName = member.getRoleType().getDisplayName();
        response.studentId = member.getStudentId();
        response.position = member.getPosition();
        return response;
    }

    // Getter
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public String getPart() { return part; }
    public int getGeneration() { return generation; }
    public String getRoleName() { return roleName; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }
}