package br.edu.qi.model;
// Generated 10/11/2017 19:50:22 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade referente a tabela venda do banco de dados.
 * 
 * @author Marcelo Zilio Correa
 * @since 10/11/2017 19:50:22
 */
@Entity
@Table(name = "venda", catalog = "n2")
public class Venda implements java.io.Serializable {

    private Integer idVenda;
    private Automovel automovel;
    private Cliente cliente;
    private Date dataVenda;
    private Double valor;
    private Integer qtdParcelas;
    private Integer aVista;
    private Set<Parcela> parcelas = new HashSet<Parcela>(0);

    public Venda() {
    }

    public Venda(Automovel automovel, Cliente cliente) {
        this.automovel = automovel;
        this.cliente = cliente;
    }        

    public Venda(Automovel automovel, Cliente cliente, Date dataVenda, Double valor) {
        this.automovel = automovel;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.valor = valor;
    }

    public Venda(Automovel automovel, Cliente cliente, Date dataVenda, Double valor, Set<Parcela> parcelas) {
        this.automovel = automovel;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.valor = valor;
        this.parcelas = parcelas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idVenda", unique = true, nullable = false)
    public Integer getIdVenda() {
        return this.idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAutomovel", nullable = false)
    public Automovel getAutomovel() {
        return this.automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", nullable = false)
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataVenda", nullable = false, length = 19)
    public Date getDataVenda() {
        return this.dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Column(name = "valor", nullable = false)
    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Column(name = "qtdParcelas")
    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    @Column(name = "aVista")
    public Integer getaVista() {
        return aVista;
    }

    public void setaVista(Integer aVista) {
        this.aVista = aVista;
    }        
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda")
    public Set<Parcela> getParcelas() {
        return this.parcelas;
    }

    public void setParcelas(Set<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public String toString() {
        return "Venda - " + idVenda + " - R$" + valor;
    }
}