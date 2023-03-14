package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //이것만 하면 nullpointerror가 나옴.. 어케 해결하지? > AppConfig 생성!!!!!!

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //인터페이스,구현체 둘다 의존 -> DIP 위반 > 인터페이스에만 의존하도록 변경.
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 둘중에 하나로 변경할때 코드를 변경해야 하므로, OCP 위반이다.


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
