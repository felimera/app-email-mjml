CREATE TABLE IF NOT EXISTS tbl_workspaces (
    wor_id BIGINT PRIMARY KEY,
    wor_name VARCHAR(255) NOT NULL,
    wor_description VARCHAR(500)
);