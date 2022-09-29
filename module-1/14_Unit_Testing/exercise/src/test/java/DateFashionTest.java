import com.techelevator.DateFashion;
import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

@Test
    public void date_fashion(){

    //Arrange

    DateFashion eliteFashion = new DateFashion();
    int results = eliteFashion.getATable(5,10);

    //Assert
    Assert.assertEquals(2,results);
}
    @Test
    public void date_fashion_part_two(){

    //Arrange
        DateFashion supremeFashion = new DateFashion();

        //Act
        int results = supremeFashion.getATable(5,2);

        //Assert
        Assert.assertEquals(0, results);


    }
        @Test

    public void  date_fashion_trois_test(){
    //Arrange
            DateFashion hippieFashion = new DateFashion();

            //Act
            int results = hippieFashion.getATable(5,5);


            //Assert
            Assert.assertEquals(1, results);





        }




}

