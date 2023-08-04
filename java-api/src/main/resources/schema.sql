
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS trade;


CREATE TABLE IF NOT EXISTS client (
    client_id INT PRIMARY KEY,
    client_name VARCHAR(50),
    client_surname VARCHAR(50),
    client_email VARCHAR(150),
    client_department VARCHAR(50),
    client_role VARCHAR(50),
    client_password_hash VARCHAR(100) -- Adjust the length as per your hashing algorithm
);

CREATE TABLE IF NOT EXISTS book (
    isin VARCHAR(12) PRIMARY KEY,
    book_currency VARCHAR(50),
    cusip VARCHAR(9),
    face_value INT,
    issuer_name VARCHAR(255),
    book_maturity_date DATE,
    status VARCHAR(50),
    type VARCHAR(50),
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES client (client_id)
);

CREATE TABLE IF NOT EXISTS trade (
    trade_id INT PRIMARY KEY,
    isin VARCHAR(12),
    trade_type VARCHAR(50),
    trade_currency VARCHAR(50),
    quantity INT,
    trade_settlement_date DATE,
    trade_status VARCHAR(50),
    trade_date DATE,
    unit_price DECIMAL(10,2),
    coupon_percent DECIMAL(5,3),
    book_name VARCHAR(255),
    book_holder VARCHAR(255),
    FOREIGN KEY (isin) REFERENCES book(isin)
);