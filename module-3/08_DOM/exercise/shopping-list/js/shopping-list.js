// add pageTitle
const pageTitle = "My Shopping List";

const groceries = ["bread", "butter", "milk", "crackers", "cereal", "juice", "fruit", "condiments", "paperTowel", "napkins"];

function setPageTitle() {
  document.getElementById("title").innerText = pageTitle;
  groceries.forEach;
}

function displayGroceries() {
  for(let i =0; i < groceries.length; i ++){
    const shoppingList = document.getElementById("groceries");
    const list = document.createElement("li");
    list.innerText = groceries[i];
    shoppingList.appendChild(list);
  }
}

function markCompleted() {
  const shopping = document.querySelectorAll("li");
  shopping.forEach(
    (item) => {
      item.setAttribute("class", "completed");
    }
  )
}

setPageTitle();

displayGroceries();


document.addEventListener('DOMContentLoaded', () => {
  
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
