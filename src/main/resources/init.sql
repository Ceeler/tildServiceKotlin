DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY ,
    first_name CHARACTER VARYING(64) NOT NULL,
    last_name CHARACTER VARYING(64),
    username CHARACTER VARYING(64) UNIQUE NOT NULL,
    email CHARACTER VARYING(64) UNIQUE NOT NULL,
    password CHARACTER VARYING(64) NOT NULL,
    user_position CHARACTER VARYING(64),
    description CHARACTER VARYING(128),
    status CHARACTER VARYING(32),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS projects(
    id BIGSERIAL PRIMARY KEY,
    project_name CHARACTER VARYING(64) NOT NULL,
    project_description CHARACTER VARYING(128),
    ended_at DATE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS project_user(
    user_id INTEGER NOT NULL REFERENCES users(id),
    project_id INTEGER NOT NULL REFERENCES projects(id),
    UNIQUE (user_id, project_id)
    );

CREATE TABLE IF NOT EXISTS tasks(
    id BIGSERIAL PRIMARY KEY,
    task_name CHARACTER VARYING(64) NOT NULL,
    task_description CHARACTER VARYING(128),
    author_id INTEGER NOT NULL REFERENCES users(id),
    project_id INTEGER NOT NULL REFERENCES projects(id),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS user_task(
    user_id INTEGER NOT NULL REFERENCES users(id),
    task_id INTEGER NOT NULL REFERENCES tasks(id),
    UNIQUE (user_id, task_id)
    );

CREATE TABLE IF NOT EXISTS project_messages(
    id BIGSERIAL PRIMARY KEY,
    project_text CHARACTER VARYING(128) NOT NULL,
    author_id INTEGER NOT NULL REFERENCES users(id),
    project_id INTEGER NOT NULL REFERENCES projects(id),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS comments(
    id BIGSERIAL PRIMARY KEY,
    comment_text CHARACTER VARYING(128) NOT NULL,
    author_id INTEGER NOT NULL REFERENCES users(id),
    project_message_id INTEGER NOT NULL REFERENCES project_messages(id),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS direct_messages(
    id BIGSERIAL PRIMARY KEY,
    message_text CHARACTER VARYING(128) NOT NULL,
    author_id INTEGER NOT NULL REFERENCES users(id),
    receiver_id INTEGER NOT NULL REFERENCES users(id),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS jwt_tokens(
    id BIGSERIAL PRIMARY KEY,
    refresh_token UUID NOT NULL,
    user_id INTEGER NOT NULL REFERENCES users(id),
    useragent CHARACTER VARYING(200),
    fingerprint CHARACTER VARYING(200),
    expires_in BIGINT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
    );