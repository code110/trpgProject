package com.trpg.playeridentityservice.controller;

import com.trpg.playeridentityservice.dto.IdentityDto;
import com.trpg.playeridentityservice.dto.ImmutableIdentityDto;
import com.trpg.playeridentityservice.dto.ImmutableWorldDto;
import com.trpg.playeridentityservice.dto.WorldDto;
import com.trpg.playeridentityservice.model.*;
import com.trpg.playeridentityservice.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class IdentityController {
    private final PlayerService playerService;

    public IdentityController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/createWorld")
    public ResponseEntity<WorldDto> createWorld(@RequestBody ImmutableWorldDto worldDto){
        World world = World.Builder.newBuilder()
                .withWorld_name(worldDto.getWorld_name())
                .withIntro(worldDto.getIntro())
                .build();
        UUID worldId = playerService.createWorld(world);

        List<WorldAttribute> worldAttributes = worldDto.getAttribute_name().entrySet()
                .stream().map(e -> new WorldAttribute(e.getKey(),e.getValue(),worldId))
                .collect(Collectors.toList());

        playerService.createWorldAttribute((WorldAttribute) worldAttributes);

        return ResponseEntity.ok(worldDto);
    }

    @PostMapping("/createPlayerIdentity")
    public ResponseEntity<IdentityDto> createPlayerIdentity(@RequestBody ImmutableIdentityDto identityDto){
        PlayerIdentity playerIdentity = PlayerIdentity.Builder.newBuilder()
                .withGame_uuid(identityDto.getGame_uuid())
                .withWorld_uuid(identityDto.getWorld_uuid())
                .withUser_uuid(identityDto.getUser_uuid())
                .build();

        UUID identityId = playerService.createPlayerIdentity(playerIdentity);

        List<AttributeValue> attributeValues = identityDto.getAttribute_value().entrySet()
                .stream().map(e -> new AttributeValue(e.getKey(),e.getValue(),identityId))
                .collect(Collectors.toList());

        playerService.addAttribute(attributeValues);

        return ResponseEntity.ok(identityDto);
    }

    @PostMapping("/updateAttribute")
    public ResponseEntity<IdentityDto> updateAttribute(@RequestBody ImmutableIdentityDto identityDto){
        UUID identityId = identityDto.getIdentity_uuid();

        List<AttributeValue> attributeValues = identityDto.getAttribute_value().entrySet()
                .stream().map(e -> new AttributeValue(e.getKey(),e.getValue(),identityId))
                .collect(Collectors.toList());

        playerService.updateAttribute((AttributeValue) attributeValues);

        return ResponseEntity.ok(identityDto);
    }

    @PostMapping("/addIdentityImage")
    public ResponseEntity<IdentityDto> addImage(@RequestBody ImmutableIdentityDto identityDto){
        IdentityImage identityImage = IdentityImage.Builder.newBuilder()
                .withIdentityUUID(identityDto.getIdentity_uuid())
                .withImgUrl(identityDto.getImg_url())
                .build();

        playerService.addImage(identityImage);
    
        return ResponseEntity.ok(identityDto);
    }
}
