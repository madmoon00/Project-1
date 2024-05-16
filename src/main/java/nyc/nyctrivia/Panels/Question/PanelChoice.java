package nyc.nyctrivia.Panels.Question;

import java.awt.Color;
import javax.swing.border.LineBorder;
import nyc.nyctrivia.NYCTrivia;

public class PanelChoice extends javax.swing.JPanel {
    private String userAnswer;
    private Color defaultColor; 
    
    public PanelChoice() {
        initComponents();
        defaultColor = lblChoice.getBackground();
    }
    
    public void setChoice(String choice) {
        userAnswer = choice;
        lblChoice.setText("<html>" + choice +"</html>");
    }
    
    public void setChoicesEnabled(boolean state) {
        lblChoice.setEnabled(state);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChoice = new javax.swing.JLabel();

        lblChoice.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        lblChoice.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblChoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChoiceMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblChoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChoiceMouseEntered
        lblChoice.setBorder(new LineBorder(Color.BLACK));
    }//GEN-LAST:event_lblChoiceMouseEntered

    private void lblChoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChoiceMouseExited
        lblChoice.setBorder(null);
    }//GEN-LAST:event_lblChoiceMouseExited

    private void lblChoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChoiceMouseClicked
        if (lblChoice.isEnabled()){
            NYCTrivia.commitAnswer(userAnswer);
        }
    }//GEN-LAST:event_lblChoiceMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblChoice;
    // End of variables declaration//GEN-END:variables
}
