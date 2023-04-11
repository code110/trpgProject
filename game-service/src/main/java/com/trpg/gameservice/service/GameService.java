package com.trpg.gameservice.service;

import com.trpg.gameservice.model.Game;
import com.trpg.gameservice.model.JoinedUser;
import com.trpg.gameservice.repository.GameRepository;
import com.trpg.gameservice.repository.JoinedUserRepository;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final JoinedUserRepository joinedUserRepository;
    public GameService(GameRepository gameRepository, JoinedUserRepository joinedUserRepository) {
        this.gameRepository = gameRepository;
        this.joinedUserRepository = joinedUserRepository;
    }

    public Boolean createGame(Game game, UUID user_uuid) {
        if(!validate(game)){
            return false;
        }
        Game response = gameRepository.save(game);

        // set gameCreator user as admin
        JoinedUser joinedUser = JoinedUser.builder()
                .gameUuid(response.getUuid())
                .userUuid(user_uuid)
                .admin(true)
                .build();
        joinedUserRepository.save(joinedUser);
        return true;
    }

    public boolean startGame(JoinedUser requestJoinedUser){
        UUID game_uuid = requestJoinedUser.getGameUuid();
        UUID user_uuid = requestJoinedUser.getUserUuid();

        Optional<Game> userResponse = joinedUserRepository.findById(user_uuid);
        JoinedUser joinedUser = (JoinedUser) userResponse.get();
        if (joinedUser.isAdmin()){
            Optional<Game> gameResponse = gameRepository.findById(game_uuid);
            Game game = gameResponse.get();
            game.setStatus(1); // 1 for running
            gameRepository.save(game);
            return true;
        }
        return false;

    }

    public boolean stopGame(JoinedUser requestJoinedUser){
        UUID game_uuid = requestJoinedUser.getGameUuid();
        UUID user_uuid = requestJoinedUser.getUserUuid();

        Optional<Game> userResponse = joinedUserRepository.findById(user_uuid);
        JoinedUser joinedUser = (JoinedUser) userResponse.get();
        if (joinedUser.isAdmin()){
            Optional<Game> gameResponse = gameRepository.findById(game_uuid);
            Game game = gameResponse.get();
            game.setStatus(2); // 2 for stopped
            gameRepository.save(game);
            return true;
        }
        return false;

    }

    public boolean addAdmin(JoinedUser joinedUser){
        joinedUser.setAdmin(true);
        joinedUserRepository.save(joinedUser);
        return true;
    }

    public boolean addUser(JoinedUser joinedUser){
        joinedUser.setAdmin(false);
        joinedUserRepository.save(joinedUser);
        return true;
    }

    public int getGameStatus(UUID game_uuid){
        Optional<Game> gameResponse = gameRepository.findById(game_uuid);
        Game game = gameResponse.get();
        return game.getStatus();
    }

    public boolean validate(Game game){
        //Game background too long
        if (game.getBackground().length() > 300){
            return false;
        }
        return true;
    }
}
