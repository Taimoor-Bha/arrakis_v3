CREATE TABLE IF NOT EXISTS users (
    users_id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS book (
    books_id INT PRIMARY KEY,
    user_id INT,
    name VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(users_id)
);

CREATE TABLE IF NOT EXISTS trade (
    trade_id INT PRIMARY KEY,
    book_id INT,
    trade_type VARCHAR(10),
    trade_currency VARCHAR(3),
    quantity INT,
    trade_settlement_date DATE,
    trade_status VARCHAR(10),
    trade_date DATE,
    unit_price DECIMAL(10,2),
    coupon_percent DECIMAL(10,2),
    bond_currency VARCHAR(3),
    cusip VARCHAR(20),
    face_value_mn INT,
    isin VARCHAR(20),
    issuer_id INT,
    bond_maturity_date DATE,
    status VARCHAR(10),
    type VARCHAR(10),
    bond_holder_id INT,
    FOREIGN KEY (book_id) REFERENCES book(books_id),
    FOREIGN KEY (issuer_id) REFERENCES users(users_id),
    FOREIGN KEY (bond_holder_id) REFERENCES users(users_id)
);
