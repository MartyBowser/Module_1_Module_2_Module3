import com.techelevator.WordCount;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    @Test
    public void get_count_words(){
        //Arrange
        //Create an instance of the class we want to test
        WordCount wordCount= new WordCount();
        String[] words= {"ba", "ba", "black", "sheep"};
        Map<String,Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);
        //Act
        //We call the method we want to test
        //and store the result will match
        //the data type of the result will match
        // the return type of the method we are calling
        Map <String, Integer> result = wordCount.getCount(words);


        //Assert

        Assert.assertEquals(expected, result);
    }


}
