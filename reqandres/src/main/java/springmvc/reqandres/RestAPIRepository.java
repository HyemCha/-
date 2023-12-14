package springmvc.reqandres;

import org.springframework.stereotype.Repository;
import springmvc.reqandres.data.MemberDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RestAPIRepository {

    private static Map<Long, MemberDto> store = new HashMap<>();
    private static long sequence = 0L;

    public MemberDto save(MemberDto memberDto) {
        memberDto.setId(++sequence);
        store.put(memberDto.getId(), memberDto);
        return memberDto;
    }

    public List<MemberDto> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<MemberDto> findSpecificGrade(int grade) {
        List<MemberDto> arr = new ArrayList<>();
        for (MemberDto member : store.values()) {
            if (member.getGrade() == grade) {
                arr.add(member);
            }
        }
        return arr;
    }
}
