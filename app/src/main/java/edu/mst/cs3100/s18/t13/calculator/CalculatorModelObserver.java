package edu.mst.cs3100.s18.t13.calculator;

public interface CalculatorModelObserver {

    /* Called when the equation string is updated */
    void equationDidChange();

    /* Called when the result of the equation has changed */
    void resultDidChange();
}
