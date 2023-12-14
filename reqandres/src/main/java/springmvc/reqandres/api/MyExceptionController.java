package springmvc.reqandres.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springmvc.reqandres.RestAPIRepository;
import springmvc.reqandres.data.ApiResponse;
import springmvc.reqandres.data.MemberDto;
import springmvc.reqandres.exception.CustomException;
import springmvc.reqandres.exception.UserException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MyExceptionController {

    private final RestAPIRepository repository;

    @PostMapping("/myapi/members/save")
    public MemberDto saveMember(@RequestBody MemberDto memberDto) {

        if (memberDto.getGrade() > 6) {
            throw new CustomException("grade는 6이상 받을 수 없습니다.", memberDto.getGrade());
        }

        MemberDto savedMember = repository.save(memberDto);
//        ApiResponse<MemberDto> apiResponse = new ApiResponse<>();
//        apiResponse.save(savedMember, 200, "d");
//        return new ApiResponse<>();

        return savedMember;
    }
}
