package com.encore.order.Ordering.repository;

import com.encore.order.Member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingRepository extends JpaRepository<Member, Long> {

}
