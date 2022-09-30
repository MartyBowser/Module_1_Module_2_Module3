import com.techelevator.SameFirstLast;
import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    @Test

    public void hi_my_name_is() {

        //Arrange
        SameFirstLast yuyuHakusho = new SameFirstLast();

        //Act
        boolean result = yuyuHakusho.isItTheSame(new int[]{1, 2, 3});

        //Assert
        Assert.assertEquals(false, result);
    }

    @Test

    public void ficka_ficka_() {

        //Arrange
        SameFirstLast allOfOne = new SameFirstLast();

        //Act
        boolean result = allOfOne.isItTheSame(new int[]{1, 2, 3, 1});

        //Assert
        Assert.assertEquals(true, result);
    }

    @Test

    public void slim_shady() {

        //Arrange
        SameFirstLast oneOfAll = new SameFirstLast();

        //Act
        boolean result = oneOfAll.isItTheSame(new int[]{1, 2, 1});

        //Assert
        Assert.assertEquals(true, result);
    }
}