/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Instituicao;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author alexv
 */
@FacesConverter(value = "converterInstituicao")
public class ConverterInstituicao implements Serializable, Converter {

    @Override //converter da tela para o objeto
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equals("Selecione um registro")){
            return null;
        }
        try {
            return EntityManagerUtil.getEntityManager().find(Instituicao.class, Integer.parseInt(string));
        } catch (Exception e) {
            return null;
        }
    }

    @Override //
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null){
            return null;
        }
        Instituicao obj = (Instituicao) o;
        return obj.getId().toString();
    }
    
}
