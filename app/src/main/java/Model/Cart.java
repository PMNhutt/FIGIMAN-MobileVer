package Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Cart implements Serializable {
    int productId;
    String productName;
    String img;
    int quantity;

    public Cart(int productId, String productName, String img, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.img = img;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
