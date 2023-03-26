CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE  IF NOT EXISTS game(
    game_uuid uuid DEFAULT uuid_generate_v4(),
    game_status INT,
    game_name VARCHAR(50) ,
    game_background TEXT,
    PRIMARY KEY (game_uuid)
);

CREATE TABLE IF NOT EXISTS joined_user (
    game_uuid UUID,
    user_uuid UUID,
    Admin_assigned BOOLEAN NOT NULL,
    PRIMARY KEY(game_uuid, user_uuid)
);

CREATE TABLE IF NOT EXISTS background_img(
    game_uuid UUID,
    img_url VARCHAR,
    PRIMARY KEY (game_uuid)
);


