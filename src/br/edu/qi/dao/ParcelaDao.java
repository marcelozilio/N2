package br.edu.qi.dao;

import br.edu.qi.model.Parcela;
import java.io.Serializable;

/**
 * Dao responsável pela manipulação da entidade {@link Parcela}.
 * 
 * @author Marcelo Zilio Correa
 * @since 14/11/2017 - 17:00
 */
public class ParcelaDao extends GenericDao<Parcela, Integer>{
    
    public ParcelaDao() {
        super(new Parcela());
    }
    
}
