package br.com.fbl.casa.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tipo_despesas")
public class TipoDespesa extends TipoAbstrato {

    private List<Despesa> despesas;

    @OneToMany(mappedBy = "tipoDespesa")
    public List<Despesa> getDespesas() {
        
        if (despesas == null)
            despesas = new ArrayList<Despesa>();
        
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null
                && obj.equals(getNome());
    }

 }
