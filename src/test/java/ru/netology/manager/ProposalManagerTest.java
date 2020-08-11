package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Proposal;
import ru.netology.repository.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProposalManagerTest {
    private Repository repository = new Repository();
    private ProposalManager manager = new ProposalManager(repository);
    private Proposal first = new Proposal(1, "SVO", "KUF", 2800, 90);
    private Proposal second = new Proposal(2, "DME", "KUF", 2500, 100);
    private Proposal third = new Proposal(3, "SVO", "LED", 2200, 80);
    private Proposal fourth = new Proposal(4, "SVO", "LED", 2800, 65);
    private Proposal fifth = new Proposal(5, "KUF", "KZN", 5400, 85);
    private Proposal sixth = new Proposal(6, "SVO", "LED", 2000, 89);


    @BeforeEach

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void shouldFindFromAndToInProposal() {
        manager.searchBy("SVO", "LED");

        Proposal[] expected = new Proposal[] {sixth, third, fourth};
        Proposal[] actual = manager.searchBy("SVO", "LED");
        assertArrayEquals(expected, actual);
    }
}