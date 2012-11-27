/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbl.casa.eao;

import br.com.fbl.casa.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Faissal
 */
public class UsuarioEAO extends GenericEAO<Usuario> {

    private Usuario usuarioExample;
    private List<Usuario> resultList;

    public UsuarioEAO() {
        usuarioExample = new Usuario();
        resultList = new ArrayList<Usuario>();
    }

    private void refreshResultList() {
        
        boolean existeParamNome = usuarioExample.getNome() != null;
        
        StringBuilder jpql = new StringBuilder();
        jpql.append("select u from Usuario u where 1 = 1 ");
        
        if (existeParamNome) {
            jpql.append("and u.nome = :pNome ");
        }
        
        jpql.append("order by u.nome");
        
        Query q = getEntityManager().createQuery(jpql.toString());
        
        if (existeParamNome) {
            q.setParameter("pNome", usuarioExample.getNome());
        }
        
        resultList = q.getResultList();
    }
    
    public Usuario getUsuarioExample() {
        return usuarioExample;
    }
    
    @Override
    public List<Usuario> getResultList() {
        if (resultList.isEmpty()) refreshResultList();
        return resultList;
    }
}
