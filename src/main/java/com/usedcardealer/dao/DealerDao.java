package com.usedcardealer.dao;


import com.usedcardealer.model.Dealer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DealerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveDaeler(Dealer dealer){
        entityManager.persist(dealer);
    }

    public void updateDealer(Dealer dealer){
        entityManager.merge(dealer);
    }
}
