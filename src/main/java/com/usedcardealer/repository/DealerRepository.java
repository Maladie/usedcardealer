package com.usedcardealer.repository;

import com.usedcardealer.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Integer> {

    Dealer findOne(Integer dealerId);
}
