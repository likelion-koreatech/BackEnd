package week08.controller;

import week08.domain.Member;
import week08.dto.MemberResponse;
import week08.dto.*;
import week08.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Lion 등록
    @PostMapping("/lions")
    public MemberResponse createLion(@RequestBody LionCreateRequest request) {
        Member member = memberService.createLion(
                request.getName(), request.getMajor(), request.getPart(),
                request.getGeneration(), request.getStudentId()
        );
        return MemberResponse.from(member);
    }

    // Staff 등록
    @PostMapping("/staffs")
    public MemberResponse createStaff(@RequestBody StaffCreateRequest request) {
        Member member = memberService.createStaff(
                request.getName(), request.getMajor(), request.getPart(),
                request.getGeneration(), request.getPosition()
        );
        return MemberResponse.from(member);
    }

    // 전체 조회
    @GetMapping
    public List<MemberResponse> findAll() {
        return memberService.findAll().stream()
                .map(MemberResponse::from)
                .toList();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public MemberResponse findById(@PathVariable Long id) {
        return MemberResponse.from(memberService.findById(id));
    }

    // Lion 수정
    @PutMapping("/lions/{id}")
    public MemberResponse updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest request) {
        Member member = memberService.updateLion(
                id, request.getMajor(), request.getPart(),
                request.getGeneration(), request.getStudentId()
        );
        return MemberResponse.from(member);
    }

    // Staff 수정
    @PutMapping("/staffs/{id}")
    public MemberResponse updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        Member member = memberService.updateStaff(
                id, request.getMajor(), request.getPart(),
                request.getGeneration(), request.getPosition()
        );
        return MemberResponse.from(member);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.delete(id);
    }
}