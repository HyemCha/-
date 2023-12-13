package springmvc.reqandres;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RestAPIRepository {

    private Map<Long, MemberDto> store = new HashMap<>();
}
