package br.edu.qi.dao;

import br.edu.qi.model.Automovel;
import java.io.Serializable;

/**
 * Dao responsável pela manipulação da entidade {@link Automovel}.
 * 
 * @author Marcelo Zilio Correa
 * @since 14/11/2017 - 16:54
 */
public class AutomovelDao extends GenericDao<Automovel, Integer>{
    
    public AutomovelDao() {
        super(new Automovel());
    }
   
}