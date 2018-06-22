/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AlunoDAO;
import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.dao.CursoDAO;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "controleDisciplina")
@SessionScoped
public class ControleDisciplina implements Serializable {
    
    private DisciplinaDAO<Disciplina> dao;
    private Disciplina objeto;
    private CursoDAO daoCurso;
    private Curso curso;
    private AlunoDAO daoAluno;
    private Aluno aluno;
    private Boolean novoAluno;
    
    public ControleDisciplina(){
        dao = new DisciplinaDAO<>();
        daoCurso = new CursoDAO();
        daoAluno = new AlunoDAO();
    }
    
    public void novoAluno() {
        //setAluno(new Aluno());
        //novoAluno = true;
        setNovoAluno((Boolean) true);
    }
    
    public void adicionarAluno() {
        //objeto.getAlunosdaDisciplina().add(aluno);
        if (aluno != null){
            if (!objeto.getAlunosdaDisciplina().contains(aluno)){
                objeto.getAlunosdaDisciplina().add(aluno);
                Util.mensagemInformacao("Aluno adicionado com sucesso!");
            } else {
                Util.mensagemErro("Aluno já existente nessa lista!");
            }
        }
    }
    
    public void alterarAluno(int index){
        /*setAluno(getObjeto().getAlunosdaDisciplina().get(index));
        novoAluno = false;*/
        aluno = objeto.getAlunosdaDisciplina().get(index);   
    }
    
    public void removerAluno(int index){
        /*objeto.getAlunosdaDisciplina().remove(index);
        Util.mensagemInformacao("Aluno removido com sucesso!");*/
        objeto.getAlunosdaDisciplina().remove(index);
    }
    
    
   public String listar(){
        return "/privado/disciplina/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Disciplina();
        return "formulario?faces-redirect=true";
    }
    
    public String salvar(){
        boolean persistiu;
        if (getObjeto().getId() == null){
            persistiu = getDao().persist(getObjeto());
        } else {
            persistiu = getDao().merge(getObjeto());
        }
        if (persistiu){
            Util.mensagemInformacao(getDao().getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(getDao().getMensagem());
            return "formulario?faces-redirect=true";
        }
    }
    
    public String cancelar(){
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id){
        setObjeto(getDao().localizar(id));
        return "formulario?faces-redirect=true";
    }
    
    public void remover(Integer id){
        setObjeto(getDao().localizar(id));
        if (getDao().remover(getObjeto())){
            Util.mensagemInformacao(getDao().getMensagem());
        } else {
            Util.mensagemErro(getDao().getMensagem());
        }
    }

    public DisciplinaDAO<Disciplina> getDao() {
        return dao;
    }

    public void setDao(DisciplinaDAO<Disciplina> dao) {
        this.dao = dao;
    }

    public Disciplina getObjeto() {
        return objeto;
    }

    public void setObjeto(Disciplina objeto) {
        this.objeto = objeto;
    }

    public CursoDAO getDaoCurso() {
        return daoCurso;
    }

    public void setDaoCurso(CursoDAO daoCurso) {
        this.daoCurso = daoCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public AlunoDAO getDaoAluno() {
        return daoAluno;
    }

    public void setDaoAluno(AlunoDAO daoAluno) {
        this.daoAluno = daoAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getNovoAluno() {
        return novoAluno;
    }

    public void setNovoAluno(Boolean novoAluno) {
        this.novoAluno = novoAluno;
    }

    
    
    
    
}