package nyc.nyctrivia.Panels;

import java.util.List;
import nyc.nyctrivia.Api.OpenTriviaAPI;
import nyc.nyctrivia.Classes.Category;
import nyc.nyctrivia.NYCTrivia;

public class PanelCategory extends javax.swing.JPanel {
    private static List<Category> categories = null;
    public PanelCategory() {
        initComponents();
    }
    
    public  void getCategories() {
        if (categories == null){
            try {
                categories = OpenTriviaAPI.getCategories();

                // Clear existing items in the combo box
                cmbCategory.removeAllItems();
                cmbCategory.addItem("All");

                // Add categories to the combo box
                for (Category category : categories) {
                    cmbCategory.addItem(category.getName());
                }

                // Set "All" as the selected item
                cmbCategory.setSelectedIndex(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private int getCategoryIdByName(String categoryName) {
        if ("All".equals(categoryName)) {
            return -1; // Return -1 for "All"
        }

        // Find category ID by name
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category.getId();
            }
        }

        // If category name not found, return -1
        return -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCategory = new javax.swing.JComboBox<>();
        btnNewGame = new javax.swing.JButton();

        cmbCategory.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnNewGame.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnNewGame.setText("Start");
        btnNewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewGameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewGameMouseClicked
        int categoryId = getCategoryIdByName(cmbCategory.getSelectedItem().toString());
        
        NYCTrivia.NewGame(categoryId);
    }//GEN-LAST:event_btnNewGameMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewGame;
    private javax.swing.JComboBox<String> cmbCategory;
    // End of variables declaration//GEN-END:variables
}
