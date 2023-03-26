package com.trpg.gameservice.controller;

import com.trpg.gameservice.GameServiceApplication;
import com.trpg.gameservice.dto.GameDto;
import com.trpg.gameservice.dto.JoinedUserDto;
import com.trpg.gameservice.model.Game;
import com.trpg.gameservice.model.JoinedUser;
import com.trpg.gameservice.service.GameService;
import org.hibernate.mapping.Join;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/createGame/{user_uuid}")
    public ResponseEntity<Game> createGame(@RequestBody GameDto gameDto, @PathVariable UUID user_uuid){
        // dto validation
        Game game = Game.fromGameDto(gameDto);
        gameService.createGame(game,user_uuid);
        return ResponseEntity.ok(game);
    }

    @PostMapping("/addUser")
    public ResponseEntity<JoinedUser> addUser(@RequestBody JoinedUserDto joinedUserDto){
        JoinedUser joinedUser = JoinedUser.fromDto(joinedUserDto);
        gameService.addUser(joinedUser);
        return ResponseEntity.ok(joinedUser);
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<JoinedUser> addAdmin(@RequestBody JoinedUserDto joinedUserDto){
        JoinedUser joinedUser = JoinedUser.fromDto(joinedUserDto);
        gameService.addAdmin(joinedUser);
        return ResponseEntity.ok(joinedUser);
    }

    @PostMapping("/start-game")
    public ResponseEntity<JoinedUser> startGame(@RequestBody JoinedUserDto joinedUserDto){
        JoinedUser joinedUser = JoinedUser.fromDto(joinedUserDto);
        gameService.startGame(joinedUser);
        return ResponseEntity.ok(joinedUser);
    }

    @PostMapping("/stop-game")
    public ResponseEntity<JoinedUser> stopGame(@RequestBody JoinedUserDto joinedUserDto){
        JoinedUser joinedUser = JoinedUser.fromDto(joinedUserDto);
        gameService.stopGame(joinedUser);
        return ResponseEntity.ok(joinedUser);
    }

    @PostMapping("/get-game-status/{game_uuid}")
    public ResponseEntity<Integer> getGameStatus(@PathVariable UUID game_uuid){
            int status = gameService.getGameStatus(game_uuid);
        return ResponseEntity.ok(status);
    }






}
