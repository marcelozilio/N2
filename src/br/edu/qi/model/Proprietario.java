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
 * Entidade referente a tabela proprietario do banco de dados.
 * 
 * @author Marcelo Zilio Correa
 * @since 10/11/2017 19:50:22
 */
@Entity
@Table(name = "proprietario", catalog = "n2"
)
public class Proprietario implements java.io.Serializable {

    private Integer idProprietario;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    private Set<Automovel> automovels = new HashSet<Automovel>(0);

    public Proprietario() {
    }

    public Proprietario(String nome, String endereco, String cidade, String estado, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }

    public Proprietario(String nome, String endereco, String cidade, String estado, String telefone, String email, Set<Automovel> automovels) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
        this.automovels = automovels;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idProprietario", unique = true, nullable = false)
    public Integer getIdProprietario() {
        return this.idProprietario;
    }

    public void setIdProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietario")
    public Set<Automovel> getAutomovels() {
        return this.automovels;
    }

    public void setAutomovels(Set<Automovel> automovels) {
        this.automovels = automovels;
    }
}