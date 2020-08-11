package ru.netology.repository;

import ru.netology.domain.Proposal;

public class Repository {
    private Proposal[] proposals = new Proposal[0];

    public void add(Proposal item) {
        int length = proposals.length + 1;
        Proposal[] tmp = new Proposal[length];
        System.arraycopy(proposals, 0, tmp, 0, proposals.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        proposals = tmp;
    }

    public Proposal[] findAll() {
        return proposals;
    }

}
