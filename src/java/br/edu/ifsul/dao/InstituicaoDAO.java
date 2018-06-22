package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Instituicao;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class InstituicaoDAO<T> extends DAOGenerico<Instituicao> implements Serializable {

    public InstituicaoDAO(){
        super();
        classePersistente = Instituicao.class;  
        ordem = "nome";// ordenação padrão
    }
 
}
