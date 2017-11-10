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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidade referente a tabela automovel do banco de dados.
 * 
 * @author Marcelo Zilio Correa
 * @since 10/11/2017 19:50:22
 */
@Entity
@Table(name = "automovel", catalog = "n2")
public class Automovel implements java.io.Serializable {

    private Integer idAutomovel;
    private Proprietario proprietario;
    private String ano;
    private String marca;
    private String modelo;
    private String cor;
    private String descricao;
    private char estado;
    private int tipo;
    private String acessorios;
    private char vendido;
    private Set<Venda> vendas = new HashSet<Venda>(0);

    public Automovel() {
    }

    public Automovel(Proprietario proprietario, String ano, String marca, String modelo, String cor, char estado, int tipo, char vendido) {
        this.proprietario = proprietario;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.estado = estado;
        this.tipo = tipo;
        this.vendido = vendido;
    }

    public Automovel(Proprietario proprietario, String ano, String marca, String modelo, String cor, String descricao, char estado, int tipo, String acessorios, char vendido, Set<Venda> vendas) {
        this.proprietario = proprietario;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.descricao = descricao;
        this.estado = estado;
        this.tipo = tipo;
        this.acessorios = acessorios;
        this.vendido = vendido;
        this.vendas = vendas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idAutomovel", unique = true, nullable = false)
    public Integer getIdAutomovel() {
        return this.idAutomovel;
    }

    public void setIdAutomovel(Integer idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProprietario", nullable = false)
    public Proprietario getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Column(name = "ano", nullable = false, length = 10)
    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Column(name = "marca", nullable = false, length = 60)
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(name = "modelo", nullable = false, length = 60)
    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(name = "cor", nullable = false, length = 40)
    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Column(name = "descricao", length = 500)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "estado", nullable = false, length = 1)
    public char getEstado() {
        return this.estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Column(name = "tipo", nullable = false)
    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Column(name = "acessorios", length = 150)
    public String getAcessorios() {
        return this.acessorios;
    }

    public void setAcessorios(String acessorios) {
        this.acessorios = acessorios;
    }

    @Column(name = "vendido", nullable = false, length = 1)
    public char getVendido() {
        return this.vendido;
    }

    public void setVendido(char vendido) {
        this.vendido = vendido;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "automovel")
    public Set<Venda> getVendas() {
        return this.vendas;
    }

    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }    
}
