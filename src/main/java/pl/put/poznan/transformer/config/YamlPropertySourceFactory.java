package pl.put.poznan.transformer.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.Objects;
import java.util.Properties;

/**
 * Factory for PropertySource to read .yml files
 *
 * @author Piotr Parzysz
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

    /**
     * Yaml property source
     *
     * @param name            resource name
     * @param encodedResource resource
     * @return PropertySource
     */
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(encodedResource.getResource());
        Properties properties = factory.getObject();
        return new PropertiesPropertySource(Objects.requireNonNull(encodedResource.getResource().getFilename()), Objects.requireNonNull(properties));
    }

}
