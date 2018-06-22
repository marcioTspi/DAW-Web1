/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;



@ManagedBean(name = "controleIndex")
//@RequestScoped //ciclo de vida mais curto
//@SessionScoped //
@ApplicationScoped
public class ControleIndex implements Serializable {

    private String mensagem;

    public ControleIndex() {
        mensagem = "Pagina Inicial do Sistema";
    }

    public String index() { //retorna para o index
        return "/index?faces-redirect=true";
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
