CREATE TABLE IF NOT EXISTS deposit_product (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE,
    interest_rate NUMERIC NOT NULL,
    term_months INTEGER NOT NULL,
    min_amount NUMERIC NOT NULL,
    capitalization BOOLEAN NOT NULL
);