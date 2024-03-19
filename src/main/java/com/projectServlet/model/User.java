package com.projectServlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    @SequenceGenerator(name = "userSecGnr", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "userSecGnr")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;
    @Column(name = "create")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp create;
}
