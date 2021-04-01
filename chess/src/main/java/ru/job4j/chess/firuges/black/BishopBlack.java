package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest))  {
            throw new ImpossibleMoveException("Could not way by diagonal from %s to %s", position, dest);

        }
        int size = Math.abs(dest.getX() - position.getX());   /*число шагов фигуры - размер массива*/
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - position.getX()) / size; /* расчет дельты по Х */
        int deltaY = (dest.getY() - position.getY()) / size; /* расчет дельты по Y */
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x + deltaX, y + deltaY);
            x += deltaX;
            y += deltaY;
        }
        return steps;
    }


    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = true;
        if (Math.abs(dest.getX() - position.getX()) != Math.abs(dest.getY() - position.getY())) {
            rsl = false;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
