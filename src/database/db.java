/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import cinemabookingsystem.Movie;
import cinemabookingsystem.Ticket;
import java.sql.Connection;
import com.mysql.jdbc.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

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

    private Connection connect() throws SQLException {
        Connection connection = null;
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        connection = DriverManager.getConnection(url, user, "");
   
        System.out.println("database connected..");
        
        return connection;
    }
    
    public void selectFrom(String tableName, ArrayList<String> emptyArray) throws SQLException {
        ArrayList<String> tmp = new ArrayList<>();
        String useDB = "USE "+tableName;
        String select = "SELECT * FROM "+tableName;
        try (Connection conn = this.connect();
            java.sql.PreparedStatement pstmt = conn.prepareStatement(select)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
//                tmp.add(rs.getArray(uName));
            }
        }
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
    
     public void closeDB(Connection conn) throws SQLException {
        if(conn!=null) {
            conn.close();
        }
    }
     
     public void writeInCinemaTable(String Name, String Location, String Address) throws SQLException {
        String insert = "INSERT INT TABLE `cinema`("
                + "`Name`,"
                + "`Location`,"
                + "`Address`) "
                + "VALUES ("
                + "`"+Name+"`, "
                + "`"+Location+"`, "
                + "`"+Address+"`)";
        Connection conn = this.connect();
        Statement stmt = (Statement) conn.createStatement();
        stmt.execute(insert);
        System.out.println("Ieraksts tabula tika veikts..");
     }
     
     public void writeInMovieTable(String Movie, String Name, String Type, Date Date, Time Time, int Cinemaid) throws SQLException {
        String insert = "INSERT INTO `movie`("
                + "`Name`, "
                + "`Type`, "
                + "`Date`, "
                + "`Time`, "
                + "`Cinema_idCinema`) "
                + "VALUES ("
                + "`"+Movie+"`,"
                + "`"+Name+"`,"
                + "`"+Type+"`,"
                + "`"+Date+"`,"
                + "`"+Time+"`,"
                + ""+Cinemaid+")";
        Connection conn = this.connect();
        Statement stmt = (Statement) conn.createStatement();
        stmt.execute(insert);
        System.out.println("Ieraksts tabula tika veikts..");
     }
     
     public void writeInAuditoryTable(int row, int seat) throws SQLException {
        String insert = "INSERT INTO `auditory`("
                + "`Row`, "
                + "`Seat`) "
                + "VALUES ("
                + ""+row+","
                + ""+seat+")";
        Connection conn = this.connect();
        Statement stmt = (Statement) conn.createStatement();
        stmt.execute(insert);
        System.out.println("Ieraksts tabula tika veikts..");
     }
     
     public void writeInTicketTable(Double Price, String Type, int Movieid, int MovieCinemaid, int Auditoryid) throws SQLException {
        String insert = "INSERT INTO `ticket`("
                + "`Price`, "
                + "`Type`, "
                + "`Movie_idMovie`, "
                + "`Movie_Cinema_idCinema`, "
                + "`Auditory_idAuditory`) "
                + "VALUES ("
                + ""+Price+","
                + "`"+Type+"`,"
                + ""+Movieid+","
                + ""+MovieCinemaid+","
                + ""+Auditoryid+")";
        Connection conn = this.connect();
        Statement stmt = (Statement) conn.createStatement();
        stmt.execute(insert);
        System.out.println("Ieraksts tabula tika veikts..");
     }
     
     public ArrayList<Movie> selectAllMoviesSQL() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        String nameTmp, typeTmp;
        Date dateTmp;
        Time timeTmp;
        int cinemaidTmp;
//        String selectDB = "USE mydb"; 
        String select = "SELECT * FROM Movie"; 
        
        try (Connection conn = this.connect();
            java.sql.PreparedStatement pstmt = conn.prepareStatement(select)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                nameTmp = rs.getString("Name");
                typeTmp = rs.getString("Type");
                dateTmp = rs.getDate("Date");
                timeTmp = rs.getTime("Time");
                cinemaidTmp = rs.getInt("Cinema_idCienema");
                movies.add(new Movie(nameTmp, typeTmp, dateTmp, timeTmp, cinemaidTmp));
            }
        }
        return movies;
    }
}
