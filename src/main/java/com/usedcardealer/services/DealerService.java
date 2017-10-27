package com.usedcardealer.services;

import com.usedcardealer.dao.DealerDao;
import com.usedcardealer.model.Address;
import com.usedcardealer.model.Dealer;
import com.usedcardealer.view.AddDealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {
    DealerDao dealerDao;

    @Autowired
    public DealerService(DealerDao dealerDao){
        this.dealerDao = dealerDao;
    }

    public Dealer addDealer(AddDealer newDealer){
        Dealer dealer = new Dealer();
        Address address = new Address();
        address.setCity(newDealer.getCity());
        address.setCountry(newDealer.getCountry());
        address.setStreet(newDealer.getStreet());
        dealer.setName(newDealer.getName());
        dealer.setAddress(address);
        dealerDao.saveDaeler(dealer);
        return dealer;
    }
}
