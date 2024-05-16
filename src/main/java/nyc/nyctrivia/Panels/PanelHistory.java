
package nyc.nyctrivia.Panels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import nyc.nyctrivia.NYCTrivia;

public class PanelHistory extends javax.swing.JPanel {

    public PanelHistory() {
        initComponents();
    }
    
    
    public void setHistory(ResultSet history) {
        try {
            // Get the table model from the existing JTable
            DefaultTableModel modelHistory = (DefaultTableModel) tblHistory.getModel();

            int counter = 1;
            // Clear existing rows in the table
            modelHistory.setRowCount(0);
            
            // Populate the table with data from the ResultSet
            while (history.next()) {
                // Format date as dd/MM/yyyy
                String datetime = history.getString("date");
                LocalDateTime localDateTime = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String formattedDate = localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String formattedTime = localDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
                
                Object[] row = {
                    counter,
                    formattedDate,
                    formattedTime,
                    history.getInt("score")
                };
                modelHistory.addRow(row);
                counter++;
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Failed to populate table.", "Error", JOptionPane.ERROR_MESSAGE);
            NYCTrivia.goHome();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        tblHistory.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Date", "Time", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHistory);
        if (tblHistory.getColumnModel().getColumnCount() > 0) {
            tblHistory.getColumnModel().getColumn(0).setMinWidth(30);
            tblHistory.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblHistory.getColumnModel().getColumn(0).setMaxWidth(30);
            tblHistory.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblHistory.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblHistory.getColumnModel().getColumn(3).setMinWidth(50);
            tblHistory.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblHistory.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        btnBack.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        NYCTrivia.goHome();
    }//GEN-LAST:event_btnBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistory;
    // End of variables declaration//GEN-END:variables
}
