package com.tstcore.easybank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "accounts")
@Table(name = "accounts")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Accounts {
    @Id
    @Column(name="account_number")
    private long accountNumber;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name="account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_dt")
    private String createDt;
}