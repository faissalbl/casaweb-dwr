/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbl.casa.eao;

import br.com.fbl.casa.model.GenericEntity;
import br.com.fbl.casa.model.GenericMesReferenciaContent;
import br.com.fbl.casa.model.MesReferencia;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

/**
 *
 * @author Faissal
 */
public abstract class GenericMesReferenciaContentEAO<T extends GenericEntity> extends GenericEAO<T> {
    
    protected MesReferencia mesReferencia;
    
    public GenericMesReferenciaContentEAO() {
        WebContext wc = WebContextFactory.get();
        mesReferencia = (MesReferencia) wc.getSession().getAttribute("mesReferencia");
    }
    
    @Override
    public void persist(T entity) {
        ((GenericMesReferenciaContent) entity).setMesReferencia(mesReferencia);
        super.persist(entity);
    }

    @Override
    public T merge(T entity) {
        ((GenericMesReferenciaContent) entity).setMesReferencia(mesReferencia);
        return super.merge(entity);
    }
    
    
}
