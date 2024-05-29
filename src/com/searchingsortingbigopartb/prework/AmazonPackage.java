package com.searchingsortingbigopartb.prework;

import java.time.LocalDate;
import java.util.Objects;

/**
 * POJO representing an Amazon package. Includes product and shipping information.
 */
public class AmazonPackage implements Comparable<AmazonPackage> {
    private String asin;
    private LocalDate shipDate;
    private LocalDate estimatedDelivery;
    private String category;

    /**
     *
     * @param asin - the unique id for each product
     * @param shipDate - product ship date
     * @param estimatedDelivery - product estimated delivery date
     * @param category - product category
     */
    public AmazonPackage(String asin, LocalDate shipDate, LocalDate estimatedDelivery, String category) {
        this.asin = asin;
        this.shipDate = shipDate;
        this.estimatedDelivery = estimatedDelivery;
        this.category = category;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public LocalDate getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(LocalDate estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AmazonPackage that = (AmazonPackage) o;
        return Objects.equals(asin, that.asin) &&
            Objects.equals(shipDate, that.shipDate) &&
            Objects.equals(estimatedDelivery, that.estimatedDelivery) &&
            Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, shipDate, estimatedDelivery, category);
    }

    @Override
    public String toString() {
        return String.format("AmazonPackage{asin=%s, shipDate=%s, estimatedDelivery=%s, category=%s}",
                             asin, shipDate, estimatedDelivery, category);
    }

    @Override
    public int compareTo(AmazonPackage o) {
        // ASIN most important
        if (this.asin.compareTo(o.asin) != 0) {
            return this.asin.compareTo(o.asin);
        }
        // then category (should be equal for same ASIN)
        if (this.category.compareTo(o.category) != 0) {
            return this.category.compareTo(o.category);
        }
        // then ship date
        if (this.shipDate.compareTo(o.shipDate) != 0) {
            return this.shipDate.compareTo(o.shipDate);
        }
        // then estimated delivery
        return this.estimatedDelivery.compareTo(o.estimatedDelivery);
    }
}
