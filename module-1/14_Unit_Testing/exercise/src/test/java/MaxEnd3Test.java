import com.techelevator.MaxEnd3;
import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test
    public void Test_All_Arrays_1() {
        //Arrange

        MaxEnd3 madMaxium = new MaxEnd3();

        //Act
        int[] result = madMaxium.makeArray(new int[]{1, 2, 3});


        //Assert
        Assert.assertArrayEquals(new int[]{3, 3, 3}, result);

    }

    @Test
    public void Test_All_Arrays_2() {
        //Arrange

        MaxEnd3 madMaxium1 = new MaxEnd3();

        //Act
        int[] result = madMaxium1.makeArray(new int[]{11, 5, 9});


        //Assert
        Assert.assertArrayEquals(new int[]{11, 11, 11}, result);

    }

    @Test
    public void Test_All_Arrays_3() {
        //Arrange

        MaxEnd3 madMaxium2 = new MaxEnd3();

        //Act
        int[] result = madMaxium2.makeArray(new int[]{2, 11, 3});


        //Assert
        Assert.assertArrayEquals(new int[]{3, 3, 3}, result);



}






}

