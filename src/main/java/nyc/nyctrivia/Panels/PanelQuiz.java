package nyc.nyctrivia.Panels;

import java.awt.Color;
import javax.swing.JOptionPane;
import nyc.nyctrivia.Classes.Question;
import nyc.nyctrivia.Classes.Quiz;
import nyc.nyctrivia.NYCTrivia;

public class PanelQuiz extends javax.swing.JPanel {
    private static Quiz quiz;
    private static Question[] questions;
    private static int counter;
    private static int amount;
    private static int score;
    
    public PanelQuiz() {
        initComponents();
        btnNext.setEnabled(false);
    }
    
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
        this.questions = quiz.getQuestions();
        this.amount = quiz.amount;
        this.counter = 0;
        this.score = 0;

        showNextQuestion();
    }
    
    private void showNextQuestion() {
        if (counter <= amount - 1) {
            btnNext.setEnabled(false);
            lblResult.setText("");
            Question newQuestion = questions[counter];
            pnlQuestion.setQuestion(newQuestion);
            pnlQuestion.setChoicesEnabled(true);
        }
        else {
            System.out.println("score: " + score + "\namount: " + quiz.amount);
            NYCTrivia.showResults(score);
            return;
        }
        
        counter += 1;
    }
    
    public void commitAnswer(String userAnswer) {
        pnlQuestion.setChoicesEnabled(false);
        boolean isCorrect = questions[counter - 1].checkAnswer(userAnswer);
        
        if (isCorrect) {
            score += 10;
            lblResult.setText("Correct Answer!");
            lblResult.setForeground(Color.green);
        }
        else {
            lblResult.setText("Wrong Answer!");
            lblResult.setForeground(Color.red);
        }
        
        btnNext.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlQuestion = new nyc.nyctrivia.Panels.Question.PanelQuestion();
        lblResult = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        lblResult.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        lblResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnNext.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.setEnabled(false);
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        if (btnNext.isEnabled()) {
            showNextQuestion();
        }
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit the quiz?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            NYCTrivia.goHome();
        }
    }//GEN-LAST:event_btnExitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel lblResult;
    private javax.swing.JPanel pnlMain;
    private nyc.nyctrivia.Panels.Question.PanelQuestion pnlQuestion;
    // End of variables declaration//GEN-END:variables
}
