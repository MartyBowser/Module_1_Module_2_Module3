/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const myName = "Christopher";
 
  console.log(myName);

  const myAge = 37;
  console.log(myAge);

  // Declares a variable those value can be changed
  let numCats = 2;
  console.log(numCats);
  numCats = 3;
  console.log(numCats);
  numCats = "Airhorn & Salem";
  console.log(numCats);

  // Declares a variable that will always be an array
  const week = [
    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
  ];

  const daysStartingWithT = [];
  for(let anything of week){
    if(anything && anything.toString().toUpperCase().startsWith("T")){
      daysStartingWithT.push(anything);
    }
  }

  week.push("Saturday");
  week.push("Sunday");

 // console.table(week);
  console.log(week);

  const arr1 = [1,2,3];
  const arr2 = [4,5,6];
  const arr3 = arr1.concat(arr2);
  console.log(arr3);
  
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

function promptForName() {

  const myName = prompt("Please Enter Your Name");
  if(myName) {
    alert("Welcome " + myName);
  } else {
    alert("You did not enter anything");
  }

}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ]
  };

  // Log the object
  console.log(person);

  // Log the first and last name
  console.log(person.firstName);
  console.log(person.lastName);

  // we can also add new fields on the fly
  person.middleName = "Frank";
  console.log(person.middleName);

  // Log each employee
  console.log("**************");
  //regular for loop
  for(let i =0; i < person.employees.length; i++) {
    console.log(person.employees[i]);
  }
  console.log("**************");
  //foreach loop
  for(let employee of person.employees){
    console.log(employee);
  }
  console.log("**************");
  //for loop going through fields in object
  for(let field in person){
    console.log(field);
  }
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  console.log("First Add Function")
  return num1 + num2;
}

function Add(num1, num2, num3) {
  console.log("Second Add Function")
  if(num3) {
    return num1 + num2 + num3;
  } else {
    return num1 + num2;
  }
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99)); // round down
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));//round up
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}

function arrFxns() {

  //declare an array
  const myArray = ["Thor","Hulk","Black Widow", "Iron Man"];

  //add to the end of the array
  myArray.push("Captain America");

  //add to the beginning of the array
  myArray.unshift("Falcon");

  console.table(myArray);

  //remove from the end of the array
  const val = myArray.pop();
  
  //to manually set a break point - you can type "debugger" or set a breakpoint
  //under the sources tab in chrome developer tools
  //debugger;
  
  console.log(val);
  console.table(myArray);

  //remove from the beginning of an array
  const val2 = myArray.shift();

  console.log(val2);
  console.table(myArray);

  //access by index
  console.log(myArray[0]);

  countElements(myArray);
}

/*
public int countElements(int[] myArray) {

}
*/


function countElements(myArray) {
  if(myArray) {
    return myArray.length;
  }
  return 0;
}

function createPerson(firstName, lastName, age){
  let person = {
    name: firstName + " " + lastName,
    age: age
  };

  person.favoriteMovie = "Morbius";

  return person;
}


function templateLiteralExample(){

  const myName = "Christopher";

  // utilizing string concatenation
  const myString = "Hello " + myName;
  console.log(myString);

  //or we can use template literals
  const myString2 = `Hello ${myName}`;
  console.log(myString2);

}
