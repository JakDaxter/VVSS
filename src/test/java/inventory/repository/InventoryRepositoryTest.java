package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addPart() {
        InhousePart p= new InhousePart(-104,"TestNamev4",10,10,1,100,2);
        InventoryRepository i=new InventoryRepository();
        i.addPart(p);
        assert i.lookupPart("TestNamev4").getPartId()==p.getPartId();
        i.deletePart(p);
    }

    @Test
    void deletePart() {
        InhousePart p= new InhousePart(-104,"TestName2v4",10,10,1,100,2);
        InventoryRepository i=new InventoryRepository();
        i.addPart(p);
        assert i.lookupPart("TestName3v4")==null;
        i.deletePart(p);
    }
}