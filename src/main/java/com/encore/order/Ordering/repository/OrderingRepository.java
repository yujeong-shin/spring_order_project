package com.encore.order.Ordering.repository;

import com.encore.order.Ordering.domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingRepository extends JpaRepository<Ordering, Long> {

}
