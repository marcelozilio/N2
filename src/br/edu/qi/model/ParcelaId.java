package br.edu.qi.model;
// Generated 13/06/2016 21:16:53 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ParcelaId generated by hbm2java
 */
@Embeddable
public class ParcelaId implements java.io.Serializable {

    private int idVenda;
    private int sqParcela;

    public ParcelaId() {
    }

    public ParcelaId(int idVenda, int sqParcela) {
        this.idVenda = idVenda;
        this.sqParcela = sqParcela;
    }

    @Column(name = "idVenda", nullable = false)
    public int getIdVenda() {
        return this.idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    @Column(name = "sq_parcela", nullable = false)
    public int getSqParcela() {
        return this.sqParcela;
    }

    public void setSqParcela(int sqParcela) {
        this.sqParcela = sqParcela;
    }
    
    @Override
    public String toString() {
        return String.valueOf(sqParcela);
    }

}