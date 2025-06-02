CREATE TABLE IF NOT EXISTS deposit (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    amount DECIMAL(19,2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    product_id SERIAL NOT NULL
);

ALTER TABLE deposit 
ADD CONSTRAINT fk_deposit_product 
FOREIGN KEY (product_id) REFERENCES deposit_product(id)