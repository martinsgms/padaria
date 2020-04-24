package br.com.martins.padaria.model;

import java.util.Date;

public class Cliente {
    
    private Integer id;
    private String nome;
    private Date dataCadastro;
    
    public Cliente(String nome, Date dataCadastro) {
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
}
