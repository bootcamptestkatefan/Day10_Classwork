package com.oocl.web.sampleWebApp.jpaSample;

import com.oocl.web.sampleWebApp.SingleEntity;
import com.oocl.web.sampleWebApp.SingleEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SingleEntityTest {
@Autowired
    private SingleEntityRepository singleEntityRepository;

    @Test
    public void should_fetch_entity(){
        final SingleEntity singleEntity = new SingleEntity();
        singleEntity.id = 1L;
        singleEntity.name = "Hello";
        singleEntityRepository.save(singleEntity);

        final SingleEntity fetched = singleEntityRepository.getOne(1L);

        assertEquals("Hello", fetched.name);
    }
}
