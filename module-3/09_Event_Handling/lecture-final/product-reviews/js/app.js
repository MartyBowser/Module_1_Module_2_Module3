const book_name = 'Ghost Hunting for Dummies';
const description = 'Learn how to hunt ghosts like the professionals.';
const reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Caught a ghost in less than 4 hours.',
    review:
      "It should have been called the four hour ghost hunt. That's amazing.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but at the end you realize that you yourself are actually a ghost.",
    rating: 3
  }
];

/**
 * Add product name to the page title.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = book_name;
}

/**
 * Add product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * Display all of the reviews in the reviews array.
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 * Add single review to the page.
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer;
  tmpl.querySelector('h3').innerText = review.title;
  tmpl.querySelector('p').innerText = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

//When we want to wait for the page to load before running any javascript
//we can put an event listener for DOMContentLoaded
document.addEventListener('DOMContentLoaded', (event) => {

  // Set the product reviews page title.
  setPageTitle();
  // Set the product reviews page description.
  setPageDescription();
  // Display all of the product reviews on our page.
  displayReviews();

  const desc = document.querySelector(".description");
  desc.addEventListener('click', toggleDescriptionEdit)

  const inputDesc = document.getElementById("inputDesc")
  inputDesc.addEventListener("mouseleave", callExitDescriptionEdit)
  inputDesc.addEventListener("keyup", (event) => {
      if(event.key === "Enter") {
        exitDescriptionEdit(event.target, true);
      }
  })

  const btnToggleForm = document.getElementById("btnToggleForm");
  btnToggleForm.addEventListener('click', (event) => {
    showHideForm();
  })

  const btnSaveReview = document.getElementById("btnSaveReview");
  btnSaveReview.addEventListener('click', (event) => {
    event.preventDefault();
    saveReview();
  })


});

function callExitDescriptionEdit(event){
  exitDescriptionEdit(event.target, false);
}

/**
 * Hide the description and show the text box.
 *
 * @param {Element} desc the element containing the description
 */
function toggleDescriptionEdit(event) {
  const desc = event.target;
  const textBox = desc.nextElementSibling;
  textBox.value = desc.innerText;
  textBox.classList.remove('d-none');
  desc.classList.add('d-none');
  textBox.focus();
}

/**
 * Hide the text box and show the description.
 * If save is true, also set the description to the contents of the text box.
 *
 * @param {Element} textBox the input element containing the edited description
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    desc.innerText = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * Toggle visibility of the add review form.
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none');
    btn.innerText = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * Reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * Save the review that was added using the add review form.
 */
function saveReview() {

  const nameInput = document.getElementById("name");
  const titleInput = document.getElementById("title");
  const ratingInput = document.getElementById("rating");
  const reviewInput = document.getElementById("review");

  let newReview = {
    reviewer: nameInput.value,
    title: titleInput.value,
    review: reviewInput.value,
    rating: ratingInput.value
  }

  /*
  Or we could have created a new object like this:
  let newReview = {};
  newReview.reviewer = nameInput.value;
  */

  reviews.push(newReview);
  displayReview(newReview);
  showHideForm();

}
