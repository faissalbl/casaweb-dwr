/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbl.casa.manager;

import br.com.fbl.casa.eao.DespesaEAO;
import br.com.fbl.casa.model.Despesa;

/**
 *
 * @author Faissal
 */
public class DespesaManager extends GenericManager<Despesa> {
    
    private DespesaEAO despesaEAO;
    
    public DespesaManager() {
        despesaEAO = new DespesaEAO();
    }

    @Override
    public void persist(Despesa entity) {
        super.persist(entity);
    }
    
    @Override
    protected DespesaEAO getEAO() {
        return despesaEAO;
    }

}
