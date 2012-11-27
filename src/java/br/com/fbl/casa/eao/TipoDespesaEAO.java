/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbl.casa.eao;

import br.com.fbl.casa.model.TipoDespesa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Faissal
 */
public class TipoDespesaEAO extends GenericEAO<TipoDespesa> {

    private TipoDespesa tipoDespesaExample;
    private List<TipoDespesa> resultList;

    public TipoDespesaEAO() {
        tipoDespesaExample = new TipoDespesa();
        resultList = new ArrayList<TipoDespesa>();
    }
    
    public TipoDespesa find(long tipoDespesaId) {
        return super.find(TipoDespesa.class, tipoDespesaId);
    }

    private void refreshResultList() {
        
        String jpql =
                "select td from TipoDespesa td ";
        if (tipoDespesaExample.getNome() != null) {
            jpql += "where td.nome = :pNome)";
        }
        
        Query query = getEntityManager().createQuery(jpql);
        
        if (tipoDespesaExample.getNome() != null) {
            query.setParameter("pNome", tipoDespesaExample.getNome());
        }

        resultList = query.getResultList();
    }
    
    public TipoDespesa getTipoDespesaExample() {
        return tipoDespesaExample;
    }
    
    @Override
    public List<TipoDespesa> getResultList() {
        if (resultList.isEmpty()) refreshResultList();
        return resultList;
    }
}
