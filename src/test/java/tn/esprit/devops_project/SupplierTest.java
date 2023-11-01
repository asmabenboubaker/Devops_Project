package tn.esprit.devops_project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.services.Iservices.ISupplierService;
import tn.esprit.devops_project.services.SupplierServiceImpl;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SupplierTest {
    @Autowired
    ISupplierService FournisseurService;

    @Test
    public void testAddFournisseur() {
        Supplier f = new Supplier();
        f.setCode("njejnjnef");
        f.setLabel("AAAA");
        f.setSupplierCategory(SupplierCategory.CONVENTIONNE);
        FournisseurService.addSupplier(f);
        System.out.println("Fournisseur Code Test => " + f.getCode());
        assertNotNull(f.getIdSupplier());
        assertNotNull(f.getSupplierCategory());
        FournisseurService.deleteSupplier(f.getIdSupplier());

    }

    @Test
    public void testDeleteFournisseur() {
        Supplier f = new Supplier();
        f.setCode("testDelete");
        f.setLabel("AAAA");
        f.setSupplierCategory(SupplierCategory.CONVENTIONNE);
        FournisseurService.addSupplier(f);
        System.out.println("Supplier Test => " + f);
        FournisseurService.deleteSupplier(f.getIdSupplier());
        assertNull(FournisseurService.retrieveSupplier(f.getIdSupplier()));
    }

    @Test
    public void retrieveAllFournisseurs() {

        List<Supplier> fournisseurs = FournisseurService.retrieveAllSuppliers();
        int expected = fournisseurs.size();
        Supplier f = new Supplier();
        f.setCode("testRetrieve");
        f.setLabel("AAAA");
        f.setSupplierCategory(SupplierCategory.CONVENTIONNE);
        FournisseurService.addSupplier(f);
        assertEquals(expected + 1, FournisseurService.retrieveAllSuppliers().size());
    }


   /* @Test
    public void testUpdateFournisseur()
    {
        Supplier f= new Supplier();
        f.setCode("testRetrieve");
        f.setLabel("AAAA");
        f.setSupplierCategory(SupplierCategory.CONVENTIONNE);
        FournisseurService.addSupplier(f);
        Supplier fr= FournisseurService.retrieveSupplier(f.getIdSupplier());
        fr.setActivitySectors(SupplierCategory.ORDINAIRE);
        FournisseurService.updateSupplier(fr);
        assertEquals(SupplierCategory.ORDINAIRE,fr.getSupplierCategory());
        log.info("test update =>" + fr.getSupplierCategory());

    }*/

    @Test
    public void TestAssignSecteurToFournisseur() {

        ActivitySector sa = new ActivitySector();
        sa.setCodeSecteurActivite("testgtest");
        sa.setLibelleSecteurActivite("testlibelle");

        Supplier f = new Supplier();
        f.setCode("njejnjnef");
        f.setLabel("AAAA");
        f.setSupplierCategory(SupplierCategory.CONVENTIONNE);
        FournisseurService.addSupplier(f);
    }
}