package br.edu.qi.bo;

import br.edu.qi.dao.ClienteDao;
import br.edu.qi.model.Cliente;
import br.edu.qi.model.Venda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementação de negócios de {@link Cliente}.
 *
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 15:47
 */
public class ClienteBo implements IBo<Cliente> {

    private ClienteDao dao;

    public ClienteBo() {
        this.dao = new ClienteDao();
    }

    @Override
    public void save(Cliente obj) throws Exception {
        try {
            obj.setVendas(new HashSet<>());
            this.dao.save(obj);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public void update(Cliente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Cliente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        try {
            return this.dao.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public Cliente find(Cliente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
