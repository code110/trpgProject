package com.trpg.gameservice.model;

import com.trpg.gameservice.dto.GameDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
@Entity(name = "game")
@Table(
        name = "game"
)
public class Game {
    @Id
    @Column(
            name = "game_uuid",
            updatable = false
    )
    private UUID uuid;
    @Column(
            name = "game_status",
            nullable = false
    )
    private int status;
    @Column(
            name = "game_name",
            nullable = false
    )
    private String name;
    @Column(
            name = "game_background",
            nullable = false
    )
    private String background;

    public Game() {
    }


    public UUID getUuid() {
        return uuid;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getBackground() {
        return background;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBackground(String background) {
        this.background = background;
    }


    private Game(Builder builder){
        this.setUuid(builder.uuid);
        this.setStatus(builder.status);
        this.setName(builder.name);
        this.setBackground(builder.background);
    }

    public static Game fromGameDto(GameDto gameDto){
        return Game.Builder.newBuilder()
                .setUuid(gameDto.getUuid())
                .setName(gameDto.getName())
                .setStatus(gameDto.getStatus())
                .setBackground(gameDto.getBackground())
                .build();
    }


    public static class Builder {
        private UUID uuid;
        private int status;
        private String name;
        private String background;

        private Builder(){
        }
        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setStatus(int status) {
            this.status = status;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBackground(String background) {
            this.background = background;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

}
