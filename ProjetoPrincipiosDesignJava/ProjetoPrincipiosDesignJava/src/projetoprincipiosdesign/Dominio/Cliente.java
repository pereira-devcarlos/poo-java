package projetoprincipiosdesign.Dominio;

import projetoprincipiosdesign.Enum.TipoCliente;

public class Cliente {
    private String nome;
    private Endereco endereco;
    private TipoCliente tipoCliente;

    public Cliente(String nome, Endereco endereco, TipoCliente tipoCliente) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
