package com.projectServlet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "role")
public class Role {
    @Id
    @SequenceGenerator(name = "roleSecGnr", sequenceName = "role_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "roleSecGnr")
    private Long id;

    @Column(name = "role_name")
    private String role_name;

    @Column(name = "security_id")
    private Long security_id;

    @ManyToOne
    @JoinColumn(name = "security_id")
    private Security security;
}
