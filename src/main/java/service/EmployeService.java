package service;

import model.Employe;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeService implements IEmployeService{
     private static Map<Integer,Employe> map;
     static {
         map = new HashMap<>();
         Employe employe1 = new Employe(1,"Khánh Vân","09833332128");
         Employe employe2 = new Employe(2,"Khánh Ngân","09835332128");
         Employe employe3 = new Employe(3,"Khánh Ngọc","09833232128");
         Employe employe4 = new Employe(4,"Sahara","09833321628");
         Employe employe5 = new Employe(5,"Lan Ngọc","0983332128");
         Employe employe6 = new Employe(6,"mie","09833321y28");
         map.put(1,employe1);
         map.put(2,employe2);
         map.put(3,employe3);
         map.put(4,employe4);
         map.put(5,employe5);
         map.put(6,employe6);
     }



    @Override
    public List<Employe> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Employe findByID(int id) {
        return map.get(id);
    }

    @Override
    public void save(Employe employe) {
         map.put(employe.getId(),employe);

    }

    @Override
    public void edit(int id, Employe employe) {
         map.put(id,employe);

    }

    @Override
    public void remove(int id) {
         map.remove(id);
    }
}
