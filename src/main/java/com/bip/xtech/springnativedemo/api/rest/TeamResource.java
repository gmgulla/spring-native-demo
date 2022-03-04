package com.bip.xtech.springnativedemo.api.rest;

import com.bip.xtech.springnativedemo.domain.Team;
import com.bip.xtech.springnativedemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamResource {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAll() {
        return ResponseEntity.ok().body(teamService.getAll());
    }

    @PostMapping("/teams")
    private ResponseEntity<Void> create(@RequestBody Team teamToCreate) {
        return ResponseEntity.created(URI.create(teamService.create(teamToCreate).getName())).build();
    }


}
