/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import entities.Machine;
import entities.Salle;
import idao.IDao;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samia
 */
public class MachineForm extends javax.swing.JInternalFrame {
    IDao<Machine> dao = null;
    IDao<Salle> dao1 = null;
    DefaultTableModel model = null ;
    private static MachineForm mform;
   
    /**
     * Creates new form MachcineForm
     */
    public MachineForm() {
        
            initComponents();
            model = (DefaultTableModel) listMachine.getModel();
            try {
             dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");
             dao1 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao1");
            load1();
            load();
            
            loadSalle();
        } catch (NotBoundException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MachineForm getInstance(){
        if(mform == null ||mform.isClosed())
            mform = new MachineForm();
        return mform;
    }
    
    public void load (){
        try {
            model.setRowCount(0);
            for(Machine m : dao.findAll())
            model.addRow(new Object[]{
            m.getId(),
            m.getRef(),
            m.getMarque(),
            m.getPrix(),
            m.getSalle().getCode()
        });
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    public void load1(){
        Salle s = (Salle) filtreTxt.getSelectedItem();
        try {
            model.setRowCount(0);
            for(Machine m : dao.findAll()){
               if (s.getId() == m.getSalle().getId()) {
                model.addRow(new Object[]{
                    m.getId(),
                    m.getRef(),
                    m.getMarque(),
                    m.getPrix(),
                    m.getSalle().getCode()
                });
            }}
        }catch(RemoteException ex) {
           Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
     public void loadSalle(){
         try {
             for(Salle s : dao1.findAll()){
                 salleList.addItem(s);
                 filtreTxt.addItem(s);}
         } catch (RemoteException ex) {
             Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     
      private List<Machine> filtreMachinesSalle(Salle salle) {
         List<Machine> machineFiltre = new ArrayList<>();
          try {
             List<Machine> toutesLesMachines = dao.findAll(); 
             
            
             
             for (Machine machine : toutesLesMachines) {
                 if (machine.getSalle().equals(salle)) {
                     machineFiltre.add(machine);
                 }
             }
         } catch (RemoteException ex) {
             Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
         }
         return machineFiltre;
      }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        referenceTxt = new javax.swing.JTextField();
        marqueTxt = new javax.swing.JTextField();
        prixTxt = new javax.swing.JTextField();
        salleList = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        ajouterTxt = new javax.swing.JButton();
        modifierTxt = new javax.swing.JButton();
        supprimerTxt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        filtreTxt = new javax.swing.JComboBox();
        CheckTxt = new javax.swing.JCheckBox();
        applyTxt = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listMachine = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("G Machines");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations machine"));

        jLabel1.setText("Référence :");

        jLabel2.setText("Marque : ");

        jLabel3.setText("Prix :");

        jLabel4.setText("Salle ");

        prixTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixTxtActionPerformed(evt);
            }
        });

        salleList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salleListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(marqueTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(referenceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(prixTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(salleList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(referenceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(marqueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(prixTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(salleList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        ajouterTxt.setText("Ajouter");
        ajouterTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterTxtActionPerformed(evt);
            }
        });

        modifierTxt.setText("Modifer");
        modifierTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierTxtActionPerformed(evt);
            }
        });

        supprimerTxt.setText("Supprimer");
        supprimerTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supprimerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifierTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ajouterTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(ajouterTxt)
                .addGap(28, 28, 28)
                .addComponent(modifierTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supprimerTxt)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des machines"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Filtrer par Salle ");

        filtreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtreTxtActionPerformed(evt);
            }
        });

        CheckTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckTxtActionPerformed(evt);
            }
        });

        applyTxt.setText("apply");

        listMachine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Référence", "Marque", "Prix", "Salle"
            }
        ));
        jScrollPane4.setViewportView(listMachine);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(filtreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(CheckTxt)
                        .addGap(18, 18, 18)
                        .addComponent(applyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CheckTxt)
                                .addComponent(applyTxt))
                            .addComponent(filtreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckTxtActionPerformed
          load1();        // TODO add your handling code here:
    }//GEN-LAST:event_CheckTxtActionPerformed

    private void filtreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtreTxtActionPerformed

    private void ajouterTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterTxtActionPerformed
 Salle salle = (Salle) salleList.getSelectedItem();
        double prix = Double.parseDouble(prixTxt.getText());                               
    try {
        Machine nouvelleMachine = new Machine(referenceTxt.getText(), marqueTxt.getText(), prix, salle);
        boolean enregistrementReussi = dao.create(nouvelleMachine);
        
        if (enregistrementReussi) {
            JOptionPane.showMessageDialog(this, "La machine a été ajoutée avec succès.");
            
            
            load();
        } else {
            JOptionPane.showMessageDialog(this, "Échec de l'enregistrement de la machine.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        
        JOptionPane.showMessageDialog(this, "Le prix saisi n'est pas un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
    } catch (RemoteException ex) {
        Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Une erreur s'est produite lors de l'enregistrement de la machine.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_ajouterTxtActionPerformed

    private void modifierTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierTxtActionPerformed
      try {
    int selectedRow = listMachine.getSelectedRow();
    int machineId = (int) listMachine.getValueAt(selectedRow, 0);
    Machine selectedMachine = dao.findById(machineId);
    

    String newRef = referenceTxt.getText();
    String newMarque = marqueTxt.getText();
    double newPrix = Double.parseDouble(prixTxt.getText()); 
    Salle newSalle = (Salle) salleList.getSelectedItem();

    selectedMachine.setRef(newRef);
    selectedMachine.setMarque(newMarque);
    selectedMachine.setPrix(newPrix);
    selectedMachine.setSalle(newSalle);

    boolean updated = dao.update(selectedMachine);

    if (updated) {
        JOptionPane.showMessageDialog(this, "Client mis à jour avec succès.");
        load();
    } else {
        JOptionPane.showMessageDialog(this, "La mise à jour du client a échoué.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Une erreur s'est produite : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
}
        
                           // TODO add your handling code here:
    }//GEN-LAST:event_modifierTxtActionPerformed

    private void prixTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixTxtActionPerformed

    private void supprimerTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerTxtActionPerformed
try {
             int selectedRow = listMachine.getSelectedRow();
             int machineId = (int) listMachine.getValueAt(selectedRow, 0);
             Machine selectedMachine = dao.findById(machineId);
             int reponse = JOptionPane.showConfirmDialog(this, " Vous Voulez supprimer cette machine ?");
             if(reponse == 0){
                 try {
                     if(dao.delete(dao.findById(machineId)))
                         JOptionPane.showMessageDialog(this, "Supprimé");
                 } catch (RemoteException ex) {
                     Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 load();
             }} catch (RemoteException ex) {
             Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
         }        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerTxtActionPerformed

    private void salleListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salleListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salleListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckTxt;
    private javax.swing.JButton ajouterTxt;
    private javax.swing.JLabel applyTxt;
    private javax.swing.JComboBox filtreTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable listMachine;
    private javax.swing.JTextField marqueTxt;
    private javax.swing.JButton modifierTxt;
    private javax.swing.JTextField prixTxt;
    private javax.swing.JTextField referenceTxt;
    private javax.swing.JComboBox salleList;
    private javax.swing.JButton supprimerTxt;
    // End of variables declaration//GEN-END:variables
}
