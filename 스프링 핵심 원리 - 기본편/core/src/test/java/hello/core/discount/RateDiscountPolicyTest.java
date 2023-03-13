package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_ok() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discountedMoney = discountPolicy.discount(member, 10000);

        //then

        Assertions.assertThat(discountedMoney).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_no() {
        //given
        Member member = new Member(1L,"memberBasic",Grade.BASIC);
        //when
        int discountedMoney = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discountedMoney).isEqualTo(0);
    }

}