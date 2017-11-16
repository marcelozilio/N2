package br.edu.qi.dao;

import br.edu.qi.model.Venda;
import java.io.Serializable;

/**
 * Dao responsável pela manipulção da entidade {@link Venda}.
 *
 * @author Marcelo Zilio Correa
 * @since 14/11/2017 - 16:58
 */
public class VendaDao extends GenericDao<Venda, Integer> {

    public VendaDao(Venda entity) {
        super(entity);
    }

}
