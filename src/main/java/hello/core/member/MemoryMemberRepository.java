package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();  // HashMap은 동시성 이슈가 있을 수 있기 때문에 Concurrent 해시맵을 사용해야 한다.

    @Override
    public void save(Member member) {  // 매개변수로 전달 받은 Member를 메모리에 저장한다.
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long MemberId) {  // 메모리에 저장된 회원 중 주어진 MemberId에 해당하는 회원을 조회한다.
        return store.get(MemberId);
    }
}
