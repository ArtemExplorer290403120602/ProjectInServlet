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
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "userhistory")
public class UserHistory {
    @Id
    @SequenceGenerator(name = "userHistorySecGnr", sequenceName = "userhistory_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "userHistorySecGnr")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "action_type")
    private String action_type;

    @Column(name = "action_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp action_timestamp;
}
