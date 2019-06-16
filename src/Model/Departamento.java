/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author D4rks
 */
public class Departamento {
    
        int id;
    String nome;

    public Departamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Funcionario> getListFunc() {
        return ListFunc;
    }

    public void setListFunc(ArrayList<Funcionario> ListFunc) {
        this.ListFunc = ListFunc;
    }
    ArrayList<Funcionario> ListFunc;    
}
