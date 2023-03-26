package com.trpg.gameservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameDto {
    private UUID uuid;
    private int status;
    private String name;
    private String background;

    private GameDto(Builder builder) {
        this.uuid = builder.uuid;
        this.status = builder.status;
        this.name = builder.name;
        this.background = builder.background;
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

    public UUID getUuid() {
        return uuid;
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

    public static class Builder {
        private UUID uuid;
        private int status;
        private String name;
        private String background;

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

        public GameDto build() {
            return new GameDto(this);
        }
    }
}