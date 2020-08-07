package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Proposal implements Comparable<Proposal> {
    private int id;
    private String departureAirport;
    private String arrivalAirport;
    private int price;
    private int flightTime;

    @Override
    public int compareTo(Proposal o) {
        Proposal proposal = (Proposal) o;
        return price - ((Proposal) o).price;
    }

    public boolean matches(String search, String text2) {
        if (search.equalsIgnoreCase(departureAirport) & search.equalsIgnoreCase(arrivalAirport)) {
            return true;
        }
        return false;
    }


}



