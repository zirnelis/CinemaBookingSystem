/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Properties;
import java.sql.Connection;
import com.mysql.jdbc.*;
import java.lang.Object;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elina
 */
public class db {
    String bdName;
    String host;
    String uName;
    String pass;

    public db(String bdName, String host, String uName, String pass) {
        this.bdName = bdName;
        this.host = host;
        this.uName = uName;
        this.pass = pass;
    }

    public String getBdName() {
        return bdName;
    }

    public String getUrl() {
        return host;
    }

    public String getuName() {
        return uName;
    }

    public String getPass() {
        return pass;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public void setUrl(String url) {
        this.host = url;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    private Connection connect(String dbName, String uName, String pass) throws SQLException {
        
        Connection conn = null;
        conn = (Connection) DriverManager.getConnection(host, uName, pass);
        
        return conn;
    }
    
    public void creatingTables() throws SQLException {
//        String sqlDropTable = "DROP TABLE IF EXISTS Order";
        String setKeys = "SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;"
                + "SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;"
                + "SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';";
        
        String setDropandCreate = "DROP SCHEMA IF EXISTS `mydb` ;"
                + "CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;"
                + "USE `mydb` ;";
//        String dropCinemaTable = "DROP TABLE IF EXISTS `mydb`.`Cinema` ;";
                
        String sqlCinemaTable = "CREATE TABLE IF NOT EXISTS `mydb`.`Cinema` (\n"
                + "`idCinema` INT NOT NULL AUTO_INCREMENT, \n"
                + "`Name` VARCHAR(45) NULL, \n"
                + "`Location` VARCHAR(45) NULL, \n"
                + "`Address` VARCHAR(45) NULL, \n"
                + "PRIMARY KEY (`idCinema`)) \n"
                + "ENGINE = InnoDB; \n";
        
        String sqlMovieTable = "CREATE TABLE IF NOT EXISTS `mydb`.`Movie` (\n"
                + "`idMovie` INT NOT NULL AUTO_INCREMENT, \n"
                + "`Name` VARCHAR(45) NULL, \n"
                + "`Type` VARCHAR(45) NULL, \n"
                + "`Date` DATE NULL, \n"
                + "`Time` TIME(10) NULL, \n"
                + "`Cinema_idCinema` INT NOT NULL, \n"
                + "PRIMARY KEY (`idMovie`, `Cinema_idCinema`), \n"
                + "INDEX `fk_Movie_Cinema_idx` (`Cinema_idCinema` ASC)) \n"
                + "ENGINE = InnoDB;";
        
        String sqlAuditoryTable = "CREATE TABLE IF NOT EXISTS `mydb`.`Auditory` (\n"
                + "`idAuditory` INT NOT NULL AUTO_INCREMENT, \n"
                + "`Name` VARCHAR(45) NULL, \n"
                + "`Row` INT NULL, \n"
                + "`Seat` INT NULL, \n"
                + "PRIMARY KEY (`idAuditory`)) \n"
                + "ENGINE = InnoDB; \n";
        
        String sqlTicketTable = "CREATE TABLE IF NOT EXISTS `mydb`.`Ticket` (\n"
                + "`idTicket` INT NOT NULL AUTO_INCREMENT, \n"
                + "`Price` DOUBLE NULL, \n"
                + "`Type` VARCHAR(45) NULL, \n"
                + "`Movie_idMovie` INT NOT NULL, \n"
                + "`Movie_Cinema_idCinema` INT NOT NULL, \n"
                + "`Auditory_idAuditory` INT NOT NULL,\n"
                + "PRIMARY KEY (`idTicket`, `Movie_idMovie`, `Movie_Cinema_idCinema`, `Auditory_idAuditory`),\n"
                + "INDEX `fk_Ticket_Movie1_idx` (`Movie_idMovie` ASC, `Movie_Cinema_idCinema` ASC),\n"
                + "INDEX `fk_Ticket_Auditory1_idx` (`Auditory_idAuditory` ASC))\n"
                + "ENGINE = InnoDB;";
        
        String setModeAndChecks = "SET SQL_MODE=@OLD_SQL_MODE;\n"
                + "SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS; \n"
                + "SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; \n";
        
        Connection conn = this.connect();
        Statement stmt = (Statement) conn.createStatement();
        stmt.execute(setKeys);
        stmt.execute(setDropandCreate);
//        stmt.execute(dropCinemaTable);
        stmt.execute(sqlCinemaTable);
        stmt.execute(sqlMovieTable);
        stmt.execute(sqlAuditoryTable);
        stmt.execute(sqlTicketTable);
        stmt.execute(setModeAndChecks);
        
        System.out.println("Creating tables..");
        
    }

    private Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
