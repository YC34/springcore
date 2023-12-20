package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test code 작성하여 테스트 진행.
 */
public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();

    @Test
    void save(){
        MemberService memberService = appConfig.memberService();
        // given
        Member member = new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
