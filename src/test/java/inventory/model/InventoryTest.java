package inventory.model;

import org.junit.jupiter.api.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    @Tag("1")
    void lookupProduct() {
        lookupProduct1();
        lookupProduct2();
        lookupProduct3();
        lookupProduct4();
    }

    @DisplayName("1")
    void lookupProduct1(){
        Inventory inv=new Inventory();
        Part p= new InhousePart(1,"Main",1.0,2,1,10,10);
        ObservableList<Part> addParts = FXCollections.observableArrayList();
        for(int i=0;i<10;i++){
            inv.addProduct(new Product(i,"Name"+i,10.1,2,1,10,addParts));
        }
        assert (inv.lookupProduct("").getProductId()==0);
    }

    @DisplayName("2")
    void lookupProduct2(){
        Inventory inv=new Inventory();
        assert (inv.lookupProduct("Name3").getProductId()==0);
    }

    @DisplayName("3")
    void lookupProduct3(){
        Inventory inv=new Inventory();
        Part p= new InhousePart(1,"Main",1.0,2,1,10,10);
        ObservableList<Part> addParts = FXCollections.observableArrayList();
        for(int i=0;i<10;i++){
            inv.addProduct(new Product(i,"Name"+i,10.1,2,1,10,addParts));
        }
        assert (inv.lookupProduct("Name11")==null);
    }

    @DisplayName("4")
    void lookupProduct4(){
        Inventory inv=new Inventory();
        Part p= new InhousePart(1,"Main",1.0,2,1,10,10);
        ObservableList<Part> addParts = FXCollections.observableArrayList();
        for(int i=0;i<10;i++){
            inv.addProduct(new Product(i,"Name"+i,10.1,2,1,10,addParts));
        }
        assert (inv.lookupProduct("Name5").getProductId()==5);
    }
}