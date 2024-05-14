package nyc.nyctrivia.Panels.Question;

import java.awt.Color;
import java.util.ArrayList;
import nyc.nyctrivia.Classes.Question;
import nyc.nyctrivia.NYCTrivia;
import org.apache.commons.text.StringEscapeUtils;

public class PanelQuestion extends javax.swing.JPanel {
    private static Question question;
    private ArrayList<PanelChoice> choices;
    
    public PanelQuestion() {
        initComponents();
        
        choices = new ArrayList<>();
        choices.add(pnlChoice1);
        choices.add(pnlChoice2);
        choices.add(pnlChoice3);
        choices.add(pnlChoice4);

    }
    
    public void setQuestion(Question question) {
        this.question = question;
        txtQuestion.setText(StringEscapeUtils.unescapeHtml4(question.getQuestion()));
        initChoices();
    }

    private void initChoices() {
        String[] choices = question.getChoices();
        for (int i = 0; i < 4; i++) {
            if (i < choices.length) {
                this.choices.get(i).setChoice(choices[i]);
                this.choices.get(i).setVisible(true);
            }
            else {
                this.choices.get(i).setChoice("");
                this.choices.get(i).setVisible(false);
            }
        }
    }
    
    
    public void setChoicesEnabled(boolean state) {
        for (int i = 0; i < 4; i++) {
                this.choices.get(i).setChoicesEnabled(state);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuestion = new javax.swing.JTextArea();
        pnlChoices = new javax.swing.JPanel();
        pnlChoice1 = new nyc.nyctrivia.Panels.Question.PanelChoice();
        pnlChoice2 = new nyc.nyctrivia.Panels.Question.PanelChoice();
        pnlChoice3 = new nyc.nyctrivia.Panels.Question.PanelChoice();
        pnlChoice4 = new nyc.nyctrivia.Panels.Question.PanelChoice();

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Question");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Answers");

        txtQuestion.setEditable(false);
        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtQuestion.setLineWrap(true);
        txtQuestion.setRows(5);

        javax.swing.GroupLayout pnlChoicesLayout = new javax.swing.GroupLayout(pnlChoices);
        pnlChoices.setLayout(pnlChoicesLayout);
        pnlChoicesLayout.setHorizontalGroup(
            pnlChoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChoicesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChoicesLayout.createSequentialGroup()
                        .addComponent(pnlChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChoicesLayout.createSequentialGroup()
                        .addComponent(pnlChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlChoicesLayout.setVerticalGroup(
            pnlChoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChoicesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlChoices, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtQuestion))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlChoices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private nyc.nyctrivia.Panels.Question.PanelChoice pnlChoice1;
    private nyc.nyctrivia.Panels.Question.PanelChoice pnlChoice2;
    private nyc.nyctrivia.Panels.Question.PanelChoice pnlChoice3;
    private nyc.nyctrivia.Panels.Question.PanelChoice pnlChoice4;
    private javax.swing.JPanel pnlChoices;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables

    
}
