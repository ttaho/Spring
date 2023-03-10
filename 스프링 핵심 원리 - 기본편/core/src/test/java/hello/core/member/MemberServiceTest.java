package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    @DisplayName("join 테스트")
    @Test
    void join() {
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findedMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findedMember);

    }
}
