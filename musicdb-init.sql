CREATE SCHEMA IF NOT EXISTS `musicdb` DEFAULT CHARACTER SET utf8 ;
USE `musicdb` ;

CREATE TABLE IF NOT EXISTS `musicdb`.`artists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `albums_num` INT NULL,
  `country` VARCHAR(45) NULL,
  `genre` VARCHAR(200) NULL,
  `is_active` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `musicdb`.`songs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `year` INT NULL,
  `duration` INT NULL,
  `album` VARCHAR(200) NULL,
  `number` INT NULL,
  `artists_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_songs_artists_idx` (`artists_id` ASC) VISIBLE,
  CONSTRAINT `fk_songs_artists`
    FOREIGN KEY (`artists_id`)
    REFERENCES `musicdb`.`artists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `musicdb`.`artists` (`name`, `albums_num`, `country`, `genre`, `is_active`) VALUES ('First Aid Kit', '5', 'Sweden', 'folk', '1');
INSERT INTO `musicdb`.`artists` (`name`, `albums_num`, `country`, `genre`, `is_active`) VALUES ('Louis Barabbas & The Bedlam Six', '3', 'England', 'folk', '0');
INSERT INTO `musicdb`.`artists` (`name`, `albums_num`, `country`, `genre`, `is_active`) VALUES ('Manowar', '12', 'USA', 'power metal', '1');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('King of the World', '2012', '219', 'The Lion\'s Roar', '10', '1');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('Master Pretender', '2014', '227', 'Stay Gold', '2', '1');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('Out of My Head', '2022', '214', 'Palomino', '1', '1');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('The Tell Tale Hound', '2010', '201', 'Found Drowned', '1', '2');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('The Debtor\'s Wife', '2014', '257', 'Youth', '4', '2');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('Short Supply', '2016', '202', 'Down Down Down', '11', '2');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('Wheels of Fire', '1988', '250', 'Kings of Metal', '1', '3');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('Shell Shock', '1982', '247', 'Battle Hymns', '4', '3');
INSERT INTO `musicdb`.`songs` (`name`, `year`, `duration`, `album`, `number`, `artists_id`) VALUES ('Outlaw', '1996', '202', 'Louder Than Hell', '6', '3');

