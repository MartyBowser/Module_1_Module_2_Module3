
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

const btn = document.querySelector("button");
btn.addEventListener('click', (event) => {


    const val1 = document.getElementById("input1").value;
    const val2 = document.getElementById("input2").value;

    document.getElementById("result").innerText = Number.parseInt(val1) + Number.parseInt(val2);
}
);





    
