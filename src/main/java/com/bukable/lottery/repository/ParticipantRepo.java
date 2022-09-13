package com.bukable.lottery.repository;

import com.bukable.lottery.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, Long> {

    Participant findByName(String name);

}
