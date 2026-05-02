package phh.mission7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phh.mission7.domain.role.Lion;
import phh.mission7.domain.role.Role;
import phh.mission7.domain.role.Staff;
import phh.mission7.dto.*;
import phh.mission7.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest dto) {
        Lion lion = memberService.createLion(dto);
        if (lion == null) {
            return ResponseEntity.status(409).build();
        }
        LionResponse responseDto = LionResponse.from(lion.name, lion.major, lion.generation, lion.part, "아기사자", lion.stuId);
        return ResponseEntity.status(201).body(responseDto);
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest dto) {
        Staff staff = memberService.createStaff(dto);
        if (staff == null) {
            return ResponseEntity.status(409).build();
        }
        StaffResponse responseDto = StaffResponse.from(staff.name, staff.major, staff.generation, staff.part, "운영진", staff.position);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Role role = memberService.findByName(name);
        if (role instanceof Lion lion) {
            LionResponse lionDto = LionResponse.from(lion.name, lion.major, lion.generation, lion.part, "아기사자", lion.stuId);
            return ResponseEntity.ok(lionDto);
        } else if (role instanceof Staff staff) {
            StaffResponse staffDto = StaffResponse.from(staff.name, staff.major, staff.generation, staff.part, "운영진", staff.position);
            return ResponseEntity.ok(staffDto);
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest dto) {
        Lion lion = memberService.updateLion(name, dto);
        if (lion == null) {
            return ResponseEntity.status(404).build();
        }
        LionResponse responseDto = LionResponse.from(lion.name, lion.major, lion.generation, lion.part, "아기사자", lion.stuId);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateLion(@PathVariable String name, @RequestBody StaffUpdateRequest dto) {
        Staff staff = memberService.updateStaff(name, dto);
        if (staff == null) {
            return ResponseEntity.status(404).build();
        }
        StaffResponse responseDto = StaffResponse.from(staff.name, staff.major, staff.generation, staff.part, "운영진", staff.position);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteMember(@PathVariable String name) {
        boolean isDeleted = memberService.deleteMember(name);
        if (!isDeleted) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(204).build();
    }
}
