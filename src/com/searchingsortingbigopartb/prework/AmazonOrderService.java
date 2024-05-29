package com.searchingsortingbigopartb.prework;

import java.util.List;

/**
 * Manages a list of AmazonPackages.
 * Individual packages can be found by ASIN.
 */
public class AmazonOrderService {

    private List<AmazonPackage> packages;

    /**
     * Constructs an AmazonOrderService object.
     * @param packages - The List of packages in the order
     */
    public AmazonOrderService(List<AmazonPackage> packages) {
        this.packages = packages;
    }

    /**
     * Does a linear search for a package in the known list of packages
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageLinear(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a linear search for a package matching the requested ASIN

        for (int i = 0; i < packages.size(); i++) {
            if (packages.get(i).getAsin().equals(asin)) {
                return packages.get(i); // return the AmazonPackage object itself
            }
        }

        throw new PackageNotFoundException("Package with ASIN " + asin + " not found.");

        //return packages.get(0);
    }

    /**
     * Does a binary search for a package in the known list of packages
     * Note: You should assume that the package list is already sorted when this method is called.
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageBinary(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a binary search for a package matching the requested ASIN

        int left = 0;
        int right = packages.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Compare ASINs
            int comparison = packages.get(mid).getAsin().compareTo(asin);

            // If target is present at the mid, return the package
            if (comparison == 0)
                return packages.get(mid);

            // If target is greater, ignore left half
            if (comparison < 0)
                left = mid + 1;

                // If target is smaller, ignore right half
            else
                right = mid - 1;
        }

        // Target is not present in list
        throw new PackageNotFoundException("Package with ASIN " + asin + " not found.");

        //return -1;

        //return packages.get(0);
    }
}
