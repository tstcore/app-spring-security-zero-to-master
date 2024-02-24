package com.tstcore.easybank.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@Entity(name = "customer")
@Table(name = "customer")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "customer_id")
    private int id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    @Column(name = "create_dt")
    private String createDt;

}
