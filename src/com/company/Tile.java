package com.company;

import java.util.Objects;

public class Tile {
    private boolean isCrossed = false;
    private int number;

    public void setCrossed(boolean crossed) {
        isCrossed = crossed;
    }

    public boolean isCrossed() {
        return isCrossed;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return isCrossed == tile.isCrossed && number == tile.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCrossed, number);
    }
}
