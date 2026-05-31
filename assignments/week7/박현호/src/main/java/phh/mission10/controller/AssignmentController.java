package phh.mission10.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phh.mission10.domain.Assignment;
import phh.mission10.domain.Member;
import phh.mission10.dto.AssignmentCreateRequest;
import phh.mission10.dto.AssignmentResponse;
import phh.mission10.dto.AssignmentUpdateRequest;
import phh.mission10.service.AssignmentService;
import phh.mission10.service.MemberService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final MemberService memberService;

    public AssignmentController(AssignmentService assignmentService, MemberService memberService) {
        this.assignmentService = assignmentService;
        this.memberService = memberService;
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentResponse>> findAll() {
        List<Member> members = memberService.findAll();
        List<Assignment> assignments = new ArrayList<>();
        for (Member member : members) {
            List<Assignment> byMemberId = assignmentService.findByMemberId(member.getId());
            assignments.addAll(byMemberId);
        }
        return ResponseEntity.ok(assignments.stream().map(AssignmentResponse::from).toList());
    }

    @GetMapping("/assignments/search")
    public ResponseEntity<List<AssignmentResponse>> findByTitleContaining(@RequestParam String keyword) {
        List<Assignment> assignments = assignmentService.findByTitleContaining(keyword);
        return ResponseEntity.ok(assignments.stream().map(AssignmentResponse::from).toList());
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(@PathVariable Long memberId,
                                                               @RequestBody AssignmentCreateRequest dto) {
        Assignment assignment = assignmentService.createAssignment(memberId, dto.title, dto.description);
        return ResponseEntity.status(HttpStatus.CREATED).body(AssignmentResponse.from(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> getAssignmentsByMemberId(@PathVariable Long memberId) {
        List<Assignment> assignments = assignmentService.findByMemberId(memberId);
        return ResponseEntity.ok(assignments.stream().map(assignment -> AssignmentResponse.from(assignment)).toList());
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> getAssignment(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignments(@PathVariable Long id,
                                                                @RequestBody AssignmentUpdateRequest dto) {
        Assignment assignment = assignmentService.update(id, dto.title, dto.description);
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<?> deleteAssignments(@PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
