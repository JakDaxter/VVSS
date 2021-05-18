package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Inventory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class InventoryRepositoryTestMock {

    @Mock
    private Inventory Inventory;
    @InjectMocks
    private InventoryRepository inventoryRepository;
    @Test
    void addPart() {
        MockitoAnnotations.initMocks(this);
        inventoryRepository.addPart2(new InhousePart(-200,"Name",20.00,2,4,8,-200));
        Mockito.verify(Inventory, times(1)).addPart(any());
    }

    @Test
    void deletePart() {
        MockitoAnnotations.initMocks(this);
        InhousePart p = new InhousePart(-200,"Name",20.00,2,4,8,-200);
        inventoryRepository.addPart2(p);
        Mockito.verify(Inventory, times(1)).addPart(any());
        inventoryRepository.deletePart2(p);
        Mockito.verify(Inventory, times(1)).addPart(any());
    }
}