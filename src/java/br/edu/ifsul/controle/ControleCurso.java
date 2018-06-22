/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.dao.CursoDAO;
import br.edu.ifsul.dao.InstituicaoDAO;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.util.HashMap;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "controleCurso")
@SessionScoped
public class ControleCurso implements Serializable {
    
    private CursoDAO<Curso> dao;
    private Curso objeto;
    private DisciplinaDAO daoDisciplina;
    private Disciplina disciplina;
    private InstituicaoDAO daoInstituicao;
    private Boolean novaDisciplina;
    
    public ControleCurso(){
        dao = new CursoDAO<>();
        daoDisciplina = new DisciplinaDAO();
        daoInstituicao = new InstituicaoDAO();
    }
    
    public void imprimirRelatorio() {
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("Cursos", parametros, dao.getListaTodos());
    }
    
    public void novaDisciplina() {
        //setDisciplina(new Disciplina());
         disciplina = new Disciplina();
         novaDisciplina = true;
    }
    
    public void adicionarDisciplina(){
        disciplina.setCurso(objeto);
        objeto.getDisciplinas().add(disciplina);
    }
    
    public void alterarDisciplina(int index){
        disciplina = objeto.getDisciplinas().get(index);
        objeto.removerDisciplina(index);
    }
    
    /*public void salvarDisciplina(){
        if (novaDisciplina){
            getObjeto().adicionarDisciplina(getDisciplina());
        }
        Util.mensagemInformacao("Disciplina persistida com sucesso!");
    } */
    
    public void removerDisciplina(int index){
        /*getObjeto().removerDisciplina(index);
        Util.mensagemInformacao("Disciplina removida com sucesso!");*/
        objeto.getDisciplinas().remove(index);
    }
    
   public String listar(){
        return "/privado/curso/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Curso();
        return "formulario?faces-redirect=true";
    }
    
    public String salvar(){
        boolean persistiu;
        if (objeto.getId() == null){
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu){
            Util.mensagemInformacao(dao.getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(dao.getMensagem());
            return "formulario?faces-redirect=true";
        }
    }
    
    public String cancelar(){
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id){
        objeto = dao.localizar(id);
        return "formulario?faces-redirect=true";
    }
    
    public void remover(Integer id){
        objeto = dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public CursoDAO<Curso> getDao() {
        return dao;
    }

    public void setDao(CursoDAO<Curso> dao) {
        this.dao = dao;
    }

    public Curso getObjeto() {
        return objeto;
    }

    public void setObjeto(Curso objeto) {
        this.objeto = objeto;
    }

    public DisciplinaDAO getDaoDisciplina() {
        return daoDisciplina;
    }

    public void setDaoDisciplina(DisciplinaDAO daoDisciplina) {
        this.daoDisciplina = daoDisciplina;
    }

    public InstituicaoDAO getDaoInstituicao() {
        return daoInstituicao;
    }

    public void setDaoInstituicao(InstituicaoDAO daoInstituicao) {
        this.daoInstituicao = daoInstituicao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Boolean getNovaDisciplina() {
        return novaDisciplina;
    }

    public void setNovaDisciplina(Boolean novaDisciplina) {
        this.novaDisciplina = novaDisciplina;
    }  
    
}