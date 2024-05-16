/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package nyc.nyctrivia.Panels;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nyc.nyctrivia.NYCTrivia;

public class PanelStatistics extends javax.swing.JPanel {

    public PanelStatistics() {
        initComponents();
    }

    public void setTables(ResultSet bestPlayers, ResultSet mostActivePlayers) {
        try {
            // Get the table model from the existing JTable
            DefaultTableModel modelBestPlayers = (DefaultTableModel) tblBestPlayers.getModel();
            DefaultTableModel modelMostActivePlayers = (DefaultTableModel) tblMostActivePlayers.getModel();

            int counter = 1;
            // Clear existing rows in the table
            modelBestPlayers.setRowCount(0);
            
            // Populate the table with data from the ResultSet
            while (bestPlayers.next()) {
                Object[] row = {
                    counter,
                    bestPlayers.getString("username"),
                    bestPlayers.getDouble("averageScore")
                };
                modelBestPlayers.addRow(row);
                counter++;
            }
            
            counter = 1;
            modelMostActivePlayers.setRowCount(0);
            while (mostActivePlayers.next()) {
                Object[] row = {
                    counter,
                    mostActivePlayers.getString("username"),
                    mostActivePlayers.getInt("gamesPlayed")
                };
                modelMostActivePlayers.addRow(row);
                counter++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to populate table.", "Error", JOptionPane.ERROR_MESSAGE);
            NYCTrivia.goHome();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostActivePlayers = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBestPlayers = new javax.swing.JTable();
        lblStatisticsTab = new javax.swing.JLabel();

        btnBack.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        tblMostActivePlayers.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblMostActivePlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Username", "Games"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMostActivePlayers);
        if (tblMostActivePlayers.getColumnModel().getColumnCount() > 0) {
            tblMostActivePlayers.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblMostActivePlayers.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblMostActivePlayers.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jTabbedPane1.addTab("Most Active Players", jScrollPane1);

        tblBestPlayers.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblBestPlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Username", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblBestPlayers);
        if (tblBestPlayers.getColumnModel().getColumnCount() > 0) {
            tblBestPlayers.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblBestPlayers.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblBestPlayers.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jTabbedPane1.addTab("Best Players", jScrollPane2);

        lblStatisticsTab.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        lblStatisticsTab.setText("Top Players");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatisticsTab, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatisticsTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        NYCTrivia.goHome();
    }//GEN-LAST:event_btnBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblStatisticsTab;
    private javax.swing.JTable tblBestPlayers;
    private javax.swing.JTable tblMostActivePlayers;
    // End of variables declaration//GEN-END:variables
}
