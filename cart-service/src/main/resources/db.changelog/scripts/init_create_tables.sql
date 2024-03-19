CREATE TABLE Cart (
                      id SERIAL PRIMARY KEY,
                      account_id INT NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                      --FOREIGN KEY (account_id) REFERENCES Account(id)
);
