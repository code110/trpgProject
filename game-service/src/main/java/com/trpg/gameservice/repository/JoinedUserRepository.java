package com.trpg.gameservice.repository;

import com.trpg.gameservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JoinedUserRepository extends JpaRepository<Game, UUID> {
}
