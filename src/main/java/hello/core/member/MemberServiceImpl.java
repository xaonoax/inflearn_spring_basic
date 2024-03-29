package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();  // 구현체가 없으면 nullPointException이 발생한다.
    private final MemberRepository memberRepository;

    @Autowired  // ac.getBean(MemberRepository.class)처럼 동작 한다.
    public MemberServiceImpl(MemberRepository memberRepository) { // MemberRepository에 어떤 구현체가 들어갈지 생성자를 통해서 선택한다.
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {  // 매개변수로 전달받은 member 객체를 memberRepository의 save 메서드를 호출하여 메모리에 저장한다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {  // 매개변수로 전달받은 memberId를 이용하여 memberRepository의 findById 메서드를 호출하여 회원을 찾는다.
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
