package inventory.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InhousePartTest {

    @Test
    void getMachineId() {
        InhousePart p= new InhousePart(1,"Name",10,10,1,100,2);
        assert (p.getMachineId()==2);
    }

    @Test
    void setMachineId() {
        InhousePart p= new InhousePart(1,"Name",10,10,1,100,2);
        assert (p.getMachineId()==2);
        p.setMachineId(3);
        assert (p.getMachineId()==3);
    }
}