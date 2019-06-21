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
import java.sql.SQLException;
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
            stmt = con.prepareStatement("INSERT INTO funcionarios (nome,cpf)VALUES(?,?)");
            stmt.setString(1, f.getPessoa().getNome());
            stmt.setString(2, f.getPessoa().getCpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }

}
