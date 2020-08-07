package ru.netology.manager;

import ru.netology.domain.Proposal;
import ru.netology.repository.Repository;


public class ProposalManager {
    private final Repository repository;

    public ProposalManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Proposal product) {
        repository.add(product);
    }

    public Proposal[] searchBy(String text, String text2) {
        Proposal[] result = new Proposal[0];
        for (Proposal product : repository.findAll()) {
            if (product.matches(text, text2)) {
                Proposal[] tmp = new Proposal[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}

