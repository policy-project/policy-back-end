package com.app.policy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "policies")
public class Policy {
    @Id @Column(name = "policy_id")
    int policyNumber;
    @Column(name = "product_id")
    int productNumber;
    @ManyToOne @Column(name = "insured_id")
    Insured insuredId;

}
