package br.com.planos.planos.models.converter;

import br.com.planos.planos.models.Type;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Type> {

    @Override
    public Type convert(String source) {
        return Type.valueOf(source.toUpperCase());
    }
}
