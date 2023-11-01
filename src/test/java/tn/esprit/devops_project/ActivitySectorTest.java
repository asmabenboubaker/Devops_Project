package tn.esprit.devops_project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.services.ActivitySectorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class ActivitySectorTest {
    @Mock
    ActivitySectorRepository secteurActiviteRepository;
    @InjectMocks
    ActivitySectorImpl secteurActiviteServiceImpl;


    ActivitySector secteurActivite = new ActivitySector("3a","Papier");

    @Test
    public void testRetrieveSecteurActivite() {

        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteurActivite));
        ActivitySector secteurActivite1 = secteurActiviteServiceImpl.retrieveActivitySector(2L);
        Assertions.assertNotNull(secteurActivite1);
    }

    @org.junit.jupiter.api.Test
    @Order(0)
    void addSecteurActivite() {
        ActivitySector secteurActivite = new ActivitySector();
        List<ActivitySector> LSecteurActivite = new ArrayList<>();
        for (Long i=3L;i<=10L;i++) {
            secteurActivite.setIdSecteurActivite(i);
            secteurActivite.setCodeSecteurActivite("3w");
            secteurActivite.setLibelleSecteurActivite("lait");
            ActivitySector dd=secteurActiviteRepository.save(secteurActivite);
            LSecteurActivite.add(dd);
        }
        assertEquals(8,LSecteurActivite.size());
    }
    @org.junit.jupiter.api.Test
    @Order(3)
    void deleteAll() {
        secteurActiviteRepository.deleteAll();
        assertEquals(0,secteurActiviteRepository.findAll().spliterator().estimateSize());
    }
    @org.junit.jupiter.api.Test
    @Order(2)
    void retrieveSecteurActivite() {
        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteurActivite))
        ;
        ActivitySector user1 = secteurActiviteServiceImpl.retrieveActivitySector(2L);
        Assertions.assertNotNull(user1);

    }
    @org.junit.jupiter.api.Test
    @Order(4)
    void getSecteurActivite(){
        Iterable<ActivitySector> LSecteurActivite = secteurActiviteRepository.findAll();
        Assertions.assertNotNull(LSecteurActivite);
    }
}