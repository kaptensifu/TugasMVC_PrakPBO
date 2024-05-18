/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdata_movie;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.data_movieimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Acer
 */
public class data_movieDAO implements data_movieimplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie;";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE movie set alur=?, penokohan=?, akting=?, nilai=? WHERE judul=?;";
    final String delete = "DELETE FROM `movie` WHERE judul=?";
    public data_movieDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(data_movie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement .RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            statement.setDouble(5, p.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(data_movie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setDouble(1, p.getAlur());
            statement.setDouble(2, p.getPenokohan());
            statement.setDouble(3, p.getAkting());
            statement.setDouble(4, p.getNilai());
            statement.setString(5, p.getJudul());
            statement.executeUpdate();
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(data_movie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, p.getJudul());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public List<data_movie> getAll() {
        List<data_movie> dp = null;
        try{
            dp = new ArrayList<data_movie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                data_movie movie = new data_movie();
                movie.setJudul(rs.getString("judul"));
                movie.setAlur(rs.getDouble("alur"));
                movie.setPenokohan(rs.getDouble("penokohan"));
                movie.setAkting(rs.getDouble("akting"));
                movie.setNilai(rs.getDouble("nilai"));
                dp.add(movie);
            }
        }catch(SQLException ex){
            Logger.getLogger(data_movieDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return dp;
    }
}
