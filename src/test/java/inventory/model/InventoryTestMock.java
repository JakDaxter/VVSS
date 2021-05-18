package inventory.model;


import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InventoryTestMock {

    @Mock
    private InhousePart p;
    @InjectMocks
    private Inventory i;
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void addPart() {
        int l=i.getAllParts().size();
        i.addPart(p);
        assert  i.getAllParts().size()==l+1;

    }

    @Test
    void deletePart() {
        int l=i.getAllParts().size();
        i.addPart(p);
        assert  i.getAllParts().size()==l+1;
        i.deletePart(p);
        assert  i.getAllParts().size()==l;


    }
}