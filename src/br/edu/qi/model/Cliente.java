package br.edu.qi.model;
// Generated 10/11/2017 19:50:22 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidade referente a tabela cliente do banco de dados.
 * 
 * @author Marcelo Zilio Correa
 * @since 10/11/2017 19:50:22
 */
@Entity
@Table(name = "cliente", catalog = "n2")
public class Cliente implements java.io.Serializable {

    private Integer idCliente;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    private Set<Venda> vendas = new HashSet<Venda>(0);

    public Cliente() {
    }

    public Cliente(String nome, String endereco, String cidade, String estado, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(String nome, String endereco, String cidade, String estado, String telefone, String email, Set<Venda> vendas) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
        this.vendas = vendas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idCliente", unique = true, nullable = false)
    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    @Column(name = "nome", nullable = false, length = 60)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "endereco", nullable = false, length = 150)
    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Column(name = "cidade", nullable = false, length = 60)
    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column(name = "estado", nullable = false, length = 2)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "telefone", nullable = false, length = 14)
    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "email", nullable = false, length = 40)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public Set<Venda> getVendas() {
        return this.vendas;
    }

    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }

}
