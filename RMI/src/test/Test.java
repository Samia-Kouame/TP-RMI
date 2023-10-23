/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Machine;
import entities.Salle;
import idao.IDao;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author samia
 */
public class Test {
    public static void main(String[] args) {
        try {
            IDao<Machine> dao = new MachineService();
            IDao<Salle> dao1 = new SalleService();
            Salle s1 = new Salle("s1");
            Salle s2 = new Salle("s2");
            Salle s3 = new Salle("s3");
            Salle s4 = new Salle("s4");
            dao1.create(s1);
            dao1.create(s2);
            dao1.create(s3);
            dao1.create(s4);
           
            dao.create(new Machine("m1" , "HP" , 4000 ,s1));
            dao.create(new Machine("m2" , "Dell" , 2802 ,s4));
            dao.create(new Machine("m3" , "Lenovo" , 3000 ,s2));
            dao.create(new Machine("m4" , "Mac" , 250000 ,s3));
           
            for (Salle s :dao1.findAll())
              System.out.println(s); 
            
           for (Machine m :dao.findAll())
             System.out.println(m); 
                
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
