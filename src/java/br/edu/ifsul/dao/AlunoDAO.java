package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aluno;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class AlunoDAO<T> extends DAOGenerico<Aluno> implements Serializable {

    public AlunoDAO(){
        super();
        classePersistente = Aluno.class;  
        ordem = "nome";// ordenação padrão
    }
 
}
