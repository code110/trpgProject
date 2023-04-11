package com.trpg.playeridentityservice.service;

import com.trpg.playeridentityservice.model.*;
import com.trpg.playeridentityservice.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {
    private final AttributeValueRepository  attributeValueRepository;
    private final IdentityImageRepository identityImageRepository;
    private final PlayerIdentityRepository playerIdentityRepository;
    private final WorldAttributeRepository worldAttributeRepository;
    private final WorldRepository worldRepository;

    public PlayerService(AttributeValueRepository attributeValueRepository, IdentityImageRepository identityImageRepository, PlayerIdentityRepository playerIdentityRepository, WorldAttributeRepository worldAttributeRepository, WorldRepository worldRepository) {
        this.attributeValueRepository = attributeValueRepository;
        this.identityImageRepository = identityImageRepository;
        this.playerIdentityRepository = playerIdentityRepository;
        this.worldAttributeRepository = worldAttributeRepository;
        this.worldRepository = worldRepository;
    }

    public UUID createWorld(World world){
        World worldId = worldRepository.saveAndFlush(world);
        return worldId.getWorld_uuid();
    }

    public boolean createWorldAttribute(WorldAttribute worldAttribute){
        worldAttributeRepository.save(worldAttribute);
        return true;
    }

    public UUID createPlayerIdentity(PlayerIdentity playerIdentity){
        PlayerIdentity identityId = playerIdentityRepository.saveAndFlush(playerIdentity);
        return identityId.getIdentity_uuid();
    }

    public boolean addImage(IdentityImage identityImage){
        identityImageRepository.save(identityImage);
        return true;
    }

    public boolean addAttribute(List<AttributeValue> attributeValue){
        attributeValueRepository.saveAll(attributeValue);
        return true;
    }

    public boolean updateAttribute(AttributeValue attributeValue){
        attributeValueRepository.save(attributeValue);
        return  true;
    }
}
