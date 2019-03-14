package example.org.test.w05d03solapp02;

import android.util.Log;

public class ProductDatabaseContract {
    public static final String DATABASE_NAME = "product_db";
    public static final int DATABASE_VERSION = 1;
    //Database table name
    public static final String TABLE_NAME = "Products";
    //Columns in database names
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IDNUMBER = "IdNumber";
    public static final String COLUMN_INVENTORY_COUNT = "inventoryCount";
    public static final String COLUMN_DESCRIPTION = "description";

    // Create the queries
    public static String createQuery() {
        StringBuilder queryBuilder = new StringBuilder();
        //Query to create Table
        queryBuilder.append("CREATE TABLE ");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        // primary key
        queryBuilder.append(COLUMN_IDNUMBER);
        queryBuilder.append(" ");
        queryBuilder.append(" INT NONNULL IDENTITY PRIMARY KEY, ");
        //Adding the rest of the columns
        queryBuilder.append(COLUMN_NAME);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_IDNUMBER);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_INVENTORY_COUNT);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_DESCRIPTION);
        queryBuilder.append(" TEXT, ");

        Log.d("TAG", "createQuery: " + queryBuilder.toString());

        return queryBuilder.toString();
    }

    public static String getAllProductsQuery(){
        return "SELECT * FROM " + TABLE_NAME;
    }

}
