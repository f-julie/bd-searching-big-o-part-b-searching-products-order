package com.searchingsortingbigopartb.prework;

/**
 * Indicates we cannot find a requested AmazonPackage in our service
 */
public class PackageNotFoundException extends Exception {

    private static final long serialVersionUID = 6164546544834514228L;

    public PackageNotFoundException() {
        super();
    }

    public PackageNotFoundException(String message) {
        super(message);
    }

    public PackageNotFoundException(Throwable cause) {
        super(cause);
    }

    public PackageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
