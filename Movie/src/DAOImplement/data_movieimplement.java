/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author Acer
 */
public interface data_movieimplement {
    public void insert(data_movie p);
    public void update(data_movie p);
    public void delete(data_movie p);
    public List<data_movie> getAll();
}
