package data_layer;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import se.lexicon.jpa_workshop.data_layer.impl.DetailsDAO;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Details;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@Rollback
@SpringBootTest
public class DetailsDAOTest {


    DetailsDAO detailsDAO;

    @Test
    public void persistDetails()
    {


        Details details = new Details("Test", "User");

        detailsDAO.create(details);

        assertNotNull(details);
    }

}
