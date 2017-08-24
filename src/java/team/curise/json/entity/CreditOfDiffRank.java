/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity;

/**
 *
 * @author pupu
 */
public class CreditOfDiffRank {

    private int A;
    private int B;
    private int C;
    private int D;
    private int E;

    /**
     * @return the A
     */
    public int getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(int A) {
        this.A = A;
    }

    /**
     * @return the B
     */
    public int getB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(int B) {
        this.B = B;
    }

    /**
     * @return the C
     */
    public int getC() {
        return C;
    }

    /**
     * @param C the C to set
     */
    public void setC(int C) {
        this.C = C;
    }

    /**
     * @return the D
     */
    public int getD() {
        return D;
    }

    /**
     * @param D the D to set
     */
    public void setD(int D) {
        this.D = D;
    }

    /**
     * @return the E
     */
    public int getE() {
        return E;
    }

    /**
     * @param E the E to set
     */
    public void setE(int E) {
        this.E = E;
    }

    public CreditOfDiffRank(int[] array) {
        this.A = array[0];
        this.B = array[1];
        this.C = array[2];
        this.D = array[3];
        this.E = array[4];
    }

}
