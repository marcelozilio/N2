package br.edu.qi.bo;

import br.edu.qi.dao.ProprietarioDao;
import br.edu.qi.model.Proprietario;
import java.util.List;

/**
 * Implementaçoã de negócios de {@link Proprietario}.
 *
 * @author Marcelo Zilio Correa
 * @since 24/11/2017 - 00:43
 */
public class ProprietarioBo implements IBo<Proprietario> {

    private ProprietarioDao dao;

    public ProprietarioBo() {
        this.dao = new ProprietarioDao();
    }

    @Override
    public void save(Proprietario obj) throws Exception {
        try {
            this.dao.save(obj);
        } catch (Exception e) {
            throw new Exception("Não foi possível salvar o proprietário.");
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public void update(Proprietario obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Proprietario obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proprietario> findAll() throws Exception {
        try {
            return this.dao.findAll();
        } catch (Exception e) {
            throw new Exception("Não foi possível listar os proprietários.");
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public Proprietario find(Proprietario obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
