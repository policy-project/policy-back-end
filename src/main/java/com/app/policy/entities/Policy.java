package com.app.policy.entities;

import com.app.policy.dto.PolicyDto;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "policies")
@Data
public class Policy {

    @Id @Column(name = "policy_id")
    private int policyNumber;
    @Column(name = "product_id")
    private int productNumber;
    @ManyToOne @JoinColumn(name = "insured_id")
    private Insured insured;

    public PolicyDto getPolicyDto(){
        PolicyDto res = new PolicyDto();
        res.setPolicyNumber(policyNumber);
        res.setProductNumber(productNumber);
        res.setInsuredId(insured.getInsuredId());
        return res;
    }



}
