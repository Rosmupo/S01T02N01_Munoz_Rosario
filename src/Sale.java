import java.util.ArrayList;

public class Sale {

    private int totalSale;
    private ArrayList<Product> productList;

    public Sale(ArrayList<Product> productList) throws Exception {
        totalSale = 0;
        this.productList = productList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public int getTotalSale() throws Exception {
        return calculateTotalSale();
    }

    public int calculateTotalSale() throws Exception {
        int total = 0;
        if (productList.size() == 0) throw new EmptySaleException();
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

}


