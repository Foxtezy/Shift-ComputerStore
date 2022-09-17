package ru.shift.makhov.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ru.shift.makhov.shop.repository.ShopRepository;
import ru.shift.makhov.shop.service.ShopService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class DeleteWareTests {

    private final ShopService shopService;

    private final String serialNumber = "1234";

    @Autowired
    public DeleteWareTests(ShopService shopService) {
        this.shopService = shopService;
    }

    @MockBean
    private ShopRepository shopRepository;

    @Test
    public void deleteValidWare() {
        Mockito.when(shopRepository.existsById(serialNumber)).thenReturn(true);
        try {
            shopService.deleteWare(serialNumber);
        } catch (ResponseStatusException e) {
            Assertions.fail();
        }
    }

    @Test
    public void deleteInvalidWare() {
        Mockito.when(shopRepository.existsById(serialNumber)).thenReturn(false);
        try {
            shopService.deleteWare(serialNumber);
            Assertions.fail();
        } catch (ResponseStatusException e) {
            Assertions.assertEquals(new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found ware").toString(), e.toString());
        }
    }

}
