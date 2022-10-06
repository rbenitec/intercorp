package com.rbenitez.customer.model;

import com.rbenitez.customer.entity.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Result {
    private double averageAges;
    private double standardDeviationAges;


    /**
     * Method of calculation Average
     */

    public Double getAverageAges(List<Customer> customers){
        return customers.stream().collect(Collectors.averagingDouble(x -> x.getAge()));
    }


    /**
     * Method of calculation standardDeviation
     */


    public Double getstandardDeviationAges(List<Customer> customers){
        int sum = 0;
        double media = 0;
        double variance=0.0, temp = 0.0;
        double deviation= 0.0;

        for (Customer x : customers) {
            sum+=x.getAge();                            //   get Sum
        }

        media = sum/customers.size();   // get Media

        for (Customer y : customers) {
            temp = Math.pow((y.getAge() - media), 2);
            variance+=temp;
        }

        deviation = Math.sqrt(variance/customers.size());

        return deviation;
    }
}
