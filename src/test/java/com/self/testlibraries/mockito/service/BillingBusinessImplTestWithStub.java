package com.self.testlibraries.mockito.service;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BillingBusinessImplTestWithStub{

    @Test
    public void testGetItemOfFruitsUsingStub(){
        BillingService billingServiceStub = new BillingServiceStub();
        BillingBusinessImpl billingBusiness = new BillingBusinessImpl(billingServiceStub);
        List<String> items = billingBusiness.getItemOfFruits("dummy");
        assertEquals(2, items.size());
    }

}