/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.bean.Departamento;
import Model.bean.Funcionario;
import Model.dao.FuncionarioDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author D4rks
 */
public class TelaPrincipal extends javax.swing.JFrame {
    ArrayList<Funcionario> ListaFunc;
    ArrayList<Departamento> ListaDep;
    String modoDep = "Navegar";
    String modoFunc = "Navegar";
    
    public void LoadTableFunc (){
        Object ColunasFunc[] = {"ID", "Nome", "CPF", "Data Nascimento"};
        DefaultTableModel modeloFunc = new DefaultTableModel(ColunasFunc,0);
        for(int i=0 ; i<ListaFunc.size() ; i++){
            Object linha [] = new Object [] { ListaFunc.get(i).getId(),
                                              ListaFunc.get(i).getPessoa().getNome(),
                                              ListaFunc.get(i).getPessoa().getCpf(),
                                              ListaFunc.get(i).getPessoa().getDatanasc()};
            modeloFunc.addRow(linha);
           
        }
        tbl_func.setModel(modeloFunc);
        tbl_func.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl_func.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbl_func.getColumnModel().getColumn(2).setPreferredWidth(70);
        tbl_func.getColumnModel().getColumn(3).setPreferredWidth(50);
 
    }
    
    public void LoadTableDep (){
        Object Colunas[] = {"ID", "Departamento"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas,0);
        
        for(int j=0 ; j<ListaDep.size() ; j++){
            Object linha [] = new Object [] { ListaDep.get(j).getId(),
                                              ListaDep.get(j).getNome()};                                        
            modelo.addRow(linha);
           
        }
        tbl_dep.setModel(modelo);
        tbl_dep.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl_dep.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        LoadCBFunc();
 
    }
    
    public void LoadCBFunc (){
        c_func_dep.removeAllItems();
        for(int i=0 ; i<ListaDep.size() ; i++){
            c_func_dep.addItem(ListaDep.get(i).getNome());
        }
    }
    
    public void ManipulaInterfaceFunc () {
        switch(modoFunc){
            case "Navegar":
                c_func_nome.setText("");
                c_func_cpf.setText("");
                c_func_datanasc.setText("");
                btn_func_salvar.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_cancelar.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                c_func_nome.setEnabled(false);
                c_func_cpf.setEnabled(false);
                c_func_datanasc.setEnabled(false);
                c_func_femin.setEnabled(false);
                c_func_masc.setEnabled(false);
                c_func_dep.setEnabled(false);
                break;
            case "Novo":
                c_func_nome.setText("");
                c_func_cpf.setText("");
                c_func_datanasc.setText("");
                btn_func_salvar.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_cancelar.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                c_func_nome.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_datanasc.setEnabled(true);
                c_func_femin.setEnabled(true);
                c_func_masc.setEnabled(true);
                c_func_dep.setEnabled(true);
                break;
            case "Editar":
                btn_func_salvar.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_cancelar.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                c_func_nome.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_datanasc.setEnabled(true);
                c_func_femin.setEnabled(true);
                c_func_masc.setEnabled(true);
                c_func_dep.setEnabled(true);
                break;
            case "Excluir":
                c_func_nome.setText("");
                c_func_cpf.setText("");
                c_func_datanasc.setText("");
                btn_func_salvar.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_cancelar.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                c_func_nome.setEnabled(false);
                c_func_cpf.setEnabled(false);
                c_func_datanasc.setEnabled(false);
                c_func_femin.setEnabled(false);
                c_func_masc.setEnabled(false);
                c_func_dep.setEnabled(false);
                break;
            case "Selecao":
                btn_func_salvar.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_cancelar.setEnabled(false);
                btn_func_editar.setEnabled(true);
                btn_func_excluir.setEnabled(true);
                c_func_nome.setEnabled(false);
                c_func_cpf.setEnabled(false);
                c_func_datanasc.setEnabled(false);
                c_func_femin.setEnabled(false);
                c_func_masc.setEnabled(false);
                c_func_dep.setEnabled(true);
                break;
        }
    }
        
        public void ManipulaInterfaceDep(){
        switch(modoDep){
            case "Navegar":
                c_dep_id.setText("");
                c_dep_dep.setText("");
                btn_dep_salvar.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_cancelar.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                c_dep_id.setEnabled(false);
                c_dep_dep.setEnabled(false);
                break;
            case "Novo":
                c_dep_id.setText("");
                c_dep_dep.setText("");
                btn_dep_salvar.setEnabled(true);
                btn_dep_novo.setEnabled(false);
                btn_dep_cancelar.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                c_dep_id.setEnabled(true);
                c_dep_dep.setEnabled(true);
                break;
            case "Editar":
                btn_dep_salvar.setEnabled(true);
                btn_dep_novo.setEnabled(false);
                btn_dep_cancelar.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                c_dep_id.setEnabled(true);
                c_dep_dep.setEnabled(true);
                break;
            case "Excluir":
                c_dep_id.setText("");
                c_dep_dep.setText("");
                btn_dep_salvar.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_cancelar.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                c_dep_id.setEnabled(false);
                c_dep_dep.setEnabled(false);
                break;
            case "Selecao":
                btn_dep_salvar.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_cancelar.setEnabled(false);
                btn_dep_editar.setEnabled(true);
                btn_dep_excluir.setEnabled(true);
                c_dep_id.setEnabled(false);
                c_dep_dep.setEnabled(false);
                break;
        }
    }

    /**
     * Creates new form Main
     */
    public TelaPrincipal() {
        initComponents();
        ListaDep = new ArrayList();
        ListaFunc = new ArrayList();
        setLocationRelativeTo(null);
        ManipulaInterfaceFunc(); 
        ManipulaInterfaceDep(); 
        LoadTableDep();
        LoadTableFunc();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        btn_dep_excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dep = new javax.swing.JTable();
        btn_dep_salvar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        c_dep_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_dep_dep = new javax.swing.JTextField();
        btn_dep_cancelar = new javax.swing.JButton();
        btn_dep_novo = new javax.swing.JButton();
        btn_dep_editar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_func = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_func_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        c_func_masc = new javax.swing.JRadioButton();
        c_func_femin = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c_func_dep = new javax.swing.JComboBox();
        c_func_cpf = new javax.swing.JFormattedTextField();
        c_func_datanasc = new javax.swing.JFormattedTextField();
        btn_func_salvar = new javax.swing.JButton();
        btn_func_cancelar = new javax.swing.JButton();
        btn_func_novo = new javax.swing.JButton();
        btn_func_editar = new javax.swing.JButton();
        btn_func_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_dep_excluir.setText("Excluir");
        btn_dep_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_excluirActionPerformed(evt);
            }
        });

        tbl_dep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_depMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_dep);
        if (tbl_dep.getColumnModel().getColumnCount() > 0) {
            tbl_dep.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_dep.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        btn_dep_salvar.setText("Salvar");
        btn_dep_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_salvarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionário"));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID:");

        c_dep_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_dep_idActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Departamento:");

        c_dep_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_dep_depActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(c_dep_id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(c_dep_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_dep_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_dep_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        btn_dep_cancelar.setText("Cancelar");
        btn_dep_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_cancelarActionPerformed(evt);
            }
        });

        btn_dep_novo.setText("Novo");
        btn_dep_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_novoActionPerformed(evt);
            }
        });

        btn_dep_editar.setText("Editar");
        btn_dep_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_dep_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btn_dep_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btn_dep_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btn_dep_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_dep_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dep_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dep_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_dep_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dep_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Departamentos", jPanel5);

        tbl_func.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Data Nascimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        tbl_func.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_funcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_func);
        if (tbl_func.getColumnModel().getColumnCount() > 0) {
            tbl_func.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_func.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_func.getColumnModel().getColumn(2).setPreferredWidth(70);
            tbl_func.getColumnModel().getColumn(2).setHeaderValue("CPF");
            tbl_func.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbl_func.getColumnModel().getColumn(3).setHeaderValue("Data Nascimento");
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionário"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome:");

        c_func_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_func_nomeActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data de Nascimento:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sexo:");

        c_func_masc.setText("Masculino");
        c_func_masc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_func_mascActionPerformed(evt);
            }
        });

        c_func_femin.setText("Feminino");

        jLabel5.setText("CPF:");

        jLabel7.setText("Departamento:");

        c_func_dep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            c_func_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            c_func_datanasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_func_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_func_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(c_func_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_func_femin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_func_masc))
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c_func_datanasc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_func_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_func_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(c_func_masc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_func_femin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btn_func_salvar.setText("Salvar");
        btn_func_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_salvarActionPerformed(evt);
            }
        });

        btn_func_cancelar.setText("Cancelar");
        btn_func_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_cancelarActionPerformed(evt);
            }
        });

        btn_func_novo.setText("Novo");
        btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_novoActionPerformed(evt);
            }
        });

        btn_func_editar.setText("Editar");
        btn_func_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_editarActionPerformed(evt);
            }
        });

        btn_func_excluir.setText("Excluir");
        btn_func_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btn_func_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_func_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_func_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btn_func_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btn_func_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_func_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_func_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_func_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_func_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Funcionários", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_func_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_func_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_func_nomeActionPerformed

    private void c_func_mascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_func_mascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_func_mascActionPerformed

    private void btn_func_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_cancelarActionPerformed
        // TODO add your handling code here:
        modoFunc = "Navegar";
        ManipulaInterfaceFunc(); 
    }//GEN-LAST:event_btn_func_cancelarActionPerformed

    private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
        modoFunc = "Novo";
        ManipulaInterfaceFunc(); 
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_func_novoActionPerformed

    private void btn_func_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_salvarActionPerformed
            int indexcb = c_func_dep.getSelectedIndex();
            if (modoFunc.equals("Novo")) {
            Funcionario d = new Funcionario(ListaDep.size()+1000 , c_func_nome.getText() , c_func_cpf.getText() , c_func_datanasc.getText() , "Masculino" );
            FuncionarioDao dao = new FuncionarioDao();
            d.setDepartamento(ListaDep.get(indexcb));
            dao.Create(d);
            ListaFunc.add(d);
            }else if (modoFunc.equals("Editar")) {
                int index = tbl_func.getSelectedRow();
                ListaFunc.get(index).getPessoa().setNome(c_func_nome.getText());
                ListaFunc.get(index).getPessoa().setDatanasc(c_func_datanasc.getText());
                ListaFunc.get(index).getPessoa().setCpf(c_func_cpf.getText());
                ListaFunc.get(index).setDepartamento(ListaDep.get(indexcb));
            }
            LoadTableFunc();
            modoFunc = "Navegar";
            ManipulaInterfaceFunc(); 
    }//GEN-LAST:event_btn_func_salvarActionPerformed

    private void btn_func_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_excluirActionPerformed
        // TODO add your handling code here:
        int index = tbl_func.getSelectedRow();
        if (index>=0 && index<ListaFunc.size()) {
            Funcionario d = ListaFunc.get(index);
            ListaFunc.remove(d);
        }
        LoadTableFunc();
        modoFunc = "Navegar";
        ManipulaInterfaceFunc(); 
    }//GEN-LAST:event_btn_func_excluirActionPerformed

    private void btn_func_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editarActionPerformed
        // TODO add your handling code here:
        modoFunc = "Editar";
        ManipulaInterfaceFunc(); 
    }//GEN-LAST:event_btn_func_editarActionPerformed

    private void tbl_funcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_funcMouseClicked
        // TODO add your handling code here:
        int index = tbl_func.getSelectedRow();
        if (index>=0 && index<ListaFunc.size()) {
            Funcionario d = ListaFunc.get(index);
            Object t = d.getDepartamento();
            int indexcb = ListaDep.indexOf(t);
            c_func_nome.setText(d.getPessoa().getNome());
            c_func_cpf.setText(String.valueOf(d.getPessoa().getCpf()));
            c_func_datanasc.setText(d.getPessoa().getDatanasc());
            c_func_dep.setSelectedIndex(indexcb);
            modoFunc = "Selecao";
            ManipulaInterfaceFunc();         
        }
    }//GEN-LAST:event_tbl_funcMouseClicked

    private void btn_dep_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_excluirActionPerformed
        // TODO add your handling code here:
        int index = tbl_dep.getSelectedRow();
        if (index>=0 && index<ListaDep.size()) {
            Departamento d = ListaDep.get(index);
            ListaDep.remove(d);
        }
        LoadTableDep();
        modoDep = "Navegar";
        ManipulaInterfaceDep(); 
    }//GEN-LAST:event_btn_dep_excluirActionPerformed

    private void tbl_depMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_depMouseClicked
        // TODO add your handling code here:
        int index = tbl_dep.getSelectedRow();
        if (index>=0 && index<ListaDep.size()) {
            Departamento d = ListaDep.get(index);
            c_dep_id.setText(String.valueOf(d.getId()));
            c_dep_dep.setText(d.getNome());
            modoDep = "Selecao";
            ManipulaInterfaceDep();         
        }
    }//GEN-LAST:event_tbl_depMouseClicked

    private void btn_dep_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_salvarActionPerformed
        // TODO add your handling code here:
            int id = Integer.parseInt(c_dep_id.getText());
            if (modoDep.equals("Novo")) {
                Departamento d = new Departamento(id,c_dep_dep.getText());
                ListaDep.add(d);
            }else if (modoDep.equals("Editar")) {
                int index = tbl_dep.getSelectedRow();
                ListaDep.get(index).setId(id);
                ListaDep.get(index).setNome(c_dep_dep.getText());
            }
            LoadTableDep();
            modoDep = "Navegar";
            ManipulaInterfaceDep();                                
    }//GEN-LAST:event_btn_dep_salvarActionPerformed

    private void c_dep_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dep_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_dep_idActionPerformed

    private void c_dep_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dep_depActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_dep_depActionPerformed

    private void btn_dep_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_cancelarActionPerformed
        // TODO add your handling code here:
        modoDep = "Navegar";
        ManipulaInterfaceDep(); 
    }//GEN-LAST:event_btn_dep_cancelarActionPerformed

    private void btn_dep_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_novoActionPerformed
        // TODO add your handling code here:
        modoDep = "Novo";
        ManipulaInterfaceDep(); 
    }//GEN-LAST:event_btn_dep_novoActionPerformed

    private void btn_dep_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_editarActionPerformed
        // TODO add your handling code here:
        modoDep = "Editar";
        ManipulaInterfaceDep(); 
    }//GEN-LAST:event_btn_dep_editarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dep_cancelar;
    private javax.swing.JButton btn_dep_editar;
    private javax.swing.JButton btn_dep_excluir;
    private javax.swing.JButton btn_dep_novo;
    private javax.swing.JButton btn_dep_salvar;
    private javax.swing.JButton btn_func_cancelar;
    private javax.swing.JButton btn_func_editar;
    private javax.swing.JButton btn_func_excluir;
    private javax.swing.JButton btn_func_novo;
    private javax.swing.JButton btn_func_salvar;
    private javax.swing.JTextField c_dep_dep;
    private javax.swing.JTextField c_dep_id;
    private javax.swing.JFormattedTextField c_func_cpf;
    private javax.swing.JFormattedTextField c_func_datanasc;
    private javax.swing.JComboBox c_func_dep;
    private javax.swing.JRadioButton c_func_femin;
    private javax.swing.JRadioButton c_func_masc;
    private javax.swing.JTextField c_func_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_dep;
    private javax.swing.JTable tbl_func;
    // End of variables declaration//GEN-END:variables
}
