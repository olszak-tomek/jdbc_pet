public interface PetTableQueries {
    String CREATE_DATABASE_QUERY = "create database if not exists `jdbc_pet`;";
    String CREATE_TABLE_QUERY = "create table if not exists `students` (\n" +
            "`id` INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "`name` VARCHAR(30) NOT NULL,\n" +
            "`age` INT NOT NULL,\n" +
            "`ownerName` VARCHAR(30) NOT NULL,\n" +
            "`weight` DOUBLE,\n" +

            "`pureRace` BOOLEAN NOT NULL);";
    String INSERT_PET_QUERY = "insert into `pets` (`name`, `age`, `ownerName`, `weight`, `pureRace`) values ( ?, ?, ?, ?, ?);";

    String SELECT_ALL_PETS_QUERY =
            "select * from `pets`;";

    String UPDATE_PET_QUERY = "update `pets` set " +
            "`name`= ?, " +
            "`age` = ?, " +
            "`ownerName` = ?, " +
            "`weight`= ?, " +
            "`pureRace`= ? " +
            "where `id` = ?;";

    String DELETE_PET_QUERY = "delete from `pets` where `id` = ?;";
}