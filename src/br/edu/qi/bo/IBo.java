package br.edu.qi.bo;

import java.util.List;

/**
 * Interface base de Bo.
 *
 * @author Marcelo Zilio Correa
 * @param <T> Tipo da entidade.
 * @since 23/11/2017 - 15:43
 */
public interface IBo<T> {

    public void save(T obj) throws Exception;
    
    public void update(T obj) throws Exception;

    public void delete(T obj) throws Exception;

    public List<T> findAll() throws Exception;

    public T find(T obj) throws Exception;
}
