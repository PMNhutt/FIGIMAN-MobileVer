package Model;

import java.io.Serializable;

public class Product implements Serializable {
    int proId;
    String name;
    Double price;
    Double quantity;
    Double soldQuantity;
    String description;
    String category;
    String material;
    String company;
    String img;
    String size;

    public Product() {
    }

    public Product(int proId, String name, Double price, Double quantity, Double soldQuantity, String description, String category, String material, String company, String img, String size) {
        this.proId = proId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.description = description;
        this.category = category;
        this.material = material;
        this.company = company;
        this.img = img;
        this.size = size;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Double soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
