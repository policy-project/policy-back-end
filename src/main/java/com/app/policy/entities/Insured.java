package com.app.policy.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "insured_id")
    private List<Policy> policies;
}
