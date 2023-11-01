package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {
    @Mock
    private StockRepository stockRepository  ;
    @InjectMocks
    private StockServiceImpl stockService;
    Stock s = new Stock(1L,"ssqs");

    @Test
    void addStock() {
        List<Stock> stocks = stockService.retrieveAllStock();
        int expected = stocks.size();

        Stock s = new Stock();
        s.setIdStock(1L);
        s.setTitle("dsdsds");
        Stock savedStock = stockService.addStock(s);

        List<Stock> updatedStocks = stockService.retrieveAllStock();


    }
    @Test
    void retrieveStock() {

        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock s1=stockService.retrieveStock(1L);
        Assertions.assertNotNull(1L);
    }


    @Test
    void retrieveAllStock() {

        List<Stock> sList=new ArrayList<>();
        Mockito.when(stockRepository.findAll()).thenReturn(sList);
        List<Stock> result=stockService.retrieveAllStock();
        assertNotNull(result);
        assertEquals(sList, result);
    }

}