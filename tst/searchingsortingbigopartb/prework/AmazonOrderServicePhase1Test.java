package searchingsortingbigopartb.prework;

import com.searchingsortingbigopartb.prework.AmazonOrderService;
import com.searchingsortingbigopartb.prework.AmazonPackage;
import com.searchingsortingbigopartb.prework.PackageNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AmazonOrderServicePhase1Test {

    @Test
    public void findPackageLinear_asinPresent_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p5 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Clothing");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageLinear("56DF42");

        // THEN
        assertEquals(p4, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageLinear_asinFirstItem_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p5 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Clothing");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageLinear("JF8G7H");

        // THEN
        assertEquals(p1, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageLinear_asinLastItem_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p5 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Clothing");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageLinear("FJEF45");

        // THEN
        assertEquals(p5, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageLinear_asinPresentOneElementList_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        List<AmazonPackage> packages = Arrays.asList(p1);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageLinear("JF8G7H");

        // THEN
        assertEquals(p1, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageLinear_emptyPackageList_throwsPackageNotFoundException() throws PackageNotFoundException {
        // GIVEN
        List<AmazonPackage> packages = new ArrayList<>();
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN + THEN
        assertThrows(PackageNotFoundException.class, () -> order.findPackageLinear("asin"));
    }

    @Test
    public void findPackageLinear_asinNotPresent_throwsPackageNotFoundException() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                LocalDate.of(2019, 12, 04), "Book");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p5 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                LocalDate.of(2019, 12, 04), "Clothing");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN + THEN
        assertThrows(PackageNotFoundException.class, () -> order.findPackageLinear("FJG789"));
    }


}
