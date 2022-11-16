/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

function printText(){
  console.log("Hello World");
}

/*
In Java:
public int returnOne(){
  return 1;
}

public void printText(){
  System.out.println("Hello World");
}

*/





/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/*
In Java:
public void printToConsole(String value){
  System.out.println(value);
}


*/

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function multiplyNoUndefined(firstParameter=0, secondParameter=0){
  return firstParameter * secondParameter;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  debugger;
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {

 
  {
    const spiderman = "tobey";

  }
  {
    const spiderman = "tom";
  }
  const spiderman = "andrew";
  


  


  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

//If we want to generate JS doc ... type /** and hit enter
/**
 * 
 * @param {string} name 
 * @param {int} age 
 * @param {array} listOfQuirks 
 * @param {string} separator 
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

// named function
function printValue(num){
  console.log(num);
}

/* anonymous function:

(num) => {
  console.log(num);
}
*/
/* Javascript gives us some really great array functions out of the box*/
function forEachExample(){

  const myArray = [1,2,5,7,9];

  // when we pass a function to another function, that's like we are handing over
  // an instruction manual for how to do something
 // myArray.forEach(printValue);

 //or we can pass it an anonymous function
  myArray.forEach((num) => {
    console.log(num);
  });

  for(let num of myArray) {
    console.log(num);
  }

}

/* The map function will transform one array of objects into another array of objects. It 
maps one to the other */
function myMapExample(){

  const personList = [
    {firstName: "Christopher", lastName: "Guarnera"},
    {firstName: "Bob", lastName: "Smith"},
    {firstName: "Joe", lastName: "Jeffries"},
    {firstName: "Jane", lastName: "Smith"}
  ];
 
  const names = personList.map(
    (person) => {
      return person.firstName + " " + person.lastName;
    }
  );

  // this is the equivalent of using map above but instead with a for loop
  const names2 = [];
  for(let person of personList) {
    const name = person.firstName + " " + person.lastName;
    names2.push(name) ;
  }

  debugger;
}
function checkIfStartsWithJ(person)  {
  return person.firstName.startsWith("J");
}

function myFilterExample() {
  const personList = [
    {firstName: "Christopher", lastName: "Guarnera"},
    {firstName: "Bob", lastName: "Smith"},
    {firstName: "Joe", lastName: "Jeffries"},
    {firstName: "Jane", lastName: "Smith"}
  ];

  const personWithJ = personList.filter(
    // or we could call checkIFStartsWithJ
    (person) => {
      return person.firstName.startsWith("J");
    }
  );

  personWithJ.forEach(
    (person) => {
      console.log(person.firstName);
    }
  );

  // this would be the equivalent of how we did the .filter above
  // but instead using the for loop
  const personWithJ2 = [];
  for(let person of personList){
    if(person.firstName.startsWith("J")){
      personWithJ2.push(person);
    }
  }

 // debugger;
}


/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
// for instance [1,3,5,9,7]
function sumAllNumbers(numbersToSum) {
  const defaultValue = 0;
  return numbersToSum.reduce(
    (sum, currentVal) => {
      debugger;
      return sum + currentVal;
      
    }, defaultValue
  );

  /*
  let sum = 0;
  for(let num of numbersToSum){
    sum = sum + num;
  }
  */
}





/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter(
    (x) => {
      return x % 3 === 0
    }
  )
}

function concatAllStrings(){


  // arguments - keyword that represents all the arguments passed into this method by a user
  // Array.from - this is a built in library that javascript has and can convert arguments into an array
  const myStrings = Array.from(arguments);


  const result =  myStrings.reduce(
    (resultFromPrevious, currentValue) => {
      return resultFromPrevious + " " + currentValue;
    }, ""
  );

  return result.trim();
};



// [100,150,95,3,200,1000]
function findMax(nums) {

  return nums.reduce(
    (prevVal, currentValue) => {
      if(prevVal > currentValue) {
        return prevVal;
      } else {
        return currentValue;
      }
    }
  );

}

// Use .filter when you want to get only a subset of your array based on some condition
// Use .map when you want to transform each element inside of your array
// Use .reduce when you want to reduce the array to a single value (sum, concat, max, min, etc.)
// Use .forEach when you just want to iterate through every value

const addresses = [{
  street: "123 Main St",
  city: "Columbus",
  zip: "43085",
  state: "OH"
}]

function printAddress(addresses){
  
  return addresses.map(
    (x) => {
      return x.street + " " + x.city + " " + x.state + " " + x.zip;
    }
  )

}


// forEach example 2
function forEachExample2 ( arrayOfNums ) {

  let largest = 0;
  arrayOfNums.forEach(
    (num) => {
      if(num > largest) {
        largest = num;
      }
    }
  ); 
/*
  for(let num of arrayOfNums){
   
  } */

  return largest;
}