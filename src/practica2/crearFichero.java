package practica2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Adrian
 */
public class crearFichero extends javax.swing.JFrame {

    /**
     * Creates new form crearFichero
     */
    String estados,incial,finales,transiciones="",transicionesλ="";
    boolean tipo; //Falso si es AFD, true si es AFND
    public crearFichero(boolean AF) {
        initComponents();
        tipo=AF;
        if(!tipo){
            jTransλ.setVisible(false);
            jE1λ.setVisible(false);
            jE2λ.setVisible(false);
            tE1λ.setVisible(false);
            tE2λ.setVisible(false);
            bAnadirTranλ.setVisible(false);
            setTitle("Crear fichero");
        }else{
            tsp.setText("AFND.tsp");
        }
        error.setVisible(false);
        errorTrans.setVisible(false);
        errorTransλ.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tArchivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tInicial = new javax.swing.JTextField();
        tFinales = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tE1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tE2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bAnadirTran = new javax.swing.JButton();
        bCrearFichero = new javax.swing.JButton();
        errorTrans = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tEstados = new javax.swing.JTextField();
        tsp = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTransλ = new javax.swing.JLabel();
        tE1λ = new javax.swing.JTextField();
        tE2λ = new javax.swing.JTextField();
        jE1λ = new javax.swing.JLabel();
        jE2λ = new javax.swing.JLabel();
        errorTransλ = new javax.swing.JLabel();
        bVolver = new javax.swing.JButton();
        bAnadirTranλ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Inicial:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Estados:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Transiciones:");

        tArchivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Separar por comas (Ej: q0,q1,q2)");

        tInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tFinales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Separar por comas (Ej: q1,q2)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Finales:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("E1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Código");

        tE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tE2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("E2");

        bAnadirTran.setText("Añadir Transición");
        bAnadirTran.setActionCommand("Añadir Trassición");
        bAnadirTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirTranActionPerformed(evt);
            }
        });

        bCrearFichero.setText("Crear Fichero");
        bCrearFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearFicheroActionPerformed(evt);
            }
        });

        errorTrans.setForeground(new java.awt.Color(255, 0, 0));
        errorTrans.setText("* Error: Alguno de los 3 campos está incompleto");

        error.setForeground(new java.awt.Color(255, 0, 0));
        error.setText("* Error: Algún campo está incompleto");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Nombre del archivo:");

        tEstados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tsp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tsp.setText("AFD.tsp");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("(Se guardará en la carpeta de la práctica)");

        jTransλ.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTransλ.setText("Transicionesλ:");

        jE1λ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jE1λ.setText("E1");

        jE2λ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jE2λ.setText("E2");

        errorTransλ.setForeground(new java.awt.Color(255, 0, 0));
        errorTransλ.setText("* Error: Alguno de los 3 campos está incompleto");

        bVolver.setText("Volver");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        bAnadirTranλ.setText("Añadir Transiciónλ");
        bAnadirTranλ.setActionCommand("Añadir Trassición");
        bAnadirTranλ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirTranλActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tFinales, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(tInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(error)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bCrearFichero))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel7)
                                    .addGap(43, 43, 43)
                                    .addComponent(jLabel8)
                                    .addGap(46, 46, 46)
                                    .addComponent(jLabel9))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errorTrans)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tE1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(47, 47, 47)
                                            .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(52, 52, 52)
                                            .addComponent(tE2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(bAnadirTran)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tsp))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(errorTransλ))
                    .addComponent(bVolver)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jE1λ)
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTransλ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tE1λ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jE2λ, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tE2λ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bAnadirTranλ)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tsp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFinales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAnadirTran, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorTrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jE1λ)
                    .addComponent(jE2λ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTransλ)
                    .addComponent(tE2λ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tE1λ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAnadirTranλ, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorTransλ)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCrearFichero)
                    .addComponent(error)
                    .addComponent(bVolver))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnadirTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirTranActionPerformed
       if(tE1.getText().equals("") || tCodigo.getText().equals("") || tE2.getText().equals(""))
           errorTrans.setVisible(true);
       else{
           transiciones+=tE1.getText()+" '"+tCodigo.getText()+"' "+tE2.getText()+"\n";
           errorTrans.setVisible(false);
           tE1.setText("");
           tE2.setText("");
           tCodigo.setText("");
       }
    }//GEN-LAST:event_bAnadirTranActionPerformed

    private void bCrearFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearFicheroActionPerformed
        if(!tipo){
            if(tArchivo.getText().equals("") || tEstados.getText().equals("") ||tInicial.getText().equals("") 
                    ||tFinales.getText().equals("") || transiciones.equals(""))
                error.setVisible(true);
            else{
                BufferedWriter escribir;
                try{
                escribir = new BufferedWriter(new FileWriter(tArchivo.getText()+"AFD.tsp"));
                String [] e=tEstados.getText().trim().split(",");
                escribir.write("ESTADOS: ");
                for (int i = 0; i < e.length; i++) {
                    escribir.write(e[i]+" ");
                }
                escribir.write("\nINICIAL: "+tInicial.getText().trim());
                e=tFinales.getText().trim().split(",");
                escribir.write("\nFINALES: ");
                for (int i = 0; i < e.length; i++) {
                    escribir.write(e[i]+" ");
                }
                escribir.write("\nTRANSICIONES: \n");
                escribir.write(transiciones); 
                escribir.write("FIN");
                escribir.close();
                this.dispose();
                }catch(IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }   
        }else{
            if(tArchivo.getText().equals("") || tEstados.getText().equals("") ||tInicial.getText().equals("") 
                    ||tFinales.getText().equals("") || transiciones.equals("") || transicionesλ.equals(""))
                error.setVisible(true);
            else{
                BufferedWriter escribir;
                try{
                escribir = new BufferedWriter(new FileWriter(tArchivo.getText()+tsp.getText()));
                String [] e=tEstados.getText().trim().split(",");
                escribir.write("ESTADOS: ");
                for (int i = 0; i < e.length; i++) {
                    escribir.write(e[i]+" ");
                }
                escribir.write("\nINICIAL: "+tInicial.getText().trim());
                e=tFinales.getText().trim().split(",");
                escribir.write("\nFINALES: ");
                for (int i = 0; i < e.length; i++) {
                    escribir.write(e[i]+" ");
                }
                escribir.write("\nTRANSICIONES: \n");
                escribir.write(transiciones);
                escribir.write("TRANSICIONESλ: \n");
                escribir.write(transicionesλ);
                escribir.write("FIN");
                escribir.close();
                this.dispose();
                }catch(IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
            
    }//GEN-LAST:event_bCrearFicheroActionPerformed

    private void tE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tE2ActionPerformed
        bAnadirTranActionPerformed(evt);
    }//GEN-LAST:event_tE2ActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_bVolverActionPerformed

    private void bAnadirTranλActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirTranλActionPerformed
        if(tE1λ.getText().equals("") || tE2λ.getText().equals(""))
           errorTransλ.setVisible(true);
       else{
           transicionesλ+=tE1λ.getText()+" "+tE2λ.getText()+"\n";
           errorTransλ.setVisible(false);
           tE1λ.setText("");
           tE2λ.setText("");
       }
    }//GEN-LAST:event_bAnadirTranλActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnadirTran;
    private javax.swing.JButton bAnadirTranλ;
    private javax.swing.JButton bCrearFichero;
    private javax.swing.JButton bVolver;
    private javax.swing.JLabel error;
    private javax.swing.JLabel errorTrans;
    private javax.swing.JLabel errorTransλ;
    private javax.swing.JLabel jE1λ;
    private javax.swing.JLabel jE2λ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jTransλ;
    private javax.swing.JTextField tArchivo;
    private javax.swing.JTextField tCodigo;
    private javax.swing.JTextField tE1;
    private javax.swing.JTextField tE1λ;
    private javax.swing.JTextField tE2;
    private javax.swing.JTextField tE2λ;
    private javax.swing.JTextField tEstados;
    private javax.swing.JTextField tFinales;
    private javax.swing.JTextField tInicial;
    private javax.swing.JLabel tsp;
    // End of variables declaration//GEN-END:variables
}