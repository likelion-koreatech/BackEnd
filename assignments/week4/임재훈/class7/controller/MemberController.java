package class7.controller;

import class7.domain.role.Lion;
import class7.domain.role.Role;
import class7.domain.role.Staff;
import class7.dto.*;
import class7.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 등록 -> POST
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request){
        LionResponse response = memberService.createLion(request); // 라이언 객체 생성 후 리스폰스 객체 반환받음
        if(response == null){
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request){
        StaffResponse response = memberService.createStaff(request);
        if(response == null){
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.status(201).body(response);
    }

    // 단일 조회, 조회 -> GET
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name){
        Role member = memberService.findByName(name);
        if(member == null){
            return ResponseEntity.notFound().build();
        }
        if(member instanceof Lion){
            return ResponseEntity.ok(LionResponse.from((Lion) member));
        }
        return ResponseEntity.ok(StaffResponse.from((Staff) member));
    }

    // 수정 -> PUT
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request){
        LionResponse response = memberService.updateLion(name, request);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/staff/{name}")
    public ResponseEntity<StaffResponse> updateLion(@PathVariable String name, @RequestBody StaffUpdateRequest request){
        StaffResponse response = memberService.updateStaff(name, request);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    // 삭제
    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteMember(@PathVariable String name){
        boolean result = memberService.deleteMember(name);
        if(!result){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
