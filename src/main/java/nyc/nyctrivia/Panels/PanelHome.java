package nyc.nyctrivia.Panels;

import javax.swing.JOptionPane;
import nyc.nyctrivia.NYCTrivia;

public class PanelHome extends javax.swing.JPanel {

    public PanelHome() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewGame = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();

        btnNewGame.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnNewGame.setText("+New Quiz");
        btnNewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewGameMouseClicked(evt);
            }
        });

        btnStatistics.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        btnStatistics.setText("Statistics");
        btnStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisticsMouseClicked(evt);
            }
        });

        btnQuit.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitMouseClicked(evt);
            }
        });

        btnHistory.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        btnHistory.setText("History");
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(btnStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewGameMouseClicked
        NYCTrivia.NewGame();
    }//GEN-LAST:event_btnNewGameMouseClicked

    private void btnQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Quit?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnQuitMouseClicked

    private void btnStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticsMouseClicked
        NYCTrivia.goStatistics();
    }//GEN-LAST:event_btnStatisticsMouseClicked

    private void btnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseClicked
        NYCTrivia.goHistory();
    }//GEN-LAST:event_btnHistoryMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnStatistics;
    // End of variables declaration//GEN-END:variables
}
