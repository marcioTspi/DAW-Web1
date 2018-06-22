package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Professor;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class ProfessorDAO<T> extends DAOGenerico<Professor> implements Serializable {

    public ProfessorDAO(){
        super();
        classePersistente = Professor.class;  
        ordem = "titulacao";// ordenação padrão
    }
 
}
