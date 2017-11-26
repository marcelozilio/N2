package br.edu.qi.bo;

import br.edu.qi.dao.VendaDao;
import br.edu.qi.model.Parcela;
import br.edu.qi.model.ParcelaId;
import br.edu.qi.model.Venda;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementação de negócios de {@link Venda}.
 *
 * @author Marcelo Zilio Correa
 * @since 25/11/2017 - 20:06
 */
public class VendaBo implements IBo<Venda> {

    private VendaDao dao;

    public VendaBo() {
        this.dao = new VendaDao();
    }

    @Override
    public void save(Venda obj) throws Exception {
        try {
            this.dao.save(obj);
            gerarParcelas(obj);
        } catch (Exception e) {
            throw new Exception("Não foi possível realizar a venda.");
        } finally {
            this.dao.closeSession();
        }
    }

    private void gerarParcelas(Venda obj) {

        try {            
            int qtParcela = obj.getQtdParcelas();
            if (obj.getaVista() == 1) {                
                new ParcelaBo().save(new Parcela(new ParcelaId(obj.getIdVenda(), 1), null, obj.getValor(), null, new Date(), new Date(), 1));
            } else {
                for (int i = 1; i <= qtParcela; i++) {                    
                    new ParcelaBo().save(new Parcela(new ParcelaId(obj.getIdVenda(), i), null, obj.getValor() / qtParcela, null, new Date(), null, 0));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(VendaBo.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public void update(Venda obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Venda obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> findAll() throws Exception {
        try {
            return this.dao.findAll();
        } catch (Exception e) {
            throw new Exception("Não foi possível listar as vendas");
        } finally {
            this.dao.closeSession();
        }
    }

    @Override
    public Venda find(Venda obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
