package phh.mission9.dto;

import phh.mission9.domain.Assignment;

public class AssignmentResponse {
    public Long id;
    public String title;
    public String description;
    public Long memberId;
    public String memberName;

    static public AssignmentResponse from(Assignment assignment) {
        AssignmentResponse response = new AssignmentResponse();
        response.id = assignment.getId();
        response.title = assignment.getTitle();
        response.description = assignment.getDescription();
        response.memberId = assignment.getMember().getId();
        response.memberName = assignment.getMember().getName();
        return response;
    }
}
