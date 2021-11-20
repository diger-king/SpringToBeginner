package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.Optional;
import java.util.OptionalInt;

public interface MemberRepository {
    Member save(Member member);
    OptionalInt
}
