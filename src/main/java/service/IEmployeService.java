package service;

import model.Employe;

import java.util.List;

public interface IEmployeService {
    List<Employe> findAll();
    Employe findByID(int id);
    void save(Employe employe);
    void edit(int id, Employe employe);
    void remove(int id);

}
