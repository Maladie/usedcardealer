package com.usedcardealer.controller;

import com.usedcardealer.dao.DealerDao;
import com.usedcardealer.model.Address;
import com.usedcardealer.model.Dealer;
import com.usedcardealer.services.DealerService;
import com.usedcardealer.view.AddDealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorRead;
import javax.validation.Valid;

@RestController(value = "/dealer")
public class DealerController {

    private DealerService dealerService;

    @Autowired
    public DealerController(DealerService dealerService){
        this.dealerService = dealerService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<Dealer> addDealer(@RequestBody @Valid AddDealer dealer, BindingResult result){
        Dealer addedDealer = dealerService.addDealer(dealer);
        return new ResponseEntity<>(addedDealer,HttpStatus.CREATED);
    }
}
