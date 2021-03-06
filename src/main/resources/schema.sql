DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
	`id` INTEGER AUTO_INCREMENT PRIMARY KEY,
	`brand_id` INTEGER NOT NULL,
	`curr` VARCHAR(3) NOT NULL,
	`end_date` TIMESTAMP NOT NULL,
	`price` DECIMAL NOT NULL,
	`price_list` INTEGER NOT NULL,
	`priority` INTEGER NOT NULL,
	`product_id` INTEGER NOT NULL,
	`start_date` TIMESTAMP NOT NULL
);