package edu.mst.cs3100.s18.t13.calculator;

import java.util.ArrayList;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class CalculatorModel {

    /* Member Variables ***************************************************************************/

    private DoubleEvaluator m_evaluator;
    private double m_result;
    private String m_equation;

    /* Constructors *******************************************************************************/

    private CalculatorModel() {
        this.observers = new ArrayList<>();
        this.allObservers = new AllObservers( this );

        this.m_evaluator = new DoubleEvaluator();
        this.m_result = 0.0;
        this.m_equation = "";
    }

    CalculatorModel( CalculatorModelObserver observer ) {
        this();

        this.addObserver( observer );
    }

    /* Accessors **********************************************************************************/

    double getResult() {
        return m_result;
    }

    String getEquation() {
        return this.m_equation;
    }

    /* Manipulators *******************************************************************************/

    void newEquationEntered( String newEquation ) {

        this.m_equation = newEquation;
        allObservers.equationDidChange();

        this.m_result = this.m_evaluator.evaluate( newEquation );
        allObservers.equationDidChange();
    }

    /* Observer Handling **************************************************************************/

    /* Member Variables */
    private ArrayList<CalculatorModelObserver> observers;
    private AllObservers allObservers;

    /* Observer Management ************************************************************************/

    void addObserver( CalculatorModelObserver newObserver ) {
        this.observers.add( newObserver );
    }

    boolean removeObserver( CalculatorModelObserver observerToRemove ) {

        for (int i = 0; i < this.observers.size(); i++) {
            if( this.observers.get( i ) == observerToRemove ) {
                this.observers.remove( i );
                return true;
            }
        }

        return false;
    }

    private ArrayList<CalculatorModelObserver> getObservers() {
        return this.observers;
    }

    /* Notification System ************************************************************************/

    private class AllObservers implements CalculatorModelObserver {

        /* Model Under Observation */
        CalculatorModel m_observedModel;

        /* Constructor */
        private AllObservers( CalculatorModel observedModel ) {
            this.m_observedModel = observedModel;
        }

        /* Delegate Functions */

        @Override
        public void equationDidChange() {
            for (CalculatorModelObserver observer : this.m_observedModel.getObservers()) {
                observer.equationDidChange();
            }
        }

        @Override
        public void resultDidChange() {
            for (CalculatorModelObserver observer : this.m_observedModel.getObservers()) {
                observer.resultDidChange();
            }
        }
    }
}
