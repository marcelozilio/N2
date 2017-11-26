package br.edu.qi.model;
// Generated 10/11/2017 19:50:22 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    private ParcelaId id;
    private Venda venda;
    private Double valor;
    private Double multa;
    private Date dataParcela;
    private Date dataPgto;
    private int pago;    

    public Parcela() {
    }

    public Parcela(ParcelaId id, Venda venda) {
        this.id = id;
        this.venda = venda;
    }    
    
    public Parcela(Venda venda, Double valor, Double multa, Date dataParcela, int pago) {
        this.venda = venda;
        this.valor = valor;
        this.multa = multa;
        this.dataParcela = dataParcela;
        this.pago = pago;
    }

    public Parcela(ParcelaId idParcela, Venda venda, Double valor, Double multa, Date dataParcela, Date dataPgto, int pago) {
        this.id = idParcela;
        this.venda = venda;
        this.valor = valor;
        this.multa = multa;
        this.dataParcela = dataParcela;
        this.dataPgto = dataPgto;
        this.pago = pago;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "idVenda", column = @Column(name = "idVenda", nullable = false)),
        @AttributeOverride(name = "sqParcela", column = @Column(name = "sq_parcela", nullable = false))})
    public ParcelaId getId() {
        return this.id;
    }

    public void setId(ParcelaId idParcela) {
        this.id = idParcela;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenda", insertable = false, updatable = false)
    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Column(name = "valor", nullable = false, precision = 10, scale = 5)
    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Column(name = "multa", nullable = false, precision = 10, scale = 5)
    public Double getMulta() {
        return this.multa;
    }

    public void setMulta(Double multa) {
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
