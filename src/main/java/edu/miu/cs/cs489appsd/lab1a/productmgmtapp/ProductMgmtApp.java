package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProductMgmtApp {
    ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
        List<Product> list = Arrays.asList(new Product[] {
                new Product.Builder().withProductId("3128874119").withName("Banana").withDateSupplied(new Date(2023,01,24)).withQuantityInStock(124).withUnitPrice(10.02).build(),
                new Product.Builder().withProductId("2927458265").withName("Apple").withUnitPrice(1.09).withQuantityInStock(18).withDateSupplied(new Date(2022,12,9)).build(),
                new Product.Builder().withProductId("9189927460").withName("Carrot").withDateSupplied(new Date(2023, 03, 31)).withQuantityInStock(89).withUnitPrice(2.99).build()
        });
        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        ProductMgmtApp app = new ProductMgmtApp();
        // Convert the ArrayList to a JSON array
        app.printAll(list);
    }
    private void printAll(List<Product> list){
        printJson(list);
        printXML(list);
        printCSV(list);
    }
    private void printJson(List<Product> list){
        System.out.println("----Json----");
        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonArray
                    = objectMapper.writeValueAsString(list);
            System.out.println(jsonArray);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    private void printXML(List<Product> list){
        System.out.println("----XML----");

        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String xml = xmlMapper.writeValueAsString(list);
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void printCSV(List<Product> list){
        if (list == null) return;
        System.out.println("----CSV----");
        // Include a header row if specified
        System.out.println("productId, name, dateSupplied, quantityInStock, unitPrice");
        for (Product product : list) {
            System.out.printf("%s, %s, %tF, %d, %.2f%n",
                    product.getProductId(),
                    product.getName(),
                    product.getDateSupplied(),
                    product.getQuantityInStock(),
                    product.getUnitPrice()
            );
        }

    }
}
