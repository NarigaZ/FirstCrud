/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author D4rks
 */
public class FuncionarioDao {
    
    public void Create(Funcionario f){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO funcionarios (nome,datanasc,cpf)VALUES(?,?,?)");
            stmt.setString(1, f.getPessoa().getNome());
            stmt.setDate(2, new java.sql.Date(f.getPessoa().getDatanasc().getTime()));
            stmt.setString(3, f.getPessoa().getCpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public List<Funcionario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario func = new Funcionario(rs.getInt("id") , rs.getString("nome") , rs.getString("sexo") , rs.getDate("datanasc") ,rs.getString("cpf") , rs.getInt("Id_dep") );
                funcionarios.add(func);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura de dados"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }

}
