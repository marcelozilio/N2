package br.edu.qi.model;
// Generated 10/11/2017 19:50:22 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade referente a tabela parcela do banco de dados.
 * 
 * @author Marcelo Zilio Correa
 * @since 10/11/2017 19:50:22
 */
@Entity
@Table(name = "parcela", catalog = "n2")
public class Parcela implements java.io.Serializable {

    private Integer idParcela;
    private Venda venda;
    private BigDecimal valor;
    private BigDecimal multa;
    private Date dataParcela;
    private Date dataPgto;
    private int pago;

    public Parcela() {
    }

    public Parcela(Venda venda, BigDecimal valor, BigDecimal multa, Date dataParcela, int pago) {
        this.venda = venda;
        this.valor = valor;
        this.multa = multa;
        this.dataParcela = dataParcela;
        this.pago = pago;
    }

    public Parcela(Venda venda, BigDecimal valor, BigDecimal multa, Date dataParcela, Date dataPgto, int pago) {
        this.venda = venda;
        this.valor = valor;
        this.multa = multa;
        this.dataParcela = dataParcela;
        this.dataPgto = dataPgto;
        this.pago = pago;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idParcela", unique = true, nullable = false)
    public Integer getIdParcela() {
        return this.idParcela;
    }

    public void setIdParcela(Integer idParcela) {
        this.idParcela = idParcela;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenda", nullable = false)
    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Column(name = "valor", nullable = false, precision = 10, scale = 5)
    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Column(name = "multa", nullable = false, precision = 10, scale = 5)
    public BigDecimal getMulta() {
        return this.multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataParcela", nullable = false, length = 10)
    public Date getDataParcela() {
        return this.dataParcela;
    }

    public void setDataParcela(Date dataParcela) {
        this.dataParcela = dataParcela;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataPgto", length = 10)
    public Date getDataPgto() {
        return this.dataPgto;
    }

    public void setDataPgto(Date dataPgto) {
        this.dataPgto = dataPgto;
    }

    @Column(name = "pago", nullable = false)
    public int getPago() {
        return this.pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

}
