package dynamicProgrammingTest;

import dynamicProgramming.MatrixChainMul;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixChainMulTest {
    MatrixChainMul instance;
    int[] dimensions = {5, 7, 3, 9, 4, 2};
    int[] dimensions2 = { 40, 20, 30, 10, 30 };

    @Before
    public void setUp() {
        instance = new MatrixChainMul();
    }

    @Test
    public void testMatrixChain() {
        System.out.println("MatrixChainMul: testing matrix chain multiplication recursive");
        int expectedResult = 238;
        Assert.assertEquals(expectedResult, instance.matrixChain(dimensions, 1, dimensions.length - 1));
    }

    @Test
    public void testMatrixChainDp() {
        System.out.println("MatrixChainMul: testing matrix chain multiplication dynamic programming");
        int expectedResult = 238;
        Assert.assertEquals(expectedResult, instance.matrixChainDp(dimensions));
        instance.matrixChainDp(dimensions2);
    }

    @Test
    public void testNumOfParam() {
        System.out.println("MatrixChainMul: testing number of possible parameterizations recursive");
        int expectedResult = 14;
        Assert.assertEquals(expectedResult, instance.noOfPossibleParent(5));
//        instance.matrixChainDp(dimensions2);
    }

    @Test
    public void testNumOfParamDp() {
        System.out.println("MatrixChainMul: testing number of possible parameterizations dynamic programming");
        int expectedResult = 14;
        Assert.assertEquals(expectedResult, instance.noOfPossibleParentDp(5));
//        instance.matrixChainDp(dimensions2);
    }
}
