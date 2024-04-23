package solveQuiz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ClientFrame extends javax.swing.JFrame{

  private String serverAddress;
  private int serverPort;

  //Socket版    
  private Socket connectedSocket = null;
  private BufferedReader serverReader;
  private PrintWriter serverWriter;
  
  //表示部分のドキュメントを管理するクラス  
  private DefaultStyledDocument document_server;
  private DefaultStyledDocument document_system;

  public void connectServer(){

    try {
        // サーバーに接続
        this.serverAddress = this.jTextField1.getText();
        this.serverPort = Integer.parseInt(this.jTextField2.getText());
        this.connectedSocket = new Socket(this.serverAddress,this.serverPort);
        this.serverReader = new BufferedReader(new InputStreamReader(connectedSocket.getInputStream()));
        this.serverWriter = new PrintWriter(new OutputStreamWriter(connectedSocket.getOutputStream()));
    
        this.printMessage("サーバに接続しました。");
        joinQuiz(serverWriter,serverReader);
        
    } catch (IOException ex) {
        this.printMessage("サーバに接続できませんでした。");
        Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void joinQuiz(PrintWriter writer, BufferedReader reader) throws IOException {
      // クイズに参加するリクエストを送信
      writer.println("JOIN_QUIZ");

      // サーバーからの応答を受信
      String response = reader.readLine();
      System.out.println("Server response: " + response);

      // クイズの問題や選択肢を受信して表示
      response = reader.readLine();
      System.out.println("Quiz question: " + response);

      // ここでユーザーの回答などの処理を行う
      // ...

      // クイズの結果をサーバーに送信
      writer.println("ANSWER: ...");
  }

  /** GUI上に受信したメッセージを表示するメソッド
     * @param message */
    public void showRecivedMessage(String message){
      try {
          SimpleAttributeSet attribute = new SimpleAttributeSet();
          attribute.addAttribute(StyleConstants.Foreground, Color.BLACK);
          //ドキュメントにその属性情報つきの文字列を挿入
          document_server.insertString(document_server.getLength(), message+"\n", attribute);

      } catch (BadLocationException ex) {
      }
  }
  
  /** GUI上にシステムメッセージを表示するメソッド
   * @param message */
  public void printMessage(String message){
      System.out.println(message);
      try {
          SimpleAttributeSet attribute = new SimpleAttributeSet();
          attribute.addAttribute(StyleConstants.Foreground, Color.BLACK);
          //ドキュメントにその属性情報つきの文字列を挿入
          document_system.insertString(document_system.getLength(), message+"\n", attribute);
          this.jTextArea3.setCaretPosition(document_system.getLength());

      } catch (BadLocationException ex) {
      }
  }

  public ClientFrame() {
    initComponents();
    this.document_server = new DefaultStyledDocument();
    this.document_system = new DefaultStyledDocument();

    this.jTextArea3.setDocument(this.document_system);
  }

@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jTextField1 = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jTextField2 = new javax.swing.JTextField();
      jScrollPane1 = new javax.swing.JScrollPane();
      jButton1 = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      jTextArea2 = new javax.swing.JTextArea();
      jButton2 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();
      jLabel6 = new javax.swing.JLabel();
      jScrollPane3 = new javax.swing.JScrollPane();
      jTextArea3 = new javax.swing.JTextArea();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setText("2024 ソフトウェア工学 Minhaya");

      jTextField1.setText("localhost");

      jLabel2.setText("ServerIP");

      jLabel3.setText("Port");

      jTextField2.setText("80");

      jButton1.setText("Connect");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
          }
      });

      jLabel4.setText("Recived");

      jLabel5.setText("Send JSON Data");

      jTextArea2.setColumns(20);
      jTextArea2.setRows(5);
      jScrollPane2.setViewportView(jTextArea2);

      jButton2.setText("Send");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
          }
      });

      jButton3.setText("Make");
      jButton3.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
          }
      });

      jLabel6.setText("SystemMessage");

      jTextArea3.setColumns(20);
      jTextArea3.setRows(5);
      jScrollPane3.setViewportView(jTextArea3);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                      .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                          .addComponent(jLabel4)
                          .addGap(0, 327, Short.MAX_VALUE))
                      .addGroup(layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addComponent(jTextField1)
                              .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))))
                  .addComponent(jLabel5)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                      .addComponent(jButton1)
                      .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(jLabel6)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                      .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jButton3)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(jButton2))
                      .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addContainerGap(14, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addComponent(jLabel1)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel2))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel3)
                  .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(9, 9, 9)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel4)
                  .addComponent(jButton1))
              .addGap(4, 4, 4)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jLabel5)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jButton2)
                  .addComponent(jButton3))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jLabel6)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addContainerGap(15, Short.MAX_VALUE))
      );

      pack();
  }// </editor-fold>//GEN-END:initComponents

  /** サブウインドウからの変更要求 */
  public void setSendText(String message){
      this.jTextArea2.setText(message);
  }

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.connectServer();
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextArea jTextArea2;
  private javax.swing.JTextArea jTextArea3;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;

}
