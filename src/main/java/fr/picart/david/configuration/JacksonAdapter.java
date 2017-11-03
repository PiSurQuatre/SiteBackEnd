package fr.picart.david.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.sun.org.glassfish.gmbal.IncludeSubclass;
import fr.picart.david.json.JsonViews;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by pic on 03/11/2017.
 */
@Configuration
public class JacksonAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper() {
            private static final long serialVersionUID = 1L;

            @Override
            protected DefaultSerializerProvider _serializerProvider(SerializationConfig config) {
                return super._serializerProvider(config.withView(JsonViews.Basique.class));
            }
        };
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        converter.setObjectMapper(mapper);
        converters.add(converter);
    }

}
