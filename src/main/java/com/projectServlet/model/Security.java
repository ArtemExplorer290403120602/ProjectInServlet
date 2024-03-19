package com.projectServlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "security")
public class Security {
    @Id
    @SequenceGenerator(name = "securitySecGnr", sequenceName = "security_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "securitySecGnr")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private  String password;

    @Column(name = "user_id")
    private Long user_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
