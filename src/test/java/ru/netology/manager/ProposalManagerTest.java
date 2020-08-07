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

    @BeforeEach

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void searchBy() {
        manager.searchBy("SVO", "KUF");

        Proposal[] expected = new Proposal[] {first};
        Proposal[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}