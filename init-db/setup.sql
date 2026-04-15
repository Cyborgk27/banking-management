/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  slend
 * Created: 14 abr 2026
 */

USE test;

INSERT INTO clients (name, gender, age, identification, address, phone, client_id, password, status, is_deleted) VALUES
('Jose Lema', 'Masculino', 30, '1712345678', 'Otavalo sn y principal', '098254785', 'jlema', '1234', 1, 0),
('Mariana Montalvo', 'Femenino', 28, '1723456789', 'Amazonas y NNUU', '0987654321', 'mmontalvo', '5789', 1, 0),
('Juan Osorio', 'Masculino', 35, '1734567890', '13 junio y Equinoccial', '098874587', 'josorio', '1245', 1, 0),
('Leyner Rivera', 'Masculino', 32, '1745678901', 'Otavalo sn y principal', '0987654321', 'lrivera', '0856', 1, 0);

INSERT INTO accounts (account_number, account_type, initial_balance, status, is_deleted, client_id) VALUES
('478758', 'Ahorro', 2000.0, 1, 0, 1), -- Jose Lema
('225487', 'Corriente', 100.0, 1, 0, 2), -- Mariana Montalvo
('495878', 'Ahorro', 0.0, 1, 0, 3),      -- Juan Osorio
('496825', 'Ahorro', 540.0, 1, 0, 4),    -- Leyner Rivera
('585545', 'Corriente', 1000.0, 1, 0, 1); -- Nueva cuenta de Jose Lema

INSERT INTO movements (date, movement_type, value, balance, is_deleted, account_id) 
VALUES ('2026-04-01', 'Retiro', -575.0, 1425.0, 0, (SELECT id FROM accounts WHERE account_number = '478758' LIMIT 1));

INSERT INTO movements (date, movement_type, value, balance, is_deleted, account_id) 
VALUES ('2026-04-02', 'Deposito', 250.0, 1675.0, 0, (SELECT id FROM accounts WHERE account_number = '478758' LIMIT 1));

INSERT INTO movements (date, movement_type, value, balance, is_deleted, account_id) 
VALUES ('2026-04-01', 'Deposito', 600.0, 700.0, 0, (SELECT id FROM accounts WHERE account_number = '225487' LIMIT 1));

INSERT INTO movements (date, movement_type, value, balance, is_deleted, account_id) 
VALUES ('2026-04-03', 'Retiro', -100.0, 600.0, 0, (SELECT id FROM accounts WHERE account_number = '225487' LIMIT 1));

INSERT INTO movements (date, movement_type, value, balance, is_deleted, account_id) 
VALUES ('2026-04-01', 'Deposito', 150.0, 150.0, 0, (SELECT id FROM accounts WHERE account_number = '495878' LIMIT 1));

INSERT INTO movements (date, movement_type, value, balance, is_deleted, account_id) 
VALUES ('2026-03-25', 'Retiro', -540.0, 0.0, 0, (SELECT id FROM accounts WHERE account_number = '496825' LIMIT 1));

INSERT INTO movements (date, movement_type, value, balance, is_deleted, account_id) 
VALUES ('2026-04-10', 'Deposito', 300.0, 1975.0, 0, (SELECT id FROM accounts WHERE account_number = '478758' LIMIT 1));