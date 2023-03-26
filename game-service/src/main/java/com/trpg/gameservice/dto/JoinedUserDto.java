package com.trpg.gameservice.dto;

import java.util.UUID;

public class JoinedUserDto {

    private UUID gameUuid;
    private UUID userUuid;
    private boolean admin;

    private JoinedUserDto(Builder builder) {
        this.gameUuid = builder.gameUuid;
        this.userUuid = builder.userUuid;
        this.admin = builder.admin;
    }

    // Getters and setters...
    public UUID getGameUuid() {
        return gameUuid;
    }

    public void setGameUuid(UUID gameUuid) {
        this.gameUuid = gameUuid;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID gameUuid;
        private UUID userUuid;
        private boolean admin = false;

        private Builder() {
        }

        public Builder gameUuid(UUID gameUuid) {
            this.gameUuid = gameUuid;
            return this;
        }

        public Builder userUuid(UUID userUuid) {
            this.userUuid = userUuid;
            return this;
        }

        public Builder admin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public JoinedUserDto build() {
            if (gameUuid == null || userUuid == null) {
                throw new IllegalStateException("Both gameUuid and userUuid must be provided");
            }
            return new JoinedUserDto(this);
        }
    }
}