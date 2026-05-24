package phh.mission9.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phh.mission9.domain.Member;
import phh.mission9.dto.*;
import phh.mission9.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest dto) {
        Member member = memberService.createLion(dto);
        if (member == null) {
            return ResponseEntity.status(409).build();
        }
        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.status(201).body(responseDto);
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest dto) {
        Member member = memberService.createStaff(dto);
        if (member == null) {
            return ResponseEntity.status(409).build();
        }
        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByName(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            return ResponseEntity.status(404).build();
        }
        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest dto) {
        Member member = memberService.updateLion(id, dto);
        if (member == null) {
            return ResponseEntity.status(404).build();
        }
        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody StaffUpdateRequest dto) {
        Member member = memberService.updateStaff(id, dto);
        if (member == null) {
            return ResponseEntity.status(404).build();
        }
        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        boolean isDeleted = memberService.deleteMember(id);
        if (!isDeleted) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(204).build();
    }
}
