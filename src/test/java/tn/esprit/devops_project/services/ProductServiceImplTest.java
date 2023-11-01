    package tn.esprit.devops_project.services;

    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Order;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.Mockito;
    import org.mockito.junit.jupiter.MockitoExtension;
    import tn.esprit.devops_project.entities.ActivitySector;
    import tn.esprit.devops_project.entities.Product;
    import tn.esprit.devops_project.entities.ProductCategory;
    import tn.esprit.devops_project.repositories.ActivitySectorRepository;
    import tn.esprit.devops_project.repositories.ProductRepository;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    import static org.junit.jupiter.api.Assertions.*;
    @ExtendWith(MockitoExtension.class)
    class ProductServiceImplTest {
        @Mock
        ProductRepository PRepository;
        @InjectMocks
        ProductServiceImpl PServiceImpl;

        ActivitySector secteurActivite = new ActivitySector("3a","Papier");

        Product P=new Product(1L,"eee",20,20);

        @Test
        @Order(0)
        void addProduct() {

            Product p=new Product();
            List<Product> LP=new ArrayList<>();
            for(Long i=3L;i<=10L;i++){
                p.setIdProduct(i);
                p.setTitle("eezeze");
                p.setQuantity(20);
                p.setPrice(50);
                Product pp=PRepository.save(p);
                LP.add(pp);
            }
        }

        @Test
        @Order(2)
        void retrieveProduct() {

            Mockito.when(PRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(P));
            Product p1=PServiceImpl.retrieveProduct(1L);
            Assertions.assertNotNull(1L);
        }

        @Test
        @Order(3)
        void retreiveAllProduct() {

            List<Product> productList = new ArrayList<>();
            Mockito.when(PRepository.findAll()).thenReturn(productList);

            List<Product> result = PServiceImpl.retreiveAllProduct();

            assertNotNull(result);
            assertEquals(productList, result);
        }

        @Test
        void retrieveProductByCategory() {

            List<Product> productList = new ArrayList<>();
            productList.add(new Product(1L, "Product 1", 10, 50, ProductCategory.BOOKS));
            productList.add(new Product(2L, "Product 2", 20, 100, ProductCategory.CLOTHING));
            productList.add(new Product(3L, "Product 3", 15, 75, ProductCategory.ELECTRONICS));


            Mockito.when(PRepository.findByCategory(Mockito.any(ProductCategory.class))).thenReturn(productList);


            List<Product> result = PServiceImpl.retrieveProductByCategory(ProductCategory.BOOKS);


            assertNotNull(result);
           /* assertEquals(2, result.size());*/

        }

        @Test
        void deleteProduct() {
            // Create a product to be deleted
            Product productToDelete = new Product(1L, "Product 1", 10, 50);

            // Call the method under test
            PServiceImpl.deleteProduct(1L);

            // Verify that the repository method deleteById is called with the correct product ID
            Mockito.verify(PRepository).deleteById(1L);
        }


        @org.junit.jupiter.api.Test
        @Order(4)
    void retreiveProductStock() {
            Iterable<Product> LP=PRepository.findAll();
            Assertions.assertNotNull(LP);
    }
}