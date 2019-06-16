/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author D4rks
 */
public class Funcionario {
    int id;
    Departamento departamento;
    Pessoa pessoa;

    public Funcionario(int id, String nome , String cpf , String data , String sexo) {
        this.pessoa = new Pessoa();
        this.id = id;
        this.pessoa.nome = nome;
        this.pessoa.cpf = cpf;
        this.pessoa.sexo = sexo;
        this.pessoa.datanasc = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
