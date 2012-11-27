/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbl.casa.manager;

import br.com.fbl.casa.eao.TipoDespesaEAO;
import br.com.fbl.casa.model.TipoDespesa;

/**
 *
 * @author Faissal
 */
public class TipoDespesaManager extends GenericManager<TipoDespesa> {

    private TipoDespesaEAO tipoDespesaEAO;

    public TipoDespesaManager() {
        tipoDespesaEAO = new TipoDespesaEAO();
    }
    
    public TipoDespesa find(long tipoDespesaId) {
        return tipoDespesaEAO.find(tipoDespesaId);
    }

    @Override
    public void persist(TipoDespesa entity) {
        super.persist(entity);
    }

    @Override
    protected TipoDespesaEAO getEAO() {
        return tipoDespesaEAO;
    }
}