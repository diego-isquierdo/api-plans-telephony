package br.com.planos.planos.models.converter;

import br.com.planos.planos.models.Tipo;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Tipo> {

    @Override
    public Tipo convert(String source) {
        return Tipo.valueOf(source.toUpperCase());
    }
}
