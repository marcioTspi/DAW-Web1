package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Especialidade;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class EspecialidadeDAO<T> extends DAOGenerico<Especialidade> implements Serializable {

    public EspecialidadeDAO(){
        super();
        classePersistente = Especialidade.class;  
        ordem = "nome";// ordenação padrão
    }
 
}
