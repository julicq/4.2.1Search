package ru.netology.manager;

import ru.netology.domain.Proposal;
import ru.netology.repository.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;


public class ProposalManager {
    private final Repository repository;

    public ProposalManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Proposal product) {
        repository.add(product);
    }

    public Proposal[] searchBy(String from, String to) {
        Proposal[] result = new Proposal[0];
        for (Proposal proposal : repository.findAll()) {
            if ((from == proposal.getDepartureAirport()) & (to == proposal.getArrivalAirport())) {
                Proposal[] tmp = new Proposal[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = proposal;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }
}

