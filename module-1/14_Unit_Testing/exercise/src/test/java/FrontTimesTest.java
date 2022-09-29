import com.techelevator.FrontTimes;
import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test
    public void front_Times_Test_uno(){

        //Arrange
        FrontTimes happyTimes = new FrontTimes();

        //Act
        String results = happyTimes.generateString("Chocolate", 2);

        //Assert
        Assert.assertEquals("ChoCho", results);

    }
     @Test
    public void front_Times_Test_duos(){

        //Arrange

         FrontTimes sadTimes = new FrontTimes();

         //Act
         String results = sadTimes.generateString("Chocolate", 3);

         //Assert
         Assert.assertEquals("ChoChoCho",results );



     }

     @Test
    public void front_Times_Test_trois(){

        //Arrange
         FrontTimes blahTimes = new FrontTimes();

         //Act
         String results = blahTimes.generateString("Chocolate",4);

    //Assert
         Assert.assertEquals("ChoChoChoCho", results);

    }




}

