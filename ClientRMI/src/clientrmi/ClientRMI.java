/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrmi;

import entities.Machine;
import entities.Salle;
import idao.IDao;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samia
 */
public class ClientRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");
             IDao<Salle> dao1 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao1");
            Salle s1 = new Salle("s1");
            Salle s2 = new Salle("s2");
            Salle s3 = new Salle("s3");
            Salle s4 = new Salle("s4");
            dao1.create(s1);
            dao1.create(s2);
            dao1.create(s3);
            dao1.create(s4);
            
           Machine m1 = new Machine("m1" , "HP" , 4000 ,s1);
             Machine m2 = new Machine("m2" , "Dell" , 5000 ,s2);
              Machine m3 = new Machine("m3" , "lenovo" , 9000 ,s4);
               Machine m4 = new Machine("m4" , "Mac" , 4000 ,s3);
              
               dao.create(m1);
               dao.create(m2);
               dao.create(m3);
               dao.create(m4);
               
            // for(Salle s : dao1.findAll())
             //   System.out.println(s);  
           
            
            for(Machine m : dao.findAll())
                System.out.println(m); 
                                       
            
            
        } catch (NotBoundException ex) {
    
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

