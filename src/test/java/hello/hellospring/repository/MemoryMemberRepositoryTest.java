package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { //테스트 끝날때마다 테스트 저장소 지우기
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Diger");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        System.out.println("result = " + (result == member));
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Diger1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Diger2");
        repository.save(member2);

        Member result = repository.findByName("Diger1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Diger1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Diger2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
