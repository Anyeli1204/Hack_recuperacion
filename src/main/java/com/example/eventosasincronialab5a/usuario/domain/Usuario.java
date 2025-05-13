package com.example.eventosasincronialab5a.usuario.domain;

import com.example.eventosasincronialab5a.meeting.domain.Meeting;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
}
