package com.app.policy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insureds")
public class Insured {
    @Id @Column(name = "insured_id")
    int insuredId;
    @Column(name = "first_name")
    String insuredFirstName;
    @Column(name = "last_name")
    String insuredLastName;
}
