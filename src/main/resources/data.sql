CREATE table users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    type VARCHAR(10) NOT NULL
);

INSERT INTO users (email, type) VALUES ('user@example.com', 'USER');
INSERT INTO users (email, type) VALUES ('admin@example.com', 'ADMIN');