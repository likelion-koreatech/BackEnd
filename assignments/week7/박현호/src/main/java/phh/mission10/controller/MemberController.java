package phh.mission10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phh.mission10.domain.Member;
import phh.mission10.dto.*;
import phh.mission10.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping()
    public ResponseEntity<List<MemberResponse>> findAll(@RequestParam(required = false) String part) {
        List<Member> members;
        if (part != null) {
            members = memberService.findMembersByPart(part);
        }
        else {
            members = memberService.findAll();
        }
        return ResponseEntity.ok(members.stream().map(member -> MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition())).toList());
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest dto) {
        Member member = memberService.createLion(dto);

        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.status(201).body(responseDto);
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest dto) {
        Member member = memberService.createStaff(dto);

        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByName(@PathVariable Long id) {
        Member member = memberService.findById(id);

        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest dto) {
        Member member = memberService.updateLion(id, dto);

        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody StaffUpdateRequest dto) {
        Member member = memberService.updateStaff(id, dto);

        MemberResponse responseDto = MemberResponse.from(member.getId(), member.getName(), member.getMajor(), member.getGeneration(), member.getPart(), member.getRoleType().getDisplayName(), member.getStudentId(), member.getPosition());
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);

        return ResponseEntity.status(204).build();
    }
}
