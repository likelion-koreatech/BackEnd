package phh.mission9.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phh.mission9.domain.Assignment;
import phh.mission9.dto.AssignmentCreateRequest;
import phh.mission9.dto.AssignmentResponse;
import phh.mission9.dto.AssignmentUpdateRequest;
import phh.mission9.service.AssignmentService;

import java.util.List;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(@PathVariable Long memberId,
                                              @RequestBody AssignmentCreateRequest dto) {
        Assignment assignment = assignmentService.createAssignment(memberId, dto.title, dto.description);
        if(assignment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
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
        if(assignment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignments(@PathVariable Long id,
                                                                @RequestBody AssignmentUpdateRequest dto) {
        Assignment assignment = assignmentService.update(id, dto.title, dto.description);
        if(assignment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<?> deleteAssignments(@PathVariable Long id) {
        if(assignmentService.delete(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
