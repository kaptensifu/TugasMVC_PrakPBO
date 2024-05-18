/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdata_movie.data_movieDAO;
import DAOImplement.data_movieimplement;
import model.*;
import view.MainView;
/**
 *
 * @author Acer
 */
public class data_moviecontroller {
    MainView frame;
    data_movieimplement impldata_movie;
    List<data_movie> dp;
    
    public data_moviecontroller(MainView frame){
        this.frame = frame;
        impldata_movie = new data_movieDAO();
        dp = impldata_movie.getAll();
        
    }
    public void isitabel(){
        dp = impldata_movie.getAll();
        tabel_data_movie mp = new tabel_data_movie(dp);
        frame.getTabelData_movie().setModel(mp);
    }
    
    public void insert(){
        data_movie dp = new data_movie();
        dp.setJudul(frame.getJtxtjudul().getText());
        double nilaiAlur = Double.parseDouble(frame.getJtxtalur().getText());
        dp.setAlur(nilaiAlur);
        double nilaiPenokohan = Double.parseDouble(frame.getJtxtpenokohan().getText());
        dp.setPenokohan(nilaiPenokohan);
        double nilaiAkting = Double.parseDouble(frame.getJtxtakting().getText());
        dp.setAkting(nilaiAkting);
        dp.setNilai(dp.menghitungNilai());
        impldata_movie.insert(dp);
    }
    
    public void update(){
        data_movie dp = new data_movie();
        double nilaiAlur = Double.parseDouble(frame.getJtxtalur().getText());
        dp.setAlur(nilaiAlur);
        double nilaiPenokohan = Double.parseDouble(frame.getJtxtpenokohan().getText());
        dp.setPenokohan(nilaiPenokohan);
        double nilaiAkting = Double.parseDouble(frame.getJtxtakting().getText());
        dp.setAkting(nilaiAkting);
        dp.setNilai(dp.menghitungNilai());
        dp.setJudul(frame.getJtxtjudul().getText());
        impldata_movie.update(dp);
        
    }
    
    public void delete(){
        data_movie dp = new data_movie();
        dp.setJudul(frame.getJtxtjudul().getText());
        impldata_movie.delete(dp);
    }
}
