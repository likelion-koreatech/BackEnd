## 학생, 과제 정보 관리 서버
학생과 과제를 등록, 수정, 삭제, 조회 할 수 있다.


## 기술 스택
- Java
- Spring Boot
- JPA
- MySQL
- Docker

## 실행 방법
**MySQL 데이터베이스 생성**

cmd -> docker run --name likelion -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=likelion_pbl -d mysql:latest

**서버 실행**

cmd -> ./gradlew bootRun 입력

## API 목록
### 멤버 API
- GET /members
    - 모든 멤버 조회
- GET /members/{id}
    - 멤버 ID로 조회
- POST /members/staffs
    - 스태프 등록
- PUT /members/staffs/{id}
    - 스태프 수정
- POST /members/lions
    - 아기사자 등록
- PUT /members/lions/{id}
    - 아기사자 수정
- DELETE /members/{id}
    - 멤버 삭제

### 과제 API
- GET /assignments
    - 과제 전체 조회
- GET /assignments/search?keyword=
    - keyword 필터링 조회
- POST /members/{memberId}/assignments
    - 멤버별 과제 등록
- GET /members/{memberId}/assignments
    - 멤버별 과제 조회
- GET /assignments/{id}
    - 과제 번호로 조회
- PUT /assignments/{id}
    - 과제 수정
- DELETE /assignments/{id}
    - 과제 삭제

## 패키지 구조
```
C:.
├─java
│  └─phh
│      └─mission10
│          │  Mission10Application.java
│          │  
│          ├─controller 엔드포인트 API 패키지
│          │      AssignmentController.java
│          │      MemberController.java
│          │      
│          ├─domain 엔티티, Enum 패키지
│          │      Assignment.java
│          │      Member.java
│          │      RoleType.java
│          │      
│          ├─dto 요청/응답 DTO
│          │      AssignmentCreateRequest.java
│          │      AssignmentResponse.java
│          │      AssignmentUpdateRequest.java
│          │      LionCreateRequest.java
│          │      LionUpdateRequest.java
│          │      MemberResponse.java
│          │      StaffCreateRequest.java
│          │      StaffUpdateRequest.java
│          │      
│          ├─global 전역 패키지
│          │  ├─dto
│          │  │      ErrorResponse.java 에러 응답 Object
│          │  │      
│          │  └─exception 예외 처리
│          │          AssignmentNotFoundException.java
│          │          DuplicateMemberException.java
│          │          GlobalExceptionHandler.java
│          │          MemberNotFoundException.java
│          │          
│          ├─repository DB 접근 패키지
│          │      AssignmentRepository.java
│          │      MemberRepository.java
│          │      
│          └─service 비즈니스 로직 패키지
│                  AssignmentService.java
│                  MemberService.java
│                  
└─resources
    │  application.properties
    │  
    ├─static
    │  │  index.html
    │  │  
    │  ├─css
    │  │      style.css
    │  │      
    │  └─js
    │          assignment.js
    │          member.js
    │          
    └─templates
```
