package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByEmail(String email);

    @Query(value = "SELECT * \n" +
            "FROM players p\n" +
            "JOIN teams t on t.id = p.team_id\n" +
            "JOIN stats s on s.id = p.stat_id\n" +
            "WHERE p.birth_date BETWEEN '1995-01-01' AND '2003-01-01'\n" +
            "ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.last_name;"
            , nativeQuery = true)
    List<Player> findAllOrderedBySkillsInDescAndOrderedByLastName();



}

