/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbl.casa.manager;

import br.com.fbl.casa.eao.GenericEAO;
import br.com.fbl.casa.model.GenericEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Faissal
 */
public abstract class GenericManager<T extends GenericEntity> implements Serializable {
    
    protected abstract <E extends GenericEAO> E getEAO();
    
   public String createNew() {
        return "edit";
    }
    
    public void remove(T entity) {
        getEAO().remove(entity);
    }    
    
    public void persist(T entity) {
        if (entity.getId() == null) {
            getEAO().persist(entity);
        } else {
            getEAO().merge(entity);
        }
    }    
    
    public List<? extends GenericEntity> findEntities() {
        return getEAO().getResultList();
    }
}
