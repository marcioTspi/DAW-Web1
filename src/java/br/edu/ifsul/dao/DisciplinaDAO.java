package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Disciplina;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class DisciplinaDAO<T> extends DAOGenerico<Disciplina> implements Serializable {

    public DisciplinaDAO(){
        super();
        classePersistente = Disciplina.class;  
        ordem = "nome";// ordenação padrão
    }
 
}
