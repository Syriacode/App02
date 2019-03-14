package example.org.test.w05d03solapp02;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String productName;
    private int productIdNumber;
    private String productInventoryCount;
    private String productDescription;

    public Product(){}

    protected Product(Parcel in) {
        productName = in.readString();
        productIdNumber = in.readInt();
        productInventoryCount = in.readString();
        productDescription = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductIdNumber() {
        return productIdNumber;
    }

    public void setProductIdNumber(int productIdNumber) {
        this.productIdNumber = productIdNumber;
    }

    public String getProductInventoryCount() {
        return productInventoryCount;
    }

    public void setProductInventoryCount(String productInventoryCount) {
        this.productInventoryCount = productInventoryCount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Product(String productName, int productIdNumber, String productInventoryCount, String productDescription) {
        this.productName = productName;
        this.productIdNumber = productIdNumber;
        this.productInventoryCount = productInventoryCount;
        this.productDescription = productDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productName);
        dest.writeInt(productIdNumber);
        dest.writeString(productInventoryCount);
        dest.writeString(productDescription);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productIdNumber='" + productIdNumber + '\'' +
                ", productInventoryCount='" + productInventoryCount + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
