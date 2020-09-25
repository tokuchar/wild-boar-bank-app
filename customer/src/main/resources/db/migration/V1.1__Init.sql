-- -----------------------------------------------------
-- Schema boar_customer_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BOAR_CUSTOMER_DB` DEFAULT CHARACTER SET utf8;
-- -----------------------------------------------------
-- Schema BOAR_CUSTOMER_DB
-- -----------------------------------------------------
USE `BOAR_CUSTOMER_DB`;

-- -----------------------------------------------------
-- Table `BOAR_CUSTOMER_DB`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOAR_CUSTOMER_DB`.`customer`
(
    `customer_id`       INT         NOT NULL AUTO_INCREMENT,
    `name`              VARCHAR(45) NULL,
    `surname`           VARCHAR(45) NULL,
    `birth_date`        DATE        NULL,
    `identity_document` VARCHAR(45) NULL,
    PRIMARY KEY (`customer_id`),
    UNIQUE INDEX `customer_id_UNIQUE` (`customer_id` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOAR_CUSTOMER_DB`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOAR_CUSTOMER_DB`.`address`
(
    `address_id`   INT                                  NOT NULL AUTO_INCREMENT,
    `city`         VARCHAR(45)                          NULL,
    `street`       VARCHAR(45)                          NULL,
    `house_number` VARCHAR(45)                          NULL,
    `zip_code`     VARCHAR(45)                          NULL,
    `address_type` ENUM ('RESIDENCE', 'CORRESPONDENCE') NULL,
    `customer_id`  INT                                  NOT NULL,
    PRIMARY KEY (`address_id`),
    UNIQUE INDEX `address_id_UNIQUE` (`address_id` ASC) VISIBLE,
    INDEX `fk_address_customer1_idx` (`customer_id` ASC) VISIBLE,
    CONSTRAINT `fk_address_customer1`
        FOREIGN KEY (`customer_id`)
            REFERENCES `BOAR_CUSTOMER_DB`.`customer` (`customer_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOAR_CUSTOMER_DB`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOAR_CUSTOMER_DB`.`contact`
(
    `contact_id`    INT                            NOT NULL AUTO_INCREMENT,
    `contact_value` VARCHAR(45)                    NULL,
    `contact_type`  ENUM ('EMAIL', 'PHONE_NUMBER') NULL,
    `customer_id`   INT                            NOT NULL,
    PRIMARY KEY (`contact_id`),
    UNIQUE INDEX `contact_id_UNIQUE` (`contact_id` ASC) VISIBLE,
    INDEX `fk_contact_customer1_idx` (`customer_id` ASC) VISIBLE,
    CONSTRAINT `fk_contact_customer1`
        FOREIGN KEY (`customer_id`)
            REFERENCES `BOAR_CUSTOMER_DB`.`customer` (`customer_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOAR_CUSTOMER_DB`.`identity_document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOAR_CUSTOMER_DB`.`identity_document`
(
    `document_id`     INT         NOT NULL AUTO_INCREMENT,
    `identity`        VARCHAR(45) NULL,
    `expiration_date` DATE        NULL,
    `customer_id`     INT         NOT NULL,
    PRIMARY KEY (`document_id`),
    UNIQUE INDEX `document_id_UNIQUE` (`document_id` ASC) VISIBLE,
    INDEX `fk_identity_document_customer_idx` (`customer_id` ASC) VISIBLE,
    CONSTRAINT `fk_identity_document_customer`
        FOREIGN KEY (`customer_id`)
            REFERENCES `BOAR_CUSTOMER_DB`.`customer` (`customer_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
