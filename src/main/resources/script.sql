CCREATE TABLE `mydatabase`.`contact` (
 `id` INT NOT NULL,
`cnpj` LONG NOT NULL
 `name` VARCHAR(255) NULL,
 `lastbuy` VARCHAR(255) NULL,
 `qualityrate` VARCHAR(45) NULL,
`probnewdeals` INT NOT NULL,
 PRIMARY KEY (`id`));

 ALTER TABLE `mydatabase`.`supplier`
 CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
 ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

