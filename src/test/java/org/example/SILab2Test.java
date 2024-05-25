package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void test1_NullItemList() {
        List<Item> nullList = null;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(nullList, 100));
        assertEquals("allItems list can't be null!", exception.getMessage());
    }
    @Test
    public void test2_AllItemsWithNameUnknown() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("" ,"246356", 150, 0.1f));
        items.add(new Item( "","321563", 240, 0));
        SILab2.checkCart(items, 300);
        for (Item item : items) {
            assertEquals("unknown", item.getName());
        }
    }
    @Test
    // item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'
    public void test3_SpecialCondition() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Specialenuslov", "01245", 777, 0.2f));
        boolean result = SILab2.checkCart(items, 500);
        assertTrue(result);
    }
    @Test
    public void test4_DiscountGreaterThanPrice() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("DiscountItem", "99856", 15, 0.8f));
        assertTrue(SILab2.checkCart(items, 50));
    }
    @Test
    public void test5_PriceGreaterThanDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("PriceItem", "95683", 200, 0.3f));
        boolean result = SILab2.checkCart(items, 200);
        assertTrue(result);
    }
    @Test
    public void test6_ForLoop() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Items", "158656", 190, 0.1f));
        assertDoesNotThrow(() -> SILab2.checkCart(items, 200));
    }
}
