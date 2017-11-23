package br.edu.qi.dao;

import br.edu.qi.model.Proprietario;
import java.io.Serializable;

/**
 * Dao responsável pela manipulação da entidade {@link Proprietario}.
 *
 * @author Marcelo Zilio Correa
 * @since 14/11/2017 - 13:19
 */
public class ProprietarioDao extends GenericDao<Proprietario, Integer> {

    public ProprietarioDao() {
        super(new Proprietario());
    }
}
