CREATE TABLE IF NOT EXISTS workspaces (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500)
);