package example.org.test.w05d03solapp02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static example.org.test.w05d03solapp02.ProductDatabaseContract.COLUMN_DESCRIPTION;
import static example.org.test.w05d03solapp02.ProductDatabaseContract.COLUMN_IDNUMBER;
import static example.org.test.w05d03solapp02.ProductDatabaseContract.COLUMN_INVENTORY_COUNT;
import static example.org.test.w05d03solapp02.ProductDatabaseContract.COLUMN_NAME;
import static example.org.test.w05d03solapp02.ProductDatabaseContract.DATABASE_NAME;
import static example.org.test.w05d03solapp02.ProductDatabaseContract.DATABASE_VERSION;
import static example.org.test.w05d03solapp02.ProductDatabaseContract.TABLE_NAME;

public class ProductDatabaseHelper extends SQLiteOpenHelper {

    public ProductDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(ProductDatabaseContract.createQuery());

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
    onCreate(database);
    }

    public long insertProductIntoDatabase(@NonNull Product product){
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        // insert key value pairs
        contentValues.put(COLUMN_NAME, product.getProductName());
        contentValues.put(COLUMN_IDNUMBER, product.getProductIdNumber());
        contentValues.put(COLUMN_INVENTORY_COUNT, product.getProductInventoryCount());
        contentValues.put(COLUMN_DESCRIPTION, product.getProductDescription());

        return writableDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Product> getAllProductsFromDatabase(){
        ArrayList<Product> returnProductList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery(ProductDatabaseContract.getAllProductsQuery(), null);
        if(cursor.moveToFirst()){

            do {
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                int idNumber = cursor.getInt(cursor.getColumnIndex(COLUMN_IDNUMBER));
                String inventoryCount = cursor.getString(cursor.getColumnIndex(COLUMN_INVENTORY_COUNT));
                String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                returnProductList.add(new Product(name, idNumber, inventoryCount, description));
            } while (cursor.moveToNext());
        }
        cursor.close();;
        return returnProductList;
    }
}
