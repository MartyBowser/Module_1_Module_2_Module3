
/*const numbers = [3,7,9,100]

numbers.forEach(
    (number) => {
        const newDiv = document.createElement("div");
        newDiv.innerText = number;
        newDiv.setAttribute("class","red");
        newDiv.setAttribute("id", "div"+number);
        newDiv.setAttribute("completelyCustom","100")
    
        const body = document.querySelector("body");
        body.appendChild(newDiv);
        //  body.insertAdjacentElement('beforeend', newDiv)
    }

);*/
let toggleSize = false;
const div = document.getElementById("sumDiv");
div.addEventListener("mouseover", (event) => {
    event.target.style.height = "300px";
    console.log("On Mouse Over!")
});
div.addEventListener("click", (event) => {
    if(!toggleSize) {
        event.target.style.height = "600px"; 
    } else {
        event.target.style.height = "200px";
    }
    toggleSize = !toggleSize;
    console.log("On Mouse Over!")
});
div.addEventListener("mouseout", (event) => {

    event.target.style.height = "200px"
    console.log("On Mouse Leave!")
});


const btn = document.querySelector("button");
btn.addEventListener('click', (event) => {

    //If you want to time something so it is on a delay, you can use
    // the setTimeout function below and then specify the number of milliseconds
    setTimeout(() => {
        alert("It has been 3 seconds since you clicked on this button")
    }, 3000);


    const val1 = document.getElementById("input1").value;
    const val2 = document.getElementById("input2").value;

    document.getElementById("result").innerText = Number.parseInt(val1) + Number.parseInt(val2);
}
);

/*
//example of named function:
function calculate(input) {
    // some code in here
}

//same example, but anonymous
(input) => {
    // some code in here
}
*/


const inputs = document.querySelectorAll("input");
inputs.forEach(
    (input) => {

        //add an event listener to each input
        input.addEventListener('keyup', 
        (event) => {

            //if I want the html element that the event
            //happened to
            const element = event.target;
            console.log(element.value);

            //if I want to see the key that was pressed
            //to prompt the event:
            if(event.key === "Enter") {
                calculateSum();
            }
        }
        );

        input.addEventListener('change', 
        (myEvent) => {
            
            calculateSum();
        }
        )

        input.addEventListener('focus', (event) => {
            debugger;
            event.target.style.height="35px";
            console.log("On Focus!")
        });

        input.addEventListener('blur', (event) => {
            event.target.style.height="20px";
            console.log("On Blur!")
        });

    }

);


function calculateSum () {
    let val1 = document.getElementById("input1").value;
    let val2 = document.getElementById("input2").value;

    if(!val1) {
        val1 = 0;
    }

    if(!val2) {
        val2 = 0;
    }

    document.getElementById("result").innerText = Number.parseInt(val1) + Number.parseInt(val2);
}


    
