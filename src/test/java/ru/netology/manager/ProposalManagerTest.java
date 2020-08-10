package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Proposal;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProposalManagerTest {

    private final Repository repository = new Repository();
    private final ProposalManager manager = new ProposalManager(repository);
    private final Proposal first = new Proposal(1, "SVO", "KUF", 2800, 90);
    private final Proposal second = new Proposal(2, "DME", "KUF", 2500, 100);
    private final Proposal third = new Proposal(3, "SVO", "LED", 2200, 80);
    private final Proposal fourth = new Proposal(4, "SVO", "LED", 2800, 65);
    private final Proposal fifth = new Proposal(5, "KUF", "KZN", 5400, 85);
    private final Proposal sixth = new Proposal(6, "SVO", "LED", 2200, 80);


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

        Proposal[] expected = new Proposal[] {third, fourth, sixth};
        Proposal[] actual = manager.searchBy("SVO", "LED");
        assertArrayEquals(expected, actual);
    }
}