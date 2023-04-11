package com.trpg.playeridentityservice.repository;

import com.trpg.playeridentityservice.model.PlayerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerIdentityRepository extends JpaRepository<PlayerIdentity, UUID> {
}
