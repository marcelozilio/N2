/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.ParcelaDao;
import br.edu.qi.model.Parcela;
import java.util.List;

/**
 * Implementação de negócios de {@link Parcela}
 *
 * @author Marcelo Zilio Correa
 * @since 25/11/2017 - 22:30
 */
public class ParcelaBo implements IBo<Parcela> {

    private Boolean multa;

    private ParcelaDao dao;

    public ParcelaBo() {
        this.dao = new ParcelaDao();
    }

    @Override
    public void save(Parcela obj) throws Exception {
        try {
            this.dao.save(obj);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar parcela." + e.getMessage());
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public void update(Parcela obj) throws Exception {
        try {
            this.dao.update(obj);
        } catch (Exception e) {
            throw new Exception("Erro ao tentar alterar a parcela.");
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public void delete(Parcela obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Parcela> findAll() throws Exception {
        try {
            return this.dao.findAll();
        } catch (Exception e) {
            throw new Exception("Erro ao tentar listar as parcelas.");
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public Parcela find(Parcela obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean getMulta() {
        return multa;
    }

    public void setMulta(Boolean multa) {
        this.multa = multa;
    }

}
