INSERT INTO users (name) VALUES ('AZ Holdings Inc');
INSERT INTO users (name) VALUES ('Acme co');
INSERT INTO users (name) VALUES ('Astra Trading Ltd');
INSERT INTO users (name) VALUES ('Sovereign Investments');
INSERT INTO users (name) VALUES ('Muncipal Gov Of Orange County');
INSERT INTO users (name) VALUES ('Goldman Sachs');
INSERT INTO users (name) VALUES ('UBS');
INSERT INTO users (name) VALUES ('Barclays');
INSERT INTO users (name) VALUES ('British Telecom');
INSERT INTO users (name) VALUES ('Pension Holdings');
INSERT INTO users (name) VALUES ('Zurich Pension fund 4');

INSERT INTO book (name) VALUES ('trading_book_1');
INSERT INTO book (name) VALUES ('trading_book_2');
INSERT INTO book (name) VALUES ('trading_book_3');
INSERT INTO book (name) VALUES ('trading_book_4');
INSERT INTO book (name) VALUES ('trading_book_5');
INSERT INTO book (name) VALUES ('trading_book_6');

INSERT INTO book_user (book_users_id, user_id, book_id) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 3),
(5, 3, 1);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (1, 'buy', 'USD', 50, '2021-08-04', 'open', '2021-05-13', 90, 4.37, 'USD', '', 1000, 'XS1988387210', 1, '2021-08-05', 'active', 'CORP', 1);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (1, 'sell', 'GBP', 40, '2021-08-04', 'open', '2021-02-04', 89.56, 4.37, 'USD', '', 1000, 'XS1988387210', 1, '2021-08-05', 'active', 'CORP', 1);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (2, 'buy', 'USD', 1000, '2021-08-23', 'open', '2021-05-13', 105.775, 3.15, 'USD', '123456780', 900, 'USN0280EAR64', 2, '2021-07-30', 'active', 'CORP', 2);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (2, 'sell', 'GBP', 900, '2021-09-10', 'open', '2021-02-04', 105.775, 3.15, 'USD', '123456780', 900, 'USN0280EAR64', 2, '2021-07-30', 'active', 'CORP', 2);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (3, 'buy', 'USD', 50, '2021-08-23', 'open', '2021-05-13', 90, 2, 'USD', '123456bh0', 900, 'A12356111', 3, '2021-09-30', 'active', 'CORP', 3);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (2, 'buy', 'USD', 1000, '2021-08-23', 'open', '2021-05-13', 105.775, 3.15, 'USD', '123456780', 900, 'USN0280EAR64', 2, '2021-07-30', 'active', 'CORP', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (3, 'sell', 'USD', 50, '2021-08-23', 'open', '2021-05-13', 90, 2, 'USD', '123456bh0', 900, 'A12356111', 3, '2021-09-30', 'active', 'CORP', 3);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'GBP', 60, '2021-09-27', 'open', '2021-02-04', 98.56, 3.15, 'USD', 'AMZN 3.15 08/22/27 REGS', 900, 'USU02320AG12', 4, '2021-08-03', 'active', 'CORP', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 50, '2021-08-23', 'open', '2021-08-23', 98.56, 3.15, 'USD', 'AMZN 3.15 08/22/27 REGS', 900, 'USU02320AG12', 4, '2021-08-03', 'active', 'CORP', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'buy', 'GBP', 1100, '2021-09-27', 'open', '2021-09-27', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460505', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'sell', 'GBP', 900, '2021-09-28', 'open', '2021-09-28', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460506', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'buy', 'GBP', 2000, '2021-09-29', 'open', '2021-09-29', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460507', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'sell', 'GBP', 2000, '2021-09-30', 'open', '2021-09-30', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460508', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'buy', 'GBP', 1000, '2021-10-01', 'open', '2021-10-01', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460509', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'buy', 'GBP', 900, '2019-10-02', 'open', '2019-10-02', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460510', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'sell', 'GBP', 1900, '2019-10-03', 'open', '2019-10-03', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460511', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'buy', 'GBP', 600, '2018-10-04', 'open', '2018-10-04', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460512', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'buy', 'GBP', 600, '2019-10-05', 'open', '2019-10-05', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460513', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'buy', 'GBP', 700, '2021-06-06', 'open', '2021-06-06', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460514', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (6, 'sell', 'GBP', 1300, '2021-10-07', 'open', '2011-10-07', 110.35, 0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460515', 6, '2021-08-09', 'active', 'GOVN', 6);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 60, '2021-09-27', 'open', '2012-04-02', 100.13, 2.02, 'USD', '87973RAA8', 690, 'US87973RAA86', 7, '2021-08-06', 'active', 'SOVN', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 50, '2021-08-23', 'open', '2012-08-23', 100.13, 2.02, 'USD', '87973RAA8', 690, 'US87973RAA86', 7, '2021-08-06', 'active', 'SOVN', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 75, '2021-09-27', 'open', '2013-04-02', 100.13, 2.02, 'USD', '87973RAA8', 690, 'US87973RAA86', 7, '2021-08-06', 'active', 'SOVN', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 50, '2021-08-23', 'open', '2014-08-23', 100.13, 2.02, 'USD', '87973RAA8', 690, 'US87973RAA86', 7, '2021-08-06', 'active', 'SOVN', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 300, '2021-09-27', 'open', '2016-02-04', 98.76, 1.123, 'USD', '87973RAA8', 340, 'IE00B29LNP31', 8, '2030-12-22', 'active', 'SOVN', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 300, '2021-08-23', 'open', '2012-08-23', 98.76, 1.123, 'USD', '87973RAA8', 340, 'IE00B29LNP31', 8, '2030-12-22', 'active', 'SOVN', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'buy', 'USD', 300, '2021-09-27', 'open', '2013-04-02', 98.76, 1.123, 'USD', '87973RAA8', 340, 'IE00B29LNP31', 8, '2030-12-22', 'active', 'SOVN', 4);

INSERT INTO trade (book_id, trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value_mn, isin, issuer_id, bond_maturity_date, status, type, bond_holder_id)
VALUES (4, 'sell', 'USD', 300, '2021-08-23', 'open', '2015-08-23', 98.76, 1.123, 'USD', '87973RAA8', 340, 'IE00B29LNP31', 8, '2030-12-22', 'active', 'SOVN', 4);
