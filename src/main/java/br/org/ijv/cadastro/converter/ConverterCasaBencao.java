package br.org.ijv.cadastro.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.org.ijv.cadastro.model.Casa;


@FacesConverter("converterCasa")
public class ConverterCasaBencao implements Converter,Serializable {

private static final long serialVersionUID = 1L;


public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
    if (value != null && !value.isEmpty()) {
        return (Casa) uiComponent.getAttributes().get(value);
    }
    return null;
}

public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
    if (value instanceof Casa) {
    	Casa entity= (Casa) value;
        if (entity != null && entity instanceof Casa && entity.getId() != null) {
            uiComponent.getAttributes().put( entity.getId().toString(), entity);
            return entity.getId().toString();
        }
    }
    return "";
    }
}

