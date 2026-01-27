--meeting_roomsテーブル

CREATE TABLE IF NOT EXISTS meeting_rooms (
	
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    
    name VARCHAR(50) NOT NULL,  -- 会議室名
    
    description VARCHAR(255) NOT NULL, -- 室内の説明（ホワイトボードがあるか、窓際か）
    
    price INT NOT NULL, -- 料金（1日、1時間あたり）
    
    capacity INT NOT NULL, -- 定員
    
    address VARCHAR(255) NOT NULL, -- 住所
    
    phone_number VARCHAR(50) NOT NULL, -- 電話番号
    
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    
);

--rolesテーブル

CREATE TABLE IF NOT EXISTS roles (
	
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	
	name VARCHAR(50) NOT NULL
	
	);
	
--usersテーブル

CREATE TABLE IF NOT EXISTS users (
	
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	
	name VARCHAR(50) NOT NULL,
	
	furigana VARCHAR(50) NOT NULL,
	
	postal_code VARCHAR(50) NOT NULL,
	
	address VARCHAR(255) NOT NULL,
	
	phone_number VARCHAR(50) NOT NULL,
	
	email VARCHAR(255) NOT NULL UNIQUE,
	
	password VARCHAR(255) NOT NULL,
	
	roel_id INT NOT NULL,
	
	enabled BOOLEAN NOT NULL,
	
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	
	
)
	
)