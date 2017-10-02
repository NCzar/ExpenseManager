/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author nikhilv85
 */
import java.util.HashMap;
import java.util.Map;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

import com.stripe.net.RequestOptions.RequestOptionsBuilder;;

public class ChargeTest
{
    
    
    public static void main(String[] args)
    {
        ChargeTest ct=new ChargeTest();
        ct.charge("sk_test_SxJjmpFZilGA0oiZfQDxqsqQ",1000);
        /*
        String key = "sk_test_SxJjmpFZilGA0oiZfQDxqsqQ";

        RequestOptions requestOptions = (new RequestOptionsBuilder()).setApiKey(key).build();
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 900000);
        chargeMap.put("currency", "usd");
        Map<String, Object> cardMap = new HashMap<String, Object>();
        cardMap.put("number", "4000000000000077");
        cardMap.put("exp_month", 12);
        cardMap.put("exp_year", 2020);
        chargeMap.put("card", cardMap);
        try
        {
            Charge charge = Charge.create(chargeMap, requestOptions);
            System.out.println(charge);
        }
        catch (StripeException e)
        {
            e.printStackTrace();
        }
                */
    }
    
    public void charge(String key,int amt){
        //key = "sk_test_SxJjmpFZilGA0oiZfQDxqsqQ";

        RequestOptions requestOptions = (new RequestOptionsBuilder()).setApiKey(key).build();
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", amt);
        chargeMap.put("currency", "usd");
        Map<String, Object> cardMap = new HashMap<String, Object>();
        cardMap.put("number", "4000000000000077");
        cardMap.put("exp_month", 12);
        cardMap.put("exp_year", 2020);
        chargeMap.put("card", cardMap);
        try
        {
            Charge charge = Charge.create(chargeMap, requestOptions);
            System.out.println(charge);
        }
        catch (StripeException e)
        {
            e.printStackTrace();
        }
    }
}
