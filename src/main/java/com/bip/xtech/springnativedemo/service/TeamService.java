package com.bip.xtech.springnativedemo.service;

import com.bip.xtech.springnativedemo.domain.Team;
import com.bip.xtech.springnativedemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team create(Team teamToCreate) {
        return teamRepository.save(teamToCreate);
    }
}
