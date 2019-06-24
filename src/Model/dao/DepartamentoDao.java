/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.Departamento;
import Model.bean.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author D4rks
 */
public class DepartamentoDao {
    
    public void Create(Departamento d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO departamentos (ID_DEP,nome)VALUES(?,?)");
            stmt.setInt(1, d.getId());
            stmt.setString(2, d.getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public List<Departamento> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Departamento> departamentos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM departamentos");
            rs = stmt.executeQuery();
            while(rs.next()){
                Departamento dep = new Departamento(rs.getInt("ID_DEP") , rs.getString("nome"));
                departamentos.add(dep);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Leitura de dados"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return departamentos;
    }
    
}
