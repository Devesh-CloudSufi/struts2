package org.apache.struts2.config;

/**
 * @author <a href="mailto:kristian@zenior.no">Kristian Rosenvold</a>
 */
public interface AnnotatedValueResolver {
    /**
     * Calculates the convention based location of the result file
     * @param actionClass The class to get the location from
     * @return A standard struts "value" value.
     */
    String getLocation(Class actionClass);
}
