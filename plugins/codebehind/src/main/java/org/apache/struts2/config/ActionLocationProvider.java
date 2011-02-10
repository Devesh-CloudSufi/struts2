package org.apache.struts2.config;

/**
 * @author <a href="mailto:kristian@zenior.no">Kristian Rosenvold</a>
 */
public interface ActionLocationProvider {
    /**
     * Returns the location string for a given action class
     * @param actionClass The class to get the location from
     * @return A standard struts "location" value.
     */
    String getLocation(Class actionClass);
}
