package searchingsortingbigopartb.prework;

import com.searchingsortingbigopartb.prework.AmazonOrderService;
import com.searchingsortingbigopartb.prework.AmazonPackage;
import com.searchingsortingbigopartb.prework.PackageNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmazonOrderServicePhase2Test {

    @Test
    public void findPackageBinary_asinPresent_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Clothing");
        AmazonPackage p5 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageBinary(p4.getAsin());

        // THEN
        assertEquals(p4, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageBinary_asinFirstItem_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Clothing");
        AmazonPackage p5 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageBinary(p1.getAsin());

        // THEN
        assertEquals(p1, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageBinary_asinLastItem_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Clothing");
        AmazonPackage p5 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageBinary(p5.getAsin());

        // THEN
        assertEquals(p5, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageBinary_asinPresentOneElementList_returnsCorrectAmazonPackage() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        List<AmazonPackage> packages = Arrays.asList(p1);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN
        AmazonPackage result = order.findPackageBinary("JF8G7H");

        // THEN
        assertEquals(p1, result, "The wrong package was returned!");
    }

    @Test
    public void findPackageBinary_emptyPackageList_throwsPackageNotFoundException() throws PackageNotFoundException {
        // GIVEN
        List<AmazonPackage> packages = new ArrayList<>();
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN + THEN
        assertThrows(PackageNotFoundException.class, () -> order.findPackageBinary("asin"));
    }

    @Test
    public void findPackageBinary_asinNotPresent_throwsPackageNotFoundException() throws PackageNotFoundException {
        // GIVEN
        AmazonPackage p1 = new AmazonPackage("56DF42", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Movie");
        AmazonPackage p2 = new AmazonPackage("AFE156", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Sock");
        AmazonPackage p3 = new AmazonPackage("F54RE4", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Boot");
        AmazonPackage p4 = new AmazonPackage("FJEF45", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Clothing");
        AmazonPackage p5 = new AmazonPackage("JF8G7H", LocalDate.of(2019, 12, 02),
                                             LocalDate.of(2019, 12, 04), "Book");
        List<AmazonPackage> packages = Arrays.asList(p1, p2, p3, p4, p5);
        AmazonOrderService order = new AmazonOrderService(packages);

        // WHEN + THEN
        assertThrows(PackageNotFoundException.class, () -> order.findPackageBinary("FJG789"));
    }

    @Test
    public void findPackageBinary_manyPackages_significantlyOutperformsFindPackageLinear() throws PackageNotFoundException {
        // GIVEN
        List<AmazonPackage> packages = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            packages.add(new AmazonPackage("" + i, LocalDate.now(), LocalDate.now(), "category"));
        }
        AmazonOrderService orderService = new AmazonOrderService(packages);

        // WHEN
        Instant linearStart = Instant.now();
        AmazonPackage linearPackage = orderService.findPackageLinear("9999");
        Instant linearEnd = Instant.now();

        Instant binaryStart = Instant.now();
        AmazonPackage binaryPackage = orderService.findPackageBinary("9999");
        Instant binaryEnd = Instant.now();

        // THEN
        long linearMilliDuration = linearEnd.toEpochMilli() - linearStart.toEpochMilli();
        long binaryMilliDuration = binaryEnd.toEpochMilli() - binaryStart.toEpochMilli();

        assertTrue(linearMilliDuration > 10 * binaryMilliDuration);
    }

}
