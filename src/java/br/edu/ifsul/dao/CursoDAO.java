package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Curso;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class CursoDAO<T> extends DAOGenerico<Curso> implements Serializable {

    public CursoDAO(){
        super();
        classePersistente = Curso.class;  
        ordem = "nome";// ordenação padrão
    }
 
}
