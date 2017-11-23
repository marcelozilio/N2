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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 94aa368... Criação de Bo e implementação de Client.
 *
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 15:47
 */
public class ClienteBo implements IBo<Cliente> {
<<<<<<< HEAD
=======
 * 
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 15:47
 */
public class ClienteBo implements IBo<Cliente>{
>>>>>>> 0c66cba8669fa8e941dedbff56a0adec8a692f01
=======
>>>>>>> 94aa368... Criação de Bo e implementação de Client.

    private ClienteDao dao;

    public ClienteBo() {
        this.dao = new ClienteDao();
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 94aa368... Criação de Bo e implementação de Client.

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

<<<<<<< HEAD
=======
    
    @Override
    public void save(Cliente obj) throws Exception {
        try {                        
            obj.setVendas(new HashSet<>());
            dao.save(obj);
            dao.closeSession();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
>>>>>>> 0c66cba8669fa8e941dedbff56a0adec8a692f01
=======
>>>>>>> 94aa368... Criação de Bo e implementação de Client.
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 94aa368... Criação de Bo e implementação de Client.
            return this.dao.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            this.dao.closeSession();
<<<<<<< HEAD
=======
            return dao.findAll();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
>>>>>>> 0c66cba8669fa8e941dedbff56a0adec8a692f01
=======
>>>>>>> 94aa368... Criação de Bo e implementação de Client.
        }
    }

    @Override
    public Cliente find(Cliente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
<<<<<<< HEAD
<<<<<<< HEAD
    }
=======
    }    
>>>>>>> 0c66cba8669fa8e941dedbff56a0adec8a692f01
=======
    }
>>>>>>> 94aa368... Criação de Bo e implementação de Client.
}
