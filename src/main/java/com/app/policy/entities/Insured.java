package com.app.policy.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "insureds")
@Data
public class Insured {
    @Id @Column(name = "insured_id")
    private int insuredId;
    @Column(name = "first_name")
    private String insuredFirstName;
    @Column(name = "last_name")
    private String insuredLastName;
}
