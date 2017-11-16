package br.edu.qi.dao;

import br.edu.qi.model.Cliente;
import java.io.Serializable;

/**
 * Dao responsável pela manipulação da entidade {@link Cliente}.
 * 
 * @author Marcelo Zilio Correa
 * @since 14/11/2017 - 16:56
 */
public class ClienteDao extends GenericDao<Cliente, Integer>{
    
    public ClienteDao(Cliente entity) {
        super(entity);
    }
    
}