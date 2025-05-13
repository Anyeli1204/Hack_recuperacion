package com.example.eventosasincronialab5a.usuario.controller;

import com.example.eventosasincronialab5a.meeting.domain.Meeting;
import com.example.eventosasincronialab5a.dto.ResponseDTO;
import com.example.eventosasincronialab5a.usuario.domain.Usuario;
import com.example.eventosasincronialab5a.usuario.domain.WelcomeEmailEvent;
import com.example.eventosasincronialab5a.usuario.infraestructure.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/create")
    ResponseEntity<ResponseDTO> create(@RequestBody Usuario usuario) {
        // Relación bidireccional: settear ambos lados
        Meeting meeting = usuario.getMeeting();
        if (meeting != null) {
            meeting.setUsuario(usuario);    // lado inverso de la relación
            usuario.setMeeting(meeting);    // lado dueño de la relación
        }
        // GRACIAS A CASCADE, SE GUARDA EN LA BD TANTO USUARIO COMO MEETING
        Usuario savedUsuario = usuarioRepository.save(usuario);

        // SE ACTIVA EVENTO -> SE CREA UNA PERSONA
        applicationEventPublisher.publishEvent(new WelcomeEmailEvent(this,savedUsuario.getEmail(),savedUsuario.getNombre()));

        // Usar ResponseDTO para evitar serialización circular
        ResponseDTO response = new ResponseDTO();
        response.setUsuarioId(savedUsuario.getId());
        response.setNombre(savedUsuario.getNombre());
        response.setEmail(savedUsuario.getEmail());
        response.setMeetingId(meeting.getId());

        response.setMeetingZoomId(meeting.getMeetingId());
        response.setStartDate(meeting.getStartDate());
        response.setEndDate(meeting.getEndDate());
        response.setRoomURL(meeting.getRoomURL());
        response.setHostRoomURL(meeting.getHostRoomURL());
        return ResponseEntity.ok().body(response);
    }

}
