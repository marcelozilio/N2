package br.edu.qi.bo;

import br.edu.qi.dao.AutomovelDao;
import br.edu.qi.model.Automovel;
import java.util.List;

/**
 * Implementação de negócios de {@link Automovel}.
 * 
 * @author Marcelo Zilio Correa
 * @since 25/11/2017 - 15:05
 */
public class AutomovelBo  implements IBo<Automovel> {

    private AutomovelDao dao;

    public AutomovelBo() {
        this.dao = new AutomovelDao();
    }       
    
    @Override
    public void save(Automovel obj) throws Exception {
        try {            
            this.dao.save(obj);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar o Automovel.");
        } finally {
            this.dao.closeSession();            
        }
    }

    @Override
    public void update(Automovel obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Automovel obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Automovel> findAll() throws Exception {
        try {
            return this.dao.findAll();
        } catch (Exception e) {
            throw new Exception("Erro ao listar os Automoveis.");
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public Automovel find(Automovel obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }            
}
